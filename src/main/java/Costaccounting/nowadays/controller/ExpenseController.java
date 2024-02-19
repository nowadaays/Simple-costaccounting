package Costaccounting.nowadays.controller;

import Costaccounting.nowadays.Expense;
import Costaccounting.nowadays.ExpenseCategory;
import Costaccounting.nowadays.repository.ExpenseCategoryRepository;
import Costaccounting.nowadays.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseRepository expenseRepository;
    private final ExpenseCategoryRepository categoryRepository;

    @Autowired
    public ExpenseController(ExpenseRepository expenseRepository , ExpenseCategoryRepository categoryRepository){
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String showExpenses(Model model){
        List<Expense> expenses = expenseRepository.findAll();
        model.addAttribute("expense" , expenses);
        return "expenses/list";
    }

    @GetMapping("/add")
    public String showExpenseForm(Model model){
        List<ExpenseCategory> categories = categoryRepository.findAll();
        model.addAttribute("categories" , categories);
        model.addAttribute("expense" , new Expense());
        return "expenses/add";
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute Expense expense){
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }
}
