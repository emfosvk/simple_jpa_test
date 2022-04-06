package com.example.jpa.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MEMBER")
@Getter
@Setter
public class Member {

    @Id
    private Long memberId;


    private String memberName;


}
