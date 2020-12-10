package com.example.demoprimefaces.repository;

import com.example.demoprimefaces.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}