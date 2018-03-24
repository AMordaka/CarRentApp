package com.rentcar.app.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.rentcar.app.model.User;
import com.rentcar.app.model.UserProfile;
import com.rentcar.app.service.CarService;
import com.rentcar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
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
    public String userPanelPage (ModelMap model) throws UnsupportedEncodingException {
        User user = userService.findBySSO(userService.getPrincipal());
        if(user.getPicture() != null) {
            byte[] encodeBase64 = Base64.encode(user.getPicture());
            String base64Encoded = new String(encodeBase64, "UTF-8");
            model.addAttribute("userImage", base64Encoded);
        }
        model.addAttribute("loggedinuser", userService.getPrincipal());
        model.addAttribute("user", user);
        return "userpanel";
    }


    @RequestMapping(value="/yourcars", method = RequestMethod.GET)
    public String yourCars (ModelMap model){
        model.addAttribute("loggedinuser", userService.getPrincipal());
        model.addAttribute("cars", carService.findUserCars(userService.getPrincipal()));
        return "yourcars";
    }
}