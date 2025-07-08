package com.example.Expense.Tracking.System.Repository;

import com.example.Expense.Tracking.System.Model.ClickLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClickLogRepository extends JpaRepository<ClickLog, Long> {
    List<ClickLog> findByShortCode(String shortCode);
}
