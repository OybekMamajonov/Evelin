package com.example.evelin.service;

import com.example.evelin.dto.IntroDto;
import com.example.evelin.model.Attach;
import com.example.evelin.model.Intro;
import com.example.evelin.model.Result;
import com.example.evelin.repository.AttachRepo;
import com.example.evelin.repository.IntroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntroService {

    @Autowired
    IntroRepo introRepo;

    @Autowired
    AttachRepo attachRepo;

    public List<Intro> findAll(){
        return introRepo.findAll();
    }

    public Intro getIntroById(Integer id){
        return introRepo.findById(id).get();
    }

    public Result addIntro(IntroDto introDto){
        Intro intro = new Intro();
        intro.setTitle(introDto.getTitle());
        intro.setDescription(introDto.getDescription());

        Optional<Attach> optionalAttach = attachRepo.findById(introDto.getImage_id());
        Attach attach = optionalAttach.get();
        intro.setImage_id(attach);
        introRepo.save(intro);
        return new Result(true,"intro added");
    }

    public Result updateIntro(Integer id, IntroDto introDto){
        Optional<Intro> optionalIntro = introRepo.findById(id);
        if(optionalIntro.isPresent()){
            Intro intro = optionalIntro.get();
            intro.setTitle(introDto.getTitle());
            intro.setDescription(introDto.getDescription());

            Optional<Attach> optionalAttach = attachRepo.findById(introDto.getImage_id());
            Attach attach = optionalAttach.get();
            intro.setImage_id(attach);
            introRepo.save(intro);
            return new Result(true,"intro updated");
        }
        return new Result(false,"intro not found");
    }

    public Result deleteIntro(Integer id){
        Optional<Intro> optionalIntro = introRepo.findById(id);
        if(optionalIntro.isPresent()){
            introRepo.deleteById(id);
            return new Result(true,"intro deleted");
        }
        return new Result(false,"intro not found");
    }

}
