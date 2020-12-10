package com.example.demoprimefaces;

import com.example.demoprimefaces.entity.Dog;
import com.example.demoprimefaces.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.util.TagUtils;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import java.util.List;

@Scope(TagUtils.SCOPE_SESSION)
@ManagedBean
public class DogView {

    @Autowired
    private DogService dogService;

    private Dog dog;

    private List<Dog> dogs;

    @PostConstruct
    public void init() {
        dog = new Dog();
        dogs = dogService.findAll();
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void save() {
        dogService.save(dog);
        init();
    }

}
