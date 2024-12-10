package com.anoushka.finance.repository;

import com.anoushka.finance.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
    List<Finance> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Finance> findByUserId(Long userId);
}
