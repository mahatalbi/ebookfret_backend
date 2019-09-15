package com.htakemoto.domain;

import javax.persistence.*;

@Entity
@Table (name= "Truck")
public class Truck {

    @Id
    @Column( name="id")
    @SequenceGenerator(name="truck_generator", sequenceName = "truck_generator", initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "truck_generator")
    private Integer id;

    @Column (name = "truck_number")
    private Integer truck_number;

    @Column (name = "tray_number")
    private Integer tray_number;

    @Column (name = "unit_number")
    private Integer unit_number;

    @Column (name = "height")
    private Integer height;

    @Column (name = "width")
    private Integer width;

    @Column (name = "length")
    private Integer length;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTruck_number() {
        return truck_number;
    }

    public void setTruck_number(Integer truck_number) {
        this.truck_number = truck_number;
    }

    public Integer getTray_number() {
        return tray_number;
    }

    public void setTray_number(Integer tray_number) {
        this.tray_number = tray_number;
    }

    public Integer getUnit_number() {
        return unit_number;
    }

    public void setUnit_number(Integer unit_number) {
        this.unit_number = unit_number;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Truck(Integer id, Integer truck_number, Integer tray_number, Integer unit_number, Integer height, Integer width, Integer length) {
        this.id = id;
        this.truck_number = truck_number;
        this.tray_number = tray_number;
        this.unit_number = unit_number;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Truck() {
    }
}
