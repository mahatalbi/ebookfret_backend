package com.htakemoto.repository;

import java.util.List;

import com.htakemoto.domain.MaritimeAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaritimeAgentRepository extends JpaRepository<MaritimeAgent, Long> {
}