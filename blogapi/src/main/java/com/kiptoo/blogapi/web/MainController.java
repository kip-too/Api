package com.kiptoo.blogapi.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller//This class is a Spring component ( Spring Bean)
public class MainController{
    @RequestMapping("/")//mapped to root path

   public ModelAndView index (@RequestParam("name") String name){
    Map<String,Object> model = new HashMap<>();
    model.put("name", name);
    return new ModelAndView("/index", model);
   }
}