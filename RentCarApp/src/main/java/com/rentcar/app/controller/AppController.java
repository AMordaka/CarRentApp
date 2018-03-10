package com.rentcar.app.controller;

import java.util.List;

import com.rentcar.app.model.User;
import com.rentcar.app.model.UserProfile;
import com.rentcar.app.service.CarService;
import com.rentcar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rentcar.app.service.UserProfileService;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
    UserService userService;
	
	@Autowired
	UserProfileService userProfileService;

	@Autowired
    CarService carService;

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", userService.getPrincipal());
		return "accessDenied";
	}






    @RequestMapping(value="/cars", method = RequestMethod.GET)
    public String carsPage (ModelMap model){
        model.addAttribute("loggedinuser", userService.getPrincipal());
        model.addAttribute("cars", carService.findAllCars());
	    return "cars";
    }

    @RequestMapping(value={ "/", "/homepage"}, method = RequestMethod.GET)
    public String homePage (ModelMap model){
        model.addAttribute("loggedinuser", userService.getPrincipal());
        return "homepage";
    }

    @RequestMapping(value={"/about"}, method = RequestMethod.GET)
    public String aboutPage (ModelMap model){
        model.addAttribute("loggedinuser", userService.getPrincipal());
        return "about";
    }

    @RequestMapping(value={"/userpanel"}, method = RequestMethod.GET)
    public String userPanelPage (ModelMap model){
        User user = userService.findBySSO(userService.getPrincipal());
        model.addAttribute("loggedinuser", userService.getPrincipal());
        model.addAttribute("user", user);
        return "userpanel";
    }
}