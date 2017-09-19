package com.adamant.springassignment.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.logging.Logger;

/**
 * Created by Ivan on 19.9.2017.
 */
@Aspect
@Component
public class AspectTest {
    private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(requestMapping)")
    public void controller(GetMapping requestMapping){}

    @Before("controller(getMapping)")
    public void advice(JoinPoint jp, GetMapping getMapping) {
        LOGGER.info(jp.toString());
    }
}