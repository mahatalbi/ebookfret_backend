package com.htakemoto.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MaritimeCall {

    @Id
    @SequenceGenerator(name="maritimeCall_generator", sequenceName = "maritimeCall_generator", initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "maritimeCall_generator")
    private Integer id;

    private Date eta;

    private Date etd;

    @ManyToOne
    private Vessel vessel;

    public MaritimeCall(Date eta, Date etd, Vessel vessel) {
        this.eta = eta;
        this.etd = etd;
        this.vessel = vessel;
    }
    public MaritimeCall() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public Date getEtd() {
        return etd;
    }

    public void setEtd(Date etd) {
        this.etd = etd;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }
}
