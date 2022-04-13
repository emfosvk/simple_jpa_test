package com.example.jpa.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MEMBER")
@Getter
@Setter
public class Member {

    @Id //primary key
    @Column(name = "MEMBER_ID" )
    private Long memberId;

    @Column(name = "MEMBER_NAME" )
    private String memberName;




}
