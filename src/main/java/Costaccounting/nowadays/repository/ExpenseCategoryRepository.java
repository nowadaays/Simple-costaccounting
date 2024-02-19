package Costaccounting.nowadays.repository;

import Costaccounting.nowadays.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory , Long> {
}
