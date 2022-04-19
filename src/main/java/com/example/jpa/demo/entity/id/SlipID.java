package com.example.jpa.demo.entity.id;

import com.example.jpa.demo.entity.Bill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SlipID implements Serializable {
//    @Id
//    @Column(name = "BILL_NO")
//    private Long billNo;

//    @Id
//    @Column(name = "BILL_SEQ_NO")
    private Long billSeqNo;

    private Bill bill;

}
