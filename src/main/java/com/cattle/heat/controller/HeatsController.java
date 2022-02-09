package com.cattle.heat.controller;

import com.cattle.heat.service.HeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/heats")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HeatsController {

    @Autowired
    private HeatService heatService;

    @PostMapping(path = "/")
    private void detect(@RequestParam Map<String, String> data){
        heatService.detectHeat(data);
    }

    @GetMapping(path = "/")
    private ResponseEntity findAll(){
        return heatService.findAll();
    }



}
