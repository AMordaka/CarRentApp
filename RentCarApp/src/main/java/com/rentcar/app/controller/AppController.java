package com.rentcar.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rentcar.app.model.UserProfile;
import com.rentcar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
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
	    return "cars";
    }

    @RequestMapping(value={ "/", "/homepage"}, method = RequestMethod.GET)
    public String homePage (ModelMap model){
        model.addAttribute("loggedinuser", userService.getPrincipal());
        return "homepage";
    }

}