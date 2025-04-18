package com.example.evelin.service;

import com.example.evelin.dto.AddressDto;
import com.example.evelin.model.Address;
import com.example.evelin.model.Profile;
import com.example.evelin.model.Result;
import com.example.evelin.repository.AddressRepo;
import com.example.evelin.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    ProfileRepo profileRepo;

    public List<Address> getAddresses(){
        return addressRepo.findAll();
    }

    public Address getAddressById(Integer id){
        return addressRepo.findById(id).get();
    }

    public Result addAddress(AddressDto addressDto){
        Address address = new Address();

        Optional<Profile> optionalProfile = profileRepo.findById(addressDto.getProfile_id());
        Profile profile = optionalProfile.get();
        address.setProfile_id(profile);

        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setPostalCode(addressDto.getPostalCode());
        address.setCountry(addressDto.getCountry());
        addressRepo.save(address);
        return new Result(true,"Success");
    }

    public Result updateAddress(Integer id, AddressDto addressDto){
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();

            Optional<Profile> optionalProfile = profileRepo.findById(addressDto.getProfile_id());
            Profile profile = optionalProfile.get();
            address.setProfile_id(profile);

            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            address.setPostalCode(addressDto.getPostalCode());
            address.setCountry(addressDto.getCountry());
            addressRepo.save(address);
            return new Result(true,"updated successfully");
        }
        return new Result(false,"Address not found");
    }

    public Result deleteAddress(Integer id){
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if(optionalAddress.isPresent()){
            addressRepo.deleteById(id);
            return new Result(true,"delete successfully");
        }
        return new Result(false,"Address not found");
    }

}
