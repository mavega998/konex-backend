package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private Long id;

    @Column(name = "createDate", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createDate;

    @Column(name = "id_medicine", nullable = false)
    private Long idMedicine;

    @Column(name = "name_medicine", nullable = false)
    private String nameMedicine;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price_per_unit", nullable = false)
    private Integer pricePerUnit;

    @Column(name = "price_total", nullable = false)
    private Integer priceTotal;
}
