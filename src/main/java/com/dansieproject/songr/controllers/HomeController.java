package com.dansieproject.songr.controllers;

import com.dansieproject.songr.models.Album;
import com.dansieproject.songr.models.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    AlbumRepository albumRepository;

    //another way to handle params
//    public String getHome(@RequestParam(required = false, defaultValue = "user") String username, Model m){

    @GetMapping("/")
    public String getHome(Model m){
        return "index";
    }
    
    @GetMapping("/album")
    public String getTheAlbums(Model m){
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "album";
    }

    @PostMapping("/album")
    public RedirectView addTheAlbums(String albumName, String artistName, int songCount, int albumLengthMinutes, int albumLengthSeconds, String artUrl){
        Album allie = new Album(albumName, artistName, songCount, (albumLengthMinutes*60 + albumLengthSeconds), artUrl);
        albumRepository.save(allie);

        return new RedirectView("/album");
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
