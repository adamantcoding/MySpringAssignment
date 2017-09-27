package com.adamant.springassignment;

import com.adamant.springassignment.domain.Car;
import com.adamant.springassignment.domain.CarModel;
import com.adamant.springassignment.domain.CarOwner;
import com.adamant.springassignment.repository.CarModelRepository;
import com.adamant.springassignment.repository.CarOwnerRepository;
import com.adamant.springassignment.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Arrays;

@SpringBootApplication
public class SpringAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAssignmentApplication.class, args);
	}

	/*
		Test the data processing with the dummy objects. Tested the same way in POSTMAN.
	 */
	@Bean
	CommandLineRunner runner(CarRepository carRepository, CarOwnerRepository carOwnerRepository, CarModelRepository carModelRepository){
		CarModel carModel1 = new CarModel("local", "S", "auto", "diesel", 1000, 2016);
		CarModel carModel2 = new CarModel("local", "X", "manual", "electro", 2000, 2013);
		Car car1 = new Car(carModel1, "1234", "white", 1000d);
		Car car2 = new Car(carModel2, "1257", "black", 1800d);
		CarOwner carOwner = new CarOwner("John", "Smith", Date.valueOf("1980-10-10"));
		car1.setCarOwner(carOwner);
		car2.setCarOwner(carOwner);

		carModelRepository.save(carModel1);
		carModelRepository.save(carModel2);
		carOwnerRepository.save(carOwner);
		carRepository.save(car1);
		carRepository.save(car2);
		System.out.println("carRepository size is " + carRepository.findAll().size());
		return result -> carRepository.findAll();
	}
}