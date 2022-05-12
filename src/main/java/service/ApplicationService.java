package service;

import entity.Application;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ApplicationRepository;

import java.util.List;
import java.util.Optional;

public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List <Application> listApplication(){
        return applicationRepository.findAll();

    }
    public Application findApplication(long id){
        Optional<Application>application= Optional.of(applicationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("dddd")
        ));

        return application.get();
    }





}
