package com.example.evelin.controller;

import com.example.evelin.dto.ContactDto;
import com.example.evelin.model.Contact;
import com.example.evelin.model.Result;
import com.example.evelin.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping
    public HttpEntity<?> getContacts(@PathVariable Integer id) {
        List<Contact> all = contactService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getContactById(@PathVariable Integer id) {
        Contact contact = contactService.findById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addContact(@RequestBody ContactDto contactDto) {
        Result save = contactService.save(contactDto);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateContact(@PathVariable Integer id, @RequestBody ContactDto contactDto) {
        Result update = contactService.update(id, contactDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteContact(@PathVariable Integer id) {
        Result delete = contactService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
