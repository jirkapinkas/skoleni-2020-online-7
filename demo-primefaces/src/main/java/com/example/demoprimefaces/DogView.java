package com.example.demoprimefaces;

import com.example.demoprimefaces.entity.Dog;
import com.example.demoprimefaces.service.DogService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.util.TagUtils;

import javax.annotation.PostConstruct;
import java.util.List;

@Scope(TagUtils.SCOPE_SESSION)
@Component
@RequiredArgsConstructor
public class DogView {

    private final DogService dogService;

    @Getter
    private Dog dog;

    @Getter
    private List<Dog> dogs;

    @PostConstruct
    public void init() {
        dog = new Dog();
        dogs = dogService.findAll();
    }

    public void save() {
        dogService.save(dog);
        init();
    }

}
