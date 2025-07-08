package com.example.Expense.Tracking.System.Repository;

import com.example.Expense.Tracking.System.Model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UrlRepository extends JpaRepository<UrlMapping , String> {
}
