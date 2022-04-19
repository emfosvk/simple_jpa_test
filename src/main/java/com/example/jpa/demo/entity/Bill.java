package com.example.jpa.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "BILL")
public class Bill {

    @Id
    @Column(name = "BILL_NO")
    private Long billNo;

    @Column (name = "TOT_AMT")
    private Long totalAmt;

    @Column (name = "BILL_OPEN_DATE")
    private LocalDateTime billOpenDate;

    @OneToMany(mappedBy = "bill")
    private List<Slip> slip;


}
