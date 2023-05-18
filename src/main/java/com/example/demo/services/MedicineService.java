package com.example.demo.services;

import com.example.demo.entities.Medicine;
import com.example.demo.repositories.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {
    private IMedicineRepository medicineRepository;

    @Autowired
    public MedicineService(IMedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public void createMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public Page<Medicine> listMedicine(Pageable pageable) {
        return medicineRepository.findAll(pageable);
    }

    public Optional<Medicine> getOne(Long id) {
        return medicineRepository.findById(id);
    }

    public void updateOne(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public void deleteOne(Long id) {
        medicineRepository.deleteById(id);
    }

    public void updateStock(Long id, Integer quantity) {
        Optional<Medicine> medicineData = medicineRepository.findById(id);
        if (medicineData.isPresent()) {
            Medicine medicine = medicineData.get();
            medicine.setStock(medicine.getStock() - quantity);
            medicineRepository.save(medicine);
        }
    }

    List<Medicine> findByLab(String lab) {
        return medicineRepository.findByLab(lab);
    }

    List<Medicine> findByCreateDate(Date createDate) {
        return medicineRepository.findByCreateDate(createDate);
    }

    List<Medicine> findByDueDate(Date dueDate) {
        return medicineRepository.findByDueDate(dueDate);
    }
}
