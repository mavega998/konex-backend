package com.example.demo.controllers;

import com.example.demo.entities.Sale;
import com.example.demo.services.MedicineService;
import com.example.demo.services.SaleService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sale")
public class SaleRestController {
    private SaleService saleService;
    private MedicineService medicineService;

    @Autowired
    public SaleRestController(SaleService saleService, MedicineService medicineService) {
        this.saleService = saleService;
        this.medicineService = medicineService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/create", headers = "Accept=application/json")
    public void insertSale(@RequestBody Sale sale) {
        saleService.createSale(sale);
        medicineService.updateStock(sale.getIdMedicine(), sale.getQuantity());
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/list", headers = "Accept=application/json")
    public Object saleList(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Sale> sales = saleService.saleList(pageable);
        return sales;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/{id}", headers = "Accept=application/json")
    public Optional<Sale> saleOne(@PathVariable Long id) {
        return saleService.getOne(id);
    }


    @CrossOrigin(origins = "*")
    @PutMapping(value = "/update", headers = "Accept=application/json")
    public void updateSale(@RequestBody Sale sale) {
        saleService.updateOne(sale);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public void deleteSale(@PathVariable Long id) {
        saleService.deleteOne(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/range", headers = "Accept=application/json")
    public List<Sale> findByRangeDates(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);
        return saleService.findByRangeDate(startDateTime,endDateTime);
    }
}
