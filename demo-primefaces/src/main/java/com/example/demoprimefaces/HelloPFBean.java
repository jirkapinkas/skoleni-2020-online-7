package com.example.demoprimefaces;

import com.example.demoprimefaces.service.MyService;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.util.TagUtils;

import javax.annotation.ManagedBean;
import javax.inject.Named;

@Scope(TagUtils.SCOPE_REQUEST) // request scope
//@ManagedBean // javax.annotation.ManagedBean z toho udela Spring Bean
//@Named
//@Lazy // toto ma vyznam kdyz je scope singleton!
@Component
public class HelloPFBean {

    private MyService myService;

    public HelloPFBean(MyService myService) {
        System.out.println("helloPFBean constructed");
        this.myService = myService;
    }

    public String getData() {
        return myService.getData();
    }
}
