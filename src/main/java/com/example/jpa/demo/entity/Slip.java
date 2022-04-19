package com.example.jpa.demo.entity;

import com.example.jpa.demo.entity.id.SlipID;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@IdClass(SlipID.class)
public class Slip {

//    @Id
//    @Column(name = "BILL_NO")
//    private Long billNo;

    @Id
    @Column(name = "BILL_SEQ_NO")
    private Long billSeqNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "BILL_NO")
    private Bill bill;

    public void addBill (Bill bill){
        this.bill = bill;
        bill.getSlip().add(this);
    }

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "AMT")
    private Long amt;

}
