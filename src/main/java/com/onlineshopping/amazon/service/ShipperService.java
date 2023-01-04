package com.onlineshopping.amazon.service;


import com.onlineshopping.amazon.entity.Shipper;
import com.onlineshopping.amazon.exception.ProductException;
import com.onlineshopping.amazon.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipperService {
    @Autowired
    ShipperRepository shipperRepository;

    public List<com.onlineshopping.amazon.vo.Shipper> getShippers() {
        List<com.onlineshopping.amazon.vo.Shipper> shippers = new ArrayList<>();
        for (Shipper s : shipperRepository.findAll())
            shippers.add(getVoShipper(s));
        return shippers;
    }

    public com.onlineshopping.amazon.vo.Shipper getVoShipper(Shipper shipper) {
        return com.onlineshopping.amazon.vo.Shipper.builder().shipperName(shipper.getShipperName()).shipperId(shipper.getShipperId()).phone(shipper.getPhone()).
                build();
    }

    public String saveShipper(com.onlineshopping.amazon.vo.Shipper shipperVo){
        Shipper shipper=getEntityShipper(shipperVo);
        shipperRepository.save(shipper);
        return "Shipper Saved";
    }

    public String deleteShipper(Integer sid ){
        shipperRepository.delete(shipperRepository.findById(sid).orElseThrow(()-> new ProductException("Shipper Not Found Wih Shipper Id: "+sid)));
        return "Shipper Deleted";
    }

    public Shipper getEntityShipper(com.onlineshopping.amazon.vo.Shipper shipperVo){
        return Shipper.builder().shipperName(shipperVo.getShipperName()).phone(shipperVo.getPhone()).build();
    }
}
