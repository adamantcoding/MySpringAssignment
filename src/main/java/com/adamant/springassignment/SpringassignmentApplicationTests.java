package com.adamant.springassignment;

import com.adamant.springassignment.domain.*;
import com.adamant.springassignment.repository.*;
import com.sun.security.auth.callback.DialogCallbackHandler;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
@ComponentScan(basePackages = "com.adamant.springassignment")
public class SpringassignmentApplicationTests {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private CarOwnerRepository carOwnerRepository;
    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mockMvc;
    private HttpMessageConverter converter;
    private CarOwner carOwner;
    private CarModel carModel;
    private Car car;

    @Autowired
    void setConverter(HttpMessageConverter<?>[] converters){
        this.converter = Arrays.stream(converters).filter(conv -> conv instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);
        assertNotNull(this.converter);
    }

//	CarModel carModel = new CarModel("manufacturer1", "S", "hand", "diesel", 2000, 2015);
	String json = "{\"manufacturer\":\"manufacturer1\", " +
            "\"model\":\"S\"," +
            "\"transmissionType\":\"hand\"," +
            "\"fuelType\":\"diesel\"," +
            "\"horsePower\":\"2000\"," +
            " \"modelYear\":\"2015\"}";

	@Before
    public void setUp(){
	    mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	    carModel = new CarModel();
	    carOwner = new CarOwner();
        car = new Car();
        car.setCarModel(carModel);
        carOwnerRepository.save(carOwner);
        carModelRepository.save(carModel);
        carRepository.save(car);
    }

	@Test
	public void testGetCarOwnerById(){
        CarOwner carOwner = carOwnerRepository.findCarOwnerById(1L);
        assertNotNull(carOwner);
        assertThat(carOwner.getId() == 1L);
	}

	@Test
	public void testGetAllCars(){
        Collection<Car> cars = carRepository.findAll();
        assertNotNull(cars);
        assertEquals(cars.size(), 1);
	}

	@Test
	public void testCreateCarModel() throws Exception {
        when(carModelRepository.save(Mockito.any(CarModel.class))).thenReturn(carModel);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/carModel/create").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String response = result.getResponse().toString();
        String expectedResult = "{id:1, manufacturer:manufacturer1, model:S, transmissionType:hand, fuelType:diesel, horsepower:2000, modelYear: 2015}";
        JSONAssert.assertEquals(expectedResult, response, false);
	}
}