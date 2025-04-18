package com.example.evelin.controller;

import com.example.evelin.dto.AddressDto;
import com.example.evelin.model.Address;
import com.example.evelin.model.Result;
import com.example.evelin.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public HttpEntity<?> getAddresses(){
        List<Address> addresses = addressService.getAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getAddressById(@PathVariable Integer id){
        Address address = addressService.getAddressById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addAddress(@RequestBody AddressDto addressDto){
        Result result = addressService.addAddress(addressDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto){
        Result result = addressService.updateAddress(id, addressDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAddress(@PathVariable Integer id){
        Result result = addressService.deleteAddress(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
