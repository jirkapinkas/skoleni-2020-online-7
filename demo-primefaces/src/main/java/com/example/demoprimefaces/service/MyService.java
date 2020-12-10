package com.example.demoprimefaces.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyService {

    public String getData() {
        log.info("called MyService.getData()");
        return "<strong>stuff from service</strong>";
    }

}
