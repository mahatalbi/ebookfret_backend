package com.htakemoto.rest.controller;

import com.htakemoto.domain.Reservation;
import com.htakemoto.domain.ReservationDTO;
import com.htakemoto.repository.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private com.htakemoto.repository.ReservationService reservationService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Object[]> home() {
//        List<Reservation> listReservation = reservationService.listAll();
        List<Object[]> listReservation = reservationService.getReservations();

        return listReservation;
    }
    
	@DeleteMapping("/deleteReser/{id}")
	public void deleteReser (@PathVariable("id") Integer id){
		
		reservationService.deleteById(id);
	
	}
	
    @RequestMapping(value="/showDetails/{id}", method= RequestMethod.GET)
    public ReservationDTO showDetails(@PathVariable("id") Integer id) {
        ReservationDTO obj = reservationService.showDetails(id);

        return obj;
    }
    
	
	

    @RequestMapping(method = RequestMethod.POST)
    public Reservation create(@RequestBody  Reservation reservation) {
        return reservationService.save(reservation);
    }

    // @RequestMapping(path = "/filter/{reservation_number}/{unit_number}/{truck_number}/{tray_number}/{approved}/{validated}", method= RequestMethod.GET)
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    @ResponseBody
    public  List<ReservationDTO>  filterReservation (@RequestParam(value = "reservation_number", required = false) Integer reservation_number ,
                                                     @RequestParam(value = "unit_number", required = false) Integer unit_number,
                                                     @RequestParam(value = "truck_number", required = false) Integer truck_number,
                                                     @RequestParam(value = "tray_number", required = false) Integer tray_number,
                                                     @RequestParam(value = "approved", required = false) Boolean approved,
                                                     @RequestParam(value = "validated", required = false) Boolean validated) {
        System.out.println("reservation_number"+reservation_number+"unit_number"+unit_number+"tray_number"+tray_number+"approved"+approved+"validated"+validated);
        List<ReservationDTO> projetTaches =  reservationService.filterReservation(reservation_number,
                unit_number,
                truck_number,
                tray_number,
                approved,
                validated);
        for (Object line:projetTaches
        ) {
            System.out.println(line);

        }
        

        return projetTaches;
    }





    @PostMapping(path="/savereservation")
    public void  saveReservation(@RequestBody Map<String, Object> payload) throws ParseException {
        System.out.println(payload);
        reservationService.saveReservation(payload);
    }

}
