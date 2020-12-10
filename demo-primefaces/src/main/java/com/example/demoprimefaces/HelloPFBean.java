package com.example.demoprimefaces;

import com.example.demoprimefaces.service.MyService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.util.TagUtils;

import javax.annotation.PostConstruct;

@Slf4j
@Scope(TagUtils.SCOPE_REQUEST) // request scope
//@ManagedBean // javax.annotation.ManagedBean z toho udela Spring Bean
//@Named
//@Lazy // toto ma vyznam kdyz je scope singleton!
@Component("hello")
public class HelloPFBean {

    private MyService myService;

    public HelloPFBean(MyService myService) {
        log.info("helloPFBean constructed");
        this.myService = myService;
    }

    @Getter
    private String data;

    @PostConstruct
    public void init() {
        data = myService.getData();
    }

}
