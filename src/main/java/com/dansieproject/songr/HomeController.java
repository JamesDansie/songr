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

    //    public Album(String title, String artist, int songCount, int lengthSeconds, String imageUrl) {

    @GetMapping("/album")
    public String getTheAlbums(Model m){
        Album[] albums = new Album[]{
                new Album("Power In Numbers", "Jurassic 5", 17, (56*60 + 11), "https://upload.wikimedia.org/wikipedia/en/e/e8/Power_in_Numbers.jpg"),
                new Album("The Strange Case of...", "Halestorm", 16, (40*60+56), "https://upload.wikimedia.org/wikipedia/en/1/15/Halsetrom_Strange_Case.jpg"),
                new Album("Al Green's Greatest Hits", "Al Green", 10, (36*60 + 34), "https://upload.wikimedia.org/wikipedia/en/b/b3/Al_Green%27s_Greatest_Hits_%28Al_Green_album_-_cover_art%29.jpg")
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
