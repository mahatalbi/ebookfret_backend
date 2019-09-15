package com.htakemoto.rest.controller;

import com.htakemoto.domain.Truck;
import com.htakemoto.repository.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    private com.htakemoto.repository.TruckService truckService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Truck> home() {
        List<Truck> listTruck = truckService.listAll();
        return listTruck;
    }
}
