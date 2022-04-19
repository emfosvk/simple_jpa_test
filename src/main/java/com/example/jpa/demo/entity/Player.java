package com.example.jpa.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="TB_PLAYER")
@Getter
@Setter
@SequenceGenerator(
        name = "PLAYER_SEQ_GEN",
        sequenceName = "PLAYER_SEQ",
        initialValue = 100,
        allocationSize = 100
)
public class Player {

    @Id
    @Column(name = "PLAYER_ID")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PLAYER_SEQ_GEN"
    )
    private Long playerId;




    @Column(name = "PLAYER_NAME", nullable = false, length = 100)
    private String playerName;


    @Column(name = "PLAYER_POINT", scale = 2, precision = 3)
    private BigDecimal playerPoint;

    @Enumerated(EnumType.STRING)
    @Column(name = "PLAYER_TYPE")
    private PlayerType playerType;


    @Temporal(TemporalType.DATE)
    @Column(name = "ENTRY_DATE")
    private Date entryDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "ENTRY_TIME")
    private Date entryTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENTRY_DATE_TIME")
    private Date entryDateTime;


    @Column(name="QUIT_DATE")
    private LocalDate quitDate;

    @Column(name="QUIT_TIME")
    private LocalTime quitTime;

    @Column(name="QUIT_DATE_TIME")
    private LocalDateTime quitDateTime;

    @Lob
    @Column(name="PLAYER_HIST")
    private String playerHistory;


}
