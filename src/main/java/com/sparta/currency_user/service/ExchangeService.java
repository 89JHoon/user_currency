package com.sparta.currency_user.service;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExchangeService {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Exchange createExchange(Long userId, Long currencyId, BigDecimal amountInKrw) {
        User user = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :userId", User.class).setParameter("userId", userId).getSingleResult();
        Currency currency = entityManager.createQuery("SELECT c FROM Currency C WHERE c.id=:currencyId", Currency.class).setParameter("currencyId", currencyId).getSingleResult();

        BigDecimal exchangeRate = new BigDecimal(currency.getExchangeRate().toString());
        BigDecimal amountAfterExchange =  amountInKrw.divide(exchangeRate,2, RoundingMode.HALF_UP);

        Exchange exchange = new Exchange();
        exchange.setUser(user);
        exchange.setCurrency(currency);
        exchange.setAmountInKwr(amountInKrw);
        exchange.setAmountAfterExchange(amountAfterExchange);
        exchange.setStatus("normal");
        exchange.setCreatedAt(LocalDateTime.now());
        exchange.setModifiedAt(LocalDateTime.now());

        entityManager.persist(exchange);

        return exchange;
    }


    public List<Exchange> getAllExchangeByUerId(Long userId){
        String jpql = "SELECT e FROM Exchange e WHERE e.user.id = :userId";
        return entityManager.createQuery(jpql,Exchange.class).setParameter("userId",userId).getResultList();
    }

    public Exchange exchangeCancel(Long requestId ){
        Exchange exchange = entityManager.createQuery("SELECT e FROM Exchange e WHERE e.id=:requestId",Exchange.class).setParameter("requestId",requestId).getSingleResult();
        exchange.setStatus(("canceled"));
        exchange.setModifiedAt(LocalDateTime.now());
        entityManager.persist(exchange);
        return exchange;
    }
}
