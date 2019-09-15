package com.htakemoto.repository;
import java.util.List;

import com.htakemoto.domain.MaritimeAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class MaritimeAgentService{
    @Autowired MaritimeAgentRepository maritimeAgentRepository;

    public MaritimeAgent save(MaritimeAgent maritimeAgent) {
        maritimeAgentRepository.save(maritimeAgent);
        return maritimeAgent;
    }

    public List<MaritimeAgent> listAll() {
        return  maritimeAgentRepository.findAll();
    }




}
