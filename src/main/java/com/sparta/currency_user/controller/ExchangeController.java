package com.sparta.currency_user.controller;


import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.service.ExchangeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
