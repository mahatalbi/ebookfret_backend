package com.htakemoto.repository;

import java.util.List;

import com.htakemoto.domain.MaritimeCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaritimeCallRepository extends JpaRepository<MaritimeCall,Integer> {
}