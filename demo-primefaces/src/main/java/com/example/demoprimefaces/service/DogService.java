package com.example.demoprimefaces.service;

import com.example.demoprimefaces.entity.Dog;
import com.example.demoprimefaces.repository.DogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public List<Dog> findAll() {
        log.info("before findAll");
        List<Dog> dogs = dogRepository.findAll();
        log.info("after findAll");
        return dogs;
    }

    public void save(Dog dog) {
        log.info("before save");
        dogRepository.save(dog);
        log.info("after save");
    }

}
