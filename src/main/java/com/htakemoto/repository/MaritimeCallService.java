package com.htakemoto.repository;
import java.util.ArrayList;
import java.util.List;

import com.htakemoto.domain.MaritimeCall;


import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class MaritimeCallService{
    @Autowired MaritimeCallRepository maritimeCallRepository;

    public MaritimeCall save(MaritimeCall maritimeCall) {
        maritimeCallRepository.save(maritimeCall);
        return maritimeCall;
    }

    public ArrayList<MaritimeCall> listAll() {
        return  (ArrayList<MaritimeCall>) maritimeCallRepository.findAll();
    }




}
