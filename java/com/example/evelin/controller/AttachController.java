package com.example.evelin.controller;

import com.example.evelin.dto.AttachDto;
import com.example.evelin.model.Attach;
import com.example.evelin.model.Result;
import com.example.evelin.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attach")
public class AttachController {

    @Autowired
    AttachService attachService;

    @GetMapping
    public HttpEntity<?> getAllAttaches(){
        List<Attach> allAttaches = attachService.findAllAttaches();
        return new ResponseEntity<>(allAttaches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getAttachById(@PathVariable Integer id){
        Attach attachesById = attachService.getAttachesById(id);
        return new ResponseEntity<>(attachesById, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addAttach(@RequestBody AttachDto attachDto){
        Result result = attachService.addAttach(attachDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateAttach(@PathVariable Integer id, @RequestBody AttachDto attachDto){
        Result result = attachService.updateAttach(id, attachDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAttach(@PathVariable Integer id){
        Result result = attachService.deleteAttach(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
