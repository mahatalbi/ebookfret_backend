
package com.htakemoto.rest.controller;

import com.htakemoto.domain.Transporter;
import com.htakemoto.repository.TransporterService;
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
@RequestMapping("/transporters")
public class TransporterController {

    @Autowired
    private com.htakemoto.repository.TransporterService transporterService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Transporter> home() {
        List<Transporter> listTransporter = transporterService.listAll();
        return listTransporter;
    }
}
