package com.example.demoprimefaces.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double weight;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

}