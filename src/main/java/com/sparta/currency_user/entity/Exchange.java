package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Exchange extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name ="currency_id")
    private Currency currency;

    @Column
    private BigDecimal amountInKwr;
    @Column
    private BigDecimal amountAfterExchange;
    @Column
    private String status;

    public Exchange(){

    }

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime modifiedAt;


}
