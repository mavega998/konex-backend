package com.example.demo.repositories;

import com.example.demo.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByLab(String lab);
    List<Medicine> findByCreateDate(Date createDate);
    List<Medicine> findByDueDate(Date dueDate);
}
