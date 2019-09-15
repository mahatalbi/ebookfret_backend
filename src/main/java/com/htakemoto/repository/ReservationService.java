package com.htakemoto.repository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.htakemoto.domain.MaritimeCall;
import com.htakemoto.domain.Reservation;
import com.htakemoto.domain.ReservationDTO;
import com.htakemoto.domain.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class ReservationService{
    @Autowired ReservationRepository reservationRepository;
    @Autowired TruckRepository truckRepository;
    @Autowired MaritimeCallRepository maritimeCallRepository;

    public Reservation save(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }
    
    public void deleteById(int id) {
    	reservationRepository.deleteById(id);
    }

    public List<Reservation> listAll() {
        return  reservationRepository.findAll();
    }


    public List<Object[]> getReservations() {
        return reservationRepository.getReservations();
    }



    public List<ReservationDTO> filterReservation(Integer reservation_number,
                                                  Integer unit_number,
                                                  Integer truck_number,
                                                  Integer tray_number,
                                                  Boolean approved,
                                                  Boolean validated) {


        List<ReservationDTO> listobject = reservationRepository.filterReservation(reservation_number,unit_number,truck_number,tray_number,approved,validated);
        return listobject;
    }
    
    public ReservationDTO showDetails(Integer id) {
		
		ReservationDTO object = reservationRepository.showDetails(id);
		return object;
		}

    public Reservation saveReservation(Map<String, Object> reservation) throws ParseException {
        Reservation savedReservation =  new Reservation();
        Truck tr =  new Truck();
        MaritimeCall mr = new MaritimeCall();
        tr.setTruck_number(Integer.valueOf((String)reservation.get("truck_plate_number")));
        tr.setTray_number(Integer.valueOf((String)reservation.get("tray_plate_number")));
        tr.setUnit_number(Integer.valueOf((String)reservation.get("unit_plate_number")));
        tr.setHeight(Integer.valueOf((String)reservation.get("hight")));
        tr.setLength(Integer.valueOf((String)reservation.get("length")));
        tr.setWidth(Integer.valueOf((String)reservation.get("width")));
        truckRepository.save(tr);
        savedReservation.setTruck(tr);

        String startDate=(String)reservation.get("etd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date etd = new java.sql.Date(date.getTime());

        String startDate2=(String)reservation.get("eta");
        java.util.Date date2 = sdf1.parse(startDate);
        java.sql.Date eta = new java.sql.Date(date.getTime());

        mr.setEta(eta);
        mr.setEtd(etd);
        maritimeCallRepository.save(mr);
        savedReservation.setMaritimeCall(mr);
        //   reservationRepository.save(reservation);
        return reservationRepository.saveAndFlush(savedReservation);
    }
    
    


}
