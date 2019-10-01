package com.dansieproject.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    //another way to handle params
//    public String getHome(@RequestParam(required = false, defaultValue = "user") String username, Model m){

    @GetMapping("/")
    public String getHome(Model m){
        return "index";
    }

    @GetMapping("/album")
    public String getTheAlbums(Model m){
        Album[] albums = new Album[]{
                new Album()...,
                new Album()...
        };
        m.addAttribute("albums", albums);
        return "album";
    }

    //Model m is for passing data to the view (not a real model (wanna be model (gross (but is a HasMap, so okay))))
    @GetMapping("/hello")
    public String getHello(String username, Model m){
        System.out.println(username);
        m.addAttribute("potato", "russet");

        //can also do if username == null
        m.addAttribute("username", username);
        return "home";
    }

    @GetMapping("/hello/{username}")
    //username is from the path
    public String getHelloRoute(@PathVariable String username, Model m){
        m.addAttribute("potato", "russet");
        m.addAttribute("username", username);
        return "home";
    }

    @GetMapping("/capitalize/{username}")
    public String getCapRoute(@PathVariable String username, Model m){
        username = username.toUpperCase();
        m.addAttribute("potato", "russet");
        m.addAttribute("username", username);
        return "home";
    }
}
