package com.example.evelin.service;

import com.example.evelin.dto.ContactDto;
import com.example.evelin.model.Contact;
import com.example.evelin.model.Profile;
import com.example.evelin.model.Result;
import com.example.evelin.repository.ContactRepo;
import com.example.evelin.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepo contactRepo;

    @Autowired
    ProfileRepo profileRepo;

    public List<Contact> findAll() {
        return contactRepo.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepo.findById(id).get();
    }

    public Result save(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        contact.setMassage(contactDto.getMassage());

        Optional<Profile> optionalProfile = profileRepo.findById(contactDto.getProfile_id());
        Profile profile = optionalProfile.get();
        contact.setProfile_id(profile);

        contact.setReply(contactDto.getReply());
        contactRepo.save(contact);
        return new Result(true, "contact saved successfully");
    }

    public Result update(Integer id, ContactDto contactDto) {
        Optional<Contact> optionalContact = contactRepo.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setName(contactDto.getName());
            contact.setEmail(contactDto.getEmail());
            contact.setPhone(contactDto.getPhone());
            contact.setMassage(contactDto.getMassage());

            Optional<Profile> optionalProfile = profileRepo.findById(contactDto.getProfile_id());
            Profile profile = optionalProfile.get();
            contact.setProfile_id(profile);

            contact.setReply(contactDto.getReply());
            contactRepo.save(contact);
            return new Result(true, "contact updated successfully");
        }
        return new Result(false, "contact not found");
    }

    public Result delete(Integer id) {
        Optional<Contact> optionalContact = contactRepo.findById(id);
        if (optionalContact.isPresent()) {
            contactRepo.deleteById(id);
            return new Result(true, "contact deleted successfully");
        }
        return new Result(false, "contact not found");
    }

}
