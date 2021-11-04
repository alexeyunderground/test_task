package com.zubcov.springboot.myapp.controller;

import com.zubcov.springboot.myapp.entity.Overlord;
import com.zubcov.springboot.myapp.entity.Planet;
import com.zubcov.springboot.myapp.service.OverlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class MyController {

    @Autowired
    private OverlordService overlordService;

    @RequestMapping("/")
    public String helloPage() {
        return "hello";
    }

    @RequestMapping("/showAll")
    public String showAllOverlords(Model model) {
        List<Overlord> overlordList = overlordService.getAllOverlords();
        List<Planet> planetList = overlordService.getAllPlanets();
        model.addAttribute("planetList",planetList);
        model.addAttribute("overlordList",overlordList);
        return "show-all";
    }

    @RequestMapping("/addNewOverlord")
    public String addOverlord(Model model) {
        Overlord overlord = new Overlord();
        model.addAttribute("overlord",overlord);
        return "add-new-overlord";
    }

    @RequestMapping("/saveOverlord")
    public String saveOverlord(@ModelAttribute("overlord") Overlord overlord) {
        overlordService.saveOverlord(overlord);
        return "redirect:/showAll";
    }

    @RequestMapping("/addNewPlanet")
    public String addNewPlanet(Model model) {
        Planet planet = new Planet();
        model.addAttribute("planet",planet);
        return "add-new-planet";
    }

    @RequestMapping("/savePlanet")
    public String savePlanet(@ModelAttribute("planet") Planet planet) {
        overlordService.savePlanet(planet);
        return "redirect:/showAll";
    }

    @RequestMapping("/deletePlanet")
    public String deletePlanet(@RequestParam int id) {
        Planet planet = overlordService.getPlanet(id);
        overlordService.deletePlanet(planet);
        return "redirect:/showAll";
    }

    @RequestMapping("/setOverlordToPlanet")
    public String setOverlordToPlanet(@RequestParam("overlord") String overlordId,
                                      @RequestParam("planet") String planetId) {
        overlordService.setOverlordToPlanet(Integer.parseInt(overlordId),
                Integer.parseInt(planetId));
        return "redirect:/showAll";
    }

    @RequestMapping("/showFreeOverlords")
    public String getFreeOverlords(Model model) {
        List<Overlord> freeOverlords = overlordService.getFreeOverlords();
        model.addAttribute("freeOverlords",freeOverlords);
        System.out.println("done");
        System.out.println(freeOverlords);
        return "show-free-overlords";
    }
    @RequestMapping("/showYoungerOverlords")
    public String getYoungerOverlords(Model model) {
        List<Overlord> youngerOverlords = overlordService.getYoungerOverlords();
        model.addAttribute("youngerOverlords",youngerOverlords);
        return "show-younger-overlords";
    }
}
