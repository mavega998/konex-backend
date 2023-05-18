package com.example.demo.repositories;

import com.example.demo.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCreateDate(Date createDate);
}

