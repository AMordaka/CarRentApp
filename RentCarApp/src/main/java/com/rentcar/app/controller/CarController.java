package com.rentcar.app.controller;

import com.rentcar.app.model.Car;
import com.rentcar.app.model.User;
import com.rentcar.app.service.CarService;
import com.rentcar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = { "/delete-car-{id}" }, method = RequestMethod.GET)
    public String deleteCar(@PathVariable String id, ModelMap model) {
        carService.deleteCarByRegNo(id);
        model.addAttribute("success", "Car deleted successfully");
        return "registrationsuccess";
    }

    @RequestMapping(value = { "/rent-car-{regNo}" }, method = RequestMethod.GET)
    public String rentCar(@PathVariable String regNo, ModelMap model) {
        Car car = carService.findCarByRegNo(regNo);
        model.addAttribute("car", car);

        return "rentcar";
    }

    @RequestMapping(value = { "/rent-car-{regNo}" }, method = RequestMethod.POST)
    public String saveRentCar(@Valid Car car,  BindingResult result, ModelMap model) {
        carService.rentCar(car,userService.getPrincipal());
        model.addAttribute("success", "Car " + car.getRegNo() + " rented successfully");
        return "registrationsuccess";
    }

    @RequestMapping(value = { "/newcar" }, method = RequestMethod.GET)
    public String newCar(ModelMap model) {
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("carTypes", carService.findAllCarType());
        return "registercar";
    }

    @RequestMapping(value = { "/newcar" }, method = RequestMethod.POST)
    public String saveCar(@Valid Car car, BindingResult result,	ModelMap model) {

        if (result.hasErrors()) {
            return "registercar";
        }

        if(!carService.isRegNoUnique((int) car.getId(),car.getRegNo())){
            FieldError ssoError =new FieldError("car","regNo",messageSource.getMessage("non.unique.regNo", new String[]{car.getRegNo()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registercar";
        }

        carService.saveCar(car);

        model.addAttribute("success", "User " + car.getRegNo() + " registered successfully");
        model.addAttribute("loggedinuser", userService.getPrincipal());
        return "registrationsuccess";
    }

}
