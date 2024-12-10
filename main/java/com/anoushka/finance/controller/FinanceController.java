package com.anoushka.finance.controller;

import com.anoushka.finance.model.Finance;
import com.anoushka.finance.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/finances")
public class FinanceController {

    private final FinanceService financeService;

    @Autowired
    public FinanceController(FinanceService expenseService) {
        this.financeService = expenseService;
    }

    @PostMapping
    public ResponseEntity<Finance> createExpense(@RequestBody Finance expense) {
        Finance createdExpense = financeService.createFinance(expense);
        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
    }

    @GetMapping("/range")
    public ResponseEntity<List<Finance>> getExpensesByDateRange(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<Finance> expenses = financeService.getExpensesByDateRange(start, end);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/income")
    public ResponseEntity<BigDecimal> getTotalIncome(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        BigDecimal totalIncome = financeService.getTotalIncome(start, end);
        return ResponseEntity.ok(totalIncome);
    }

    @GetMapping("/expenses")
    public ResponseEntity<BigDecimal> getTotalExpenses(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        BigDecimal totalExpenses = financeService.getTotalExpenses(start, end);
        return ResponseEntity.ok(totalExpenses);
    }
    
    @GetMapping("/user/{userId}")
	public ResponseEntity<List<Finance>> getFinancesByUser(@PathVariable Long userId) {
	    List<Finance> finances = financeService.getFinancesByUser(userId);
	    return ResponseEntity.ok(finances);
	}
}
