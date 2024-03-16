package com.instituto.instituto.repository;

import com.instituto.instituto.entity.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursadaRepository extends JpaRepository<Cursada, Long> {
}
