package com.example.Expense.Tracking.System.Service;

import com.example.Expense.Tracking.System.Model.ClickLog;
import com.example.Expense.Tracking.System.Repository.ClickLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final ClickLogRepository clickLogRepository;

    public void logClick (String shortcode, String ipAddress)
    {
        ClickLog clickLog = new ClickLog(null, shortcode, ipAddress, LocalTime.now());
        clickLogRepository.save(clickLog);
    }

    public List<ClickLog> getClicks(String shortCode)
    {
        return clickLogRepository.findByShortCode(shortCode);
    }

}
