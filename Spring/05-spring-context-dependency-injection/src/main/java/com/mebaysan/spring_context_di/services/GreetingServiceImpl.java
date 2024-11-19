package com.mebaysan.spring_context_di.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "(from GreetinServiceImpl) Hi folks!";

    }

}
