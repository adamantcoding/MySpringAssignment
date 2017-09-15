package com.adamant.springassignment.aop;

import com.adamant.springassignment.domain.CarOwner;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Ivan on 15.9.2017.
 */
@Component
@Aspect
public class CarServiceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceAspect.class);

//    @Before("execution(* com.adamant.springassignment.service.CarService.findCarsByOwner(java.lang.Long) ) && args(id)")
//    public void execBeforeCarOwnerSet(CarOwner carOwner){
//        LOGGER.info("A car set is requested for the owner: id = %d, last name = %s", carOwner.getId(), carOwner.getLastName());
//    }

    @Around("execution(* com.adamant.springassignment.service.CarService.getOwner (java.lang.Long) ) && args(id)")
    public void execBeforeGetCarOwner(Long id){
        LOGGER.info("getOwner() is called for id = ", id);
    }
}