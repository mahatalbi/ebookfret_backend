package com.htakemoto.repository;
import java.util.List;

import com.htakemoto.domain.MaritimeCall;
import com.htakemoto.domain.Vessel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class VesselService{
    @Autowired VesselRepository vesselRepository;

    public Vessel save(Vessel vessel) {
        vesselRepository.save(vessel);
        return vessel;
    }

    public List<Vessel> listAll() {
        return  vesselRepository.findAll();
    }



}
