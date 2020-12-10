package com.example.demoprimefaces.repository;

import com.example.demoprimefaces.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findByName(String name);

}