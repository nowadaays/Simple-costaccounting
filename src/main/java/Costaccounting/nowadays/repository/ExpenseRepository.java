package Costaccounting.nowadays.repository;

import Costaccounting.nowadays.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense , Long> {
    List<Expense> findByDateBetween(LocalDate start , LocalDate endDate);
}
