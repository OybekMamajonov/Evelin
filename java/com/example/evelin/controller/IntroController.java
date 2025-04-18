package com.example.evelin.controller;

import com.example.evelin.dto.IntroDto;
import com.example.evelin.model.Intro;
import com.example.evelin.model.Result;
import com.example.evelin.service.IntroService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intro")
public class IntroController {

    @Autowired
    IntroService introService;

    @GetMapping
    public HttpEntity<?> getIntros(){
        List<Intro> all = introService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getIntrosById(@PathVariable Integer id){
        Intro introById = introService.getIntroById(id);
        return new ResponseEntity<>(introById, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> saveIntros(@RequestBody IntroDto  introDto){
        Result result = introService.addIntro(introDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?>  updateIntros(@PathVariable Integer id, @RequestBody IntroDto introDto){
        Result result = introService.updateIntro(id,introDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?>  deleteIntros(@PathVariable Integer id){
        Result result = introService.deleteIntro(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
