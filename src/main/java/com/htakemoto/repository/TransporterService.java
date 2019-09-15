package com.htakemoto.repository;
import java.util.List;

import com.htakemoto.domain.Transporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class TransporterService{
    @Autowired TransporterRepository transporterRepository;

    public Transporter save(Transporter transporter) {
        transporterRepository.save(transporter);
        return transporter;
    }

    public List<Transporter> listAll() {
        return  transporterRepository.findAll();
    }




}
