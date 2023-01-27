package com.onlineshopping.amazon.service;

//Static import getEntityProduct Java 5

import com.onlineshopping.amazon.entity.Product;
import com.onlineshopping.amazon.exception.ProductException;
import com.onlineshopping.amazon.exception.SupplierException;
import com.onlineshopping.amazon.repository.ProductRepository;
import com.onlineshopping.amazon.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service  //Annotation java 5
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;

//    byte b1 = 0b101; //Binary Literal Java 8

    public List<com.onlineshopping.amazon.vo.Product> getProducts() {
        List<com.onlineshopping.amazon.vo.Product> list = new ArrayList<>();// Generics Java 5
        for (Product p : productRepository.findAll()) {    //For Each loop Java 5
            list.add(getVoProduct(p));
        }
        return list;
    }

    public com.onlineshopping.amazon.vo.Product getById(int pid) {
        return getVoProduct(productRepository.findById(pid).
                orElseThrow(() -> new ProductException("Product Not Found with ProductId :" + pid)));

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String saveProduct(List<com.onlineshopping.amazon.vo.Product> products) {
        List<Product> pro = new ArrayList<>();
        for (com.onlineshopping.amazon.vo.Product product1 : products) {
            pro.add(getEntityProduct(product1));
        }
        productRepository.saveAll(pro);
        return "Product Saved";

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String updateProduct(com.onlineshopping.amazon.vo.Product product1) {
        Product product = getEntityProduct(product1);
        if (productRepository.findById(product.getProductID()).isEmpty()) {
            throw new ProductException("Product Not Found with ProductId :" + product.getProductID());
        } else {
            productRepository.save(product);
        }
        return "Product Updated";
    }

    public String deleteProduct(int pid) {
        if (productRepository.findById(pid).isEmpty()) {
            throw new ProductException("Product Not Found with ProductId :" + pid);
        } else {
            productRepository.deleteById(pid);
            return "Product Deleted Having ProductId: " + pid;
        }
    }

    public com.onlineshopping.amazon.vo.Product getVoProduct(Product p1) {
        return com.onlineshopping.amazon.vo.Product.builder().productID(p1.getProductID()).productName(p1.getProductName()).
                price(p1.getPrice()).unit(p1.getUnit()).supplierId(p1.getSupplierId()).productImage(p1.getProductImage()).build();
    }


    public Product getEntityProduct(com.onlineshopping.amazon.vo.Product p1) {
        return Product.builder().productID(p1.getProductID()).productName(p1.getProductName()).
                unit(p1.getUnit()).productImage(p1.getProductImage()).price(p1.getPrice()).supplier(supplierRepository.findById(p1.getSupplierId()).
                        orElseThrow(() -> new SupplierException("Supplier Not Found With SupplierId: " + p1.getSupplierId()))).supplierId(p1.getSupplierId()).build();
    }
}
