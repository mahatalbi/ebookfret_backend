package com.htakemoto.repository;
import java.util.List;

import com.htakemoto.domain.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class TruckService{
    @Autowired TruckRepository truckRepository;

    public Truck save(Truck truck) {
        truckRepository.save(truck);
        return truck;
    }

    public List<Truck> listAll() {
        return  truckRepository.findAll();
    }




}
