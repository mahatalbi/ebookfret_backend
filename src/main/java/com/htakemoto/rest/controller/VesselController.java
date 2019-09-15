package com.htakemoto.rest.controller;

import com.htakemoto.domain.Vessel;
import com.htakemoto.repository.VesselService;
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
@RequestMapping("/vessel")
public class VesselController {

    @Autowired
    private com.htakemoto.repository.VesselService vesselService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Vessel> home() {
        List<Vessel> listVessel = vesselService.listAll();
        return listVessel;
    }
}
