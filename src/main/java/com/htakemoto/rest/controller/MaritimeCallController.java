package com.htakemoto.rest.controller;

import com.htakemoto.domain.MaritimeCall;
import com.htakemoto.domain.Options;

import com.htakemoto.repository.MaritimeCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/maritimeCall")
public class MaritimeCallController {

    @Autowired
    private com.htakemoto.repository.MaritimeCallService maritimeCallService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public ArrayList<Options> home() {
        ArrayList<MaritimeCall> listMaritimeCall = maritimeCallService.listAll();
        ArrayList<Options> listOptions= new ArrayList<Options>();
        
        for (MaritimeCall call : listMaritimeCall ) {
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        	Options opt = new Options();
        	String text = dateFormat.format(call.getEta());
        	String text2 = dateFormat.format(call.getEtd());
        	opt.setLabel(text+'/'+text2);
        	opt.setValue(text+'/'+text2);
        	listOptions.add(opt);
        }
 
        return listOptions;
    }
    

    
}
