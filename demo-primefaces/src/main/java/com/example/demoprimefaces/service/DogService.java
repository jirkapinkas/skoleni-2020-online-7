package com.example.demoprimefaces.service;

import com.example.demoprimefaces.entity.Dog;
import com.example.demoprimefaces.repository.DogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private static final Logger log = LoggerFactory.getLogger(DogService.class);

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
