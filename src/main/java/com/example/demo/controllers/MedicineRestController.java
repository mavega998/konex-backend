package com.example.demo.controllers;

import com.example.demo.entities.Medicine;
import com.example.demo.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicine")
public class MedicineRestController {
    private MedicineService medicineService;

    @Autowired
    public MedicineRestController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/create", headers = "Accept=application/json")
    public void insertMedicine(@RequestBody Medicine medicine) {
        medicineService.createMedicine(medicine);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/list", headers = "Accept=application/json")
    public Object listMedicine(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Medicine> medicines = medicineService.listMedicine(pageable);
        return medicines;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/{id}", headers = "Accept=application/json")
    public Optional<Medicine> listMedicine(@PathVariable Long id) {
        return medicineService.getOne(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(value = "/update", headers = "Accept=application/json")
    public void updateMedicine(@RequestBody Medicine medicine) {
        medicineService.updateOne(medicine);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public void deleteMedicine(@PathVariable Long id) {
        medicineService.deleteOne(id);
    }

    @GetMapping(value = "/filter", headers = "Accept=application/json")
    public String filterMedicine(@RequestParam("startDate") String startDate) {
        return startDate;
    }
}
