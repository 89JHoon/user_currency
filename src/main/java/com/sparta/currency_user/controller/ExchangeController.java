package com.sparta.currency_user.controller;


import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.service.ExchangeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    //환전 요청
    @PostMapping
    public ResponseEntity<Exchange> createExchangeRequest(@RequestBody ExchangeRequestDto requestDto){
        Exchange exchange = exchangeService.createExchange(requestDto.getUserId(),requestDto.getCurrencyId(),requestDto.getAmountInKrw());
        return ResponseEntity.ok(exchange);
    }

    //환전 내역 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Exchange>> getExchagreList(@PathVariable Long userId){
        List<Exchange>exchangesList = exchangeService.getAllExchangeByUerId(userId);
        return ResponseEntity.ok(exchangesList) ;
    }

}
