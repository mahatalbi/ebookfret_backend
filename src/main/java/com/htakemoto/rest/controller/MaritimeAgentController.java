
package com.htakemoto.rest.controller;

import com.htakemoto.domain.MaritimeAgent;
import com.htakemoto.repository.MaritimeAgentService;
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
@RequestMapping("/maritimeAgent")
public class MaritimeAgentController {

    @Autowired
    private com.htakemoto.repository.MaritimeAgentService maritimeAgentService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<MaritimeAgent> home() {
        List<MaritimeAgent> listMaritimeAgent = maritimeAgentService.listAll();
        return listMaritimeAgent;
    }
}
