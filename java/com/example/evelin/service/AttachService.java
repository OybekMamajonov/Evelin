package com.example.evelin.service;

import com.example.evelin.dto.AttachDto;
import com.example.evelin.model.Attach;
import com.example.evelin.model.Result;
import com.example.evelin.repository.AddressRepo;
import com.example.evelin.repository.AttachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachService {

    @Autowired
    AttachRepo attachRepo;

    public List<Attach> findAllAttaches() {
        return attachRepo.findAll();
    }

    public Attach getAttachesById(Integer id){
        return attachRepo.findById(id).get();
    }

    public Result addAttach(AttachDto attachDto){
//        boolean existsByOrigin_name = attachRepo.existsByOrigin_name(attachDto.getOrigin_name());
//        if(existsByOrigin_name){
//            return new Result(false, "this attach already exists");
//        }

        Attach attach = new Attach();
        attach.setOrigin_name(attachDto.getOrigin_name());
        attach.setSize(attachDto.getSize());
        attach.setType(attachDto.getType());
        attach.setPath(attachDto.getPath());
        attach.setDuration(attachDto.getDuration());
        attachRepo.save(attach);
        return new Result(true, "Attach added");
    }

    public Result updateAttach(Integer id, AttachDto attachDto){
        Optional<Attach> optionalAttach = attachRepo.findById(id);
        if(optionalAttach.isPresent()){
            Attach attach = optionalAttach.get();
            attach.setOrigin_name(attachDto.getOrigin_name());
            attach.setSize(attachDto.getSize());
            attach.setType(attachDto.getType());
            attach.setPath(attachDto.getPath());
            attach.setDuration(attachDto.getDuration());
            attachRepo.save(attach);
            return new Result(true, "Attach updated");
        }
        return new Result(false, "Attach not found");
    }

    public Result deleteAttach(Integer id){
        Optional<Attach> optionalAttach = attachRepo.findById(id);
        if(optionalAttach.isPresent()){
            attachRepo.deleteById(id);
            return new Result(true, "Attach deleted");
        }
        return new Result(false, "Attach not found");
    }

}
