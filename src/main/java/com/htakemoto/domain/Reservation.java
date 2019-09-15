package com.htakemoto.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name= "Reservation")
public class Reservation {

    @Id
    @SequenceGenerator(name="reservation_generator", sequenceName = "reservation_generator", initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "reservation_generator")
    private Integer id;

    @Column(name = "reservation_number")
    private Integer reservation_number;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "validated")
    private Boolean validated;

    @Column(name = "reached_zre")
    private Boolean has_zre;

    @Column(name = "zre_time")
    private Date zre_time;

    @Column(name = "reached_sas")
    private Boolean has_sas;

    @Column(name = "sas_time")
    private Date sas_time;

    @Column(name = "reached_boarded")
    private Boolean has_boarded;

    @Column(name = "boarded_time")
    private Date boarded_time;


    @ManyToOne
    private Transporter transporter;

    @ManyToOne
    private MaritimeAgent maritimeAgent;

    @ManyToOne
    private MaritimeCall maritimeCall;

    @ManyToOne
    private Truck truck;


    public Reservation(Integer reservation_number, Boolean approved, Boolean validated, Boolean has_zre, Date zre_time, Boolean has_sas, Date sas_time, Boolean has_boarded, Date boarded_time) {
        this.reservation_number = reservation_number;
        this.approved = approved;
        this.validated = validated;
        this.has_zre = has_zre;
        this.zre_time = zre_time;
        this.has_sas = has_sas;
        this.sas_time = sas_time;
        this.has_boarded = has_boarded;
        this.boarded_time = boarded_time;
    }

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReservation_number() {
        return reservation_number;
    }

    public void setReservation_number(Integer reservation_number) {
        this.reservation_number = reservation_number;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Boolean getHas_zre() {
        return has_zre;
    }

    public void setHas_zre(Boolean has_zre) {
        this.has_zre = has_zre;
    }

    public Date getZre_time() {
        return zre_time;
    }

    public void setZre_time(Date zre_time) {
        this.zre_time = zre_time;
    }

    public Boolean getHas_sas() {
        return has_sas;
    }

    public void setHas_sas(Boolean has_sas) {
        this.has_sas = has_sas;
    }

    public Date getSas_time() {
        return sas_time;
    }

    public void setSas_time(Date sas_time) {
        this.sas_time = sas_time;
    }

    public Boolean getHas_boarded() {
        return has_boarded;
    }

    public void setHas_boarded(Boolean has_boarded) {
        this.has_boarded = has_boarded;
    }

    public Date getBoarded_time() {
        return boarded_time;
    }

    public void setBoarded_time(Date boarded_time) {
        this.boarded_time = boarded_time;
    }

    public Transporter getTransporter() {
        return transporter;
    }

    public void setTransporter(Transporter transporter) {
        this.transporter = transporter;
    }

    public MaritimeAgent getMaritimeAgent() {
        return maritimeAgent;
    }

    public void setMaritimeAgent(MaritimeAgent maritimeAgent) {
        this.maritimeAgent = maritimeAgent;
    }

    public MaritimeCall getMaritimeCall() {
        return maritimeCall;
    }

    public void setMaritimeCall(MaritimeCall maritimeCall) {
        this.maritimeCall = maritimeCall;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}