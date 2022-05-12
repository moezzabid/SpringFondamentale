package service;

import entity.Application;
import entity.Release;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ApplicationRepository;
import repository.ReleaseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;




    public List <Release>listRelease(){
        List <Release> releases=new ArrayList<>();
        releaseRepository.findAll().forEach(release -> releases.add(release));
        return releases ;

    }
    public Release findRelease(long id){
        Optional<Release> release= Optional.of(releaseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("dddd")
        ));

        return release.get();
    }

}
