package com.dansieproject.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    //another way to handle params
//    public String getHome(@RequestParam(required = false, defaultValue = "user") String username, Model m){

    //Model m is for passing data to the view (not a real model (wanna be model (gross (but is a HasMap, so okay))))
    @GetMapping("/")
    public String getHome(String username, Model m){
        System.out.println(username);
        m.addAttribute("potato", "russet");

        //can also do if username == null
        m.addAttribute("username", username);
        return "home";
    }

    @GetMapping("/hello/{username}")
    //username is from the path
    public String getHelloRoute(@PathVariable String username, Model m){
        m.addAttribute("username", username);
        return "home";
    }

    @GetMapping("/emotions")
    public String getTheEmotions(Model m){
        Emotion[] feelings = new Emotion[]{new Emotion("uncertainty", 20, "java hurt brain")};
        //fell behind here
//        m.addAttribute(...)
        return "emotions";
    }
}
