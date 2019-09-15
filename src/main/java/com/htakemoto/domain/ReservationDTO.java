package com.htakemoto.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDTO {
    private Integer id;
    private Integer reservation_number;
    private String vessel_name;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date eta;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date etd;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date zre_time;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date sas_time;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date boarded_time;
    private Integer unit_number;
    private Integer truck_number;
    private Integer tray_number;
    private Boolean has_zre;
    private Boolean has_sas;
    private Boolean has_boarded;
    private Integer length;
    private Integer width;
    private Integer height;
      
    

    public Integer getId() {
        return id;
    }

    public ReservationDTO(Integer id, Integer reservation_number, String vessel_name, Date eta, Date etd, Integer unit_number, Boolean has_zre, Boolean has_sas, Boolean has_boarded) {
        this.id = id;
        this.reservation_number = reservation_number;
        this.vessel_name = vessel_name;
        this.eta = eta;
        this.etd = etd;
        this.unit_number = unit_number;
        this.has_zre = has_zre;
        this.has_sas = has_sas;
        this.has_boarded = has_boarded;
    }
    
    public ReservationDTO(Integer id, Integer reservation_number, String vessel_name, Date eta, Date etd,Date zre_time,Date sas_time,Date boarded_time, Integer unit_number,Integer truck_number,Integer tray_number,Boolean has_zre, Boolean has_sas, Boolean has_boarded,Integer length, Integer width, Integer height) {
        this.id = id;
        this.reservation_number = reservation_number;
        this.vessel_name = vessel_name;
        this.eta = eta;
        this.etd = etd;
        this.zre_time = zre_time;
        this.sas_time = sas_time;
        this.boarded_time = boarded_time;
        this.unit_number = unit_number;
        this.truck_number = truck_number;
        this.tray_number = tray_number;
        this.has_zre = has_zre;
        this.has_sas = has_sas;
        this.has_boarded = has_boarded;
        this.length = length;
        this.width = width;
        this.height = height;
    }
}