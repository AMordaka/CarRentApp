package com.rentcar.app.controller;

import com.rentcar.app.model.UserProfile;
import com.rentcar.app.model.UserProfileType;
import com.rentcar.app.service.CarService;
import com.rentcar.app.service.UserProfileService;
import com.rentcar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

    private static final String LOGGED_USER = "loggedinuser";
    private static final String CARS = "cars";
    private static final String ACCESS_DENIED = "accessDenied";
    private static final String HOMEPAGE = "homepage";
    private static final String ABOUT = "about";
    private static final String YOUR_CARS = "yourcars";

    //SERVICES
    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    CarService carService;

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

    @ModelAttribute("role_user")
    public UserProfile initializeUserProfile() {
        return userProfileService.findByType(UserProfileType.USER.getUserProfileType());
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute(LOGGED_USER, userService.getPrincipal());
        return ACCESS_DENIED;
    }

    @RequestMapping(value = {"/", "/homepage"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute(LOGGED_USER, userService.getPrincipal());
        return HOMEPAGE;
    }

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String aboutPage(ModelMap model) {
        model.addAttribute(LOGGED_USER, userService.getPrincipal());
        return ABOUT;
    }

    @RequestMapping(value = "/yourcars", method = RequestMethod.GET)
    public String yourCars(ModelMap model) {
        model.addAttribute(LOGGED_USER, userService.getPrincipal());
        model.addAttribute(CARS, carService.findUserCars(userService.getPrincipal()));
        return YOUR_CARS;
    }
}