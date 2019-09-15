package com.htakemoto.domain;

import javax.persistence.*;

@Entity
@Table (name= "Vessel")
public class Vessel {
    @Id
    @SequenceGenerator(name="vessel_generator", sequenceName = "vessel_generator", initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "vessel_generator")
    private Integer id;

    @Column(name= "vessel_name")
    private String vessel_name;

    @Column(name= "capacity_unit")
    private Integer capacity_unit;

    @Column(name= "capacity_meter")
    private Float capacity_meter;

    public Vessel(Integer id, String vessel_name, Integer capacity_unit, Float capacity_meter) {
        this.id = id;
        this.vessel_name = vessel_name;
        this.capacity_unit = capacity_unit;
        this.capacity_meter = capacity_meter;
    }

    public Vessel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer vessel_id) {
        this.id =id;
    }

    public String getVessel_name() {
        return vessel_name;
    }

    public void setVessel_name(String vessel_name) {
        this.vessel_name = vessel_name;
    }

    public Integer getCapacity_unit() {
        return capacity_unit;
    }

    public void setCapacity_unit(Integer capacity_unit) {
        this.capacity_unit = capacity_unit;
    }

    public Float getCapacity_meter() {
        return capacity_meter;
    }

    public void setCapacity_meter(Float capacity_meter) {
        this.capacity_meter = capacity_meter;
    }
}
