package com.htakemoto.repository;

import java.util.List;

import com.htakemoto.domain.Reservation;
import com.htakemoto.domain.ReservationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("select r.id,r.reservation_number,v.vessel_name,m.eta,m.etd,r.truck.unit_number,r.has_zre,r.has_sas,r.has_boarded from Reservation r " +
            "join r.maritimeCall m "+
            "join m.vessel v")
    List<Object[]> getReservations();

    @Query("select new com.htakemoto.domain.ReservationDTO(r.id ,r.reservation_number ,v.vessel_name ,m.eta ,m.etd ,r.truck.unit_number ,r.has_zre ,r.has_sas,r.has_boarded) from Reservation r " +
            "join r.maritimeCall m "+
            "join m.vessel v " +
            "where (:reservation_number is null or r.reservation_number =:reservation_number)  " +
            "and (:unit_number is null or r.truck.unit_number =:unit_number)" +
            " and (:truck_number is null or r.truck.truck_number =:truck_number)"+
            " and (:tray_number is null or r.truck.tray_number =:tray_number)"+
            " and (:approved is null or r.approved =:approved)"+
            " and (:validated is null or r.validated =:validated)")
    List<ReservationDTO> filterReservation(@Param("reservation_number") Integer reservation_number,
                                           @Param("unit_number") Integer unit_number,
                                           @Param("truck_number") Integer truck_number,
                                           @Param("tray_number") Integer tray_number,
                                           @Param("approved") Boolean approved,
                                           @Param("validated") Boolean validated);
    
	void deleteById (int id);
	
	
	
    @Query("select new com.htakemoto.domain.ReservationDTO(r.id ,r.reservation_number ,v.vessel_name ,m.eta ,m.etd,r.zre_time,r.sas_time,r.boarded_time ,r.truck.unit_number,r.truck.truck_number,r.truck.tray_number ,r.has_zre ,r.has_sas,r.has_boarded, r.truck.length, r.truck.width, r.truck.height) from Reservation r " +
            "join r.maritimeCall m "+
            "join m.vessel v "+ 
            "where (r.id =:id)")
	ReservationDTO showDetails(@Param("id") Integer id);
    
    
    @Query("select new com.htakemoto.domain.ReservationDTO(r.id ,r.reservation_number ,v.vessel_name ,m.eta ,m.etd,r.zre_time,r.sas_time,r.boarded_time ,r.truck.unit_number,r.truck.truck_number,r.truck.tray_number ,r.has_zre ,r.has_sas,r.has_boarded, r.truck.length, r.truck.width, r.truck.height) from Reservation r " +
            "join r.maritimeCall m "+
            "join m.vessel v "+ 
            "where (r.id =:id)")
	ReservationDTO updateReservation(@Param("id") Integer id);
}



