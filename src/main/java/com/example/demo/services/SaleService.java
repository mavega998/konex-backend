package com.example.demo.services;

import com.example.demo.entities.Sale;
import com.example.demo.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    private ISaleRepository saleRepository;

    @Autowired
    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void createSale(Sale sale) {
        saleRepository.save(sale);
    }

    public List<Sale> saleList() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getOne(Long id) {
        return saleRepository.findById(id);
    }

    public void updateOne(Sale sale) {
        saleRepository.save(sale);
    }

    public void deleteOne(Long id) {
        saleRepository.deleteById(id);
    }

    public List<Sale> findByRangeDate(Date startDate, Date endDate) {
        List<Sale> saleStartDate = saleRepository.findByCreateDate(startDate);
        List<Sale> saleEndDate = saleRepository.findByCreateDate(endDate);

        List<Sale> sales = new ArrayList<>();
        saleStartDate.forEach(el -> {
            if (!sales.contains(el)) {
                sales.add(el);
            }
        });
        saleEndDate.forEach(el -> {
            if (!sales.contains(el)) {
                sales.add(el);
            }
        });
        return sales;
    }
}
