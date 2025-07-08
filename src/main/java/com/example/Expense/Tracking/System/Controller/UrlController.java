package com.example.Expense.Tracking.System.Controller;

import com.example.Expense.Tracking.System.Model.ClickLog;
import com.example.Expense.Tracking.System.Service.AnalyticsService;
import com.example.Expense.Tracking.System.Service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;
    private final AnalyticsService analyticsService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestParam String longUrl) {
        String shortCode = urlService.shortenUrl(longUrl);
        return ResponseEntity.ok("http://localhost:8082/api/" + shortCode);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode, HttpServletRequest request) {
        String longUrl = urlService.getOriginalUrl(shortCode);
        String ipAddress = request.getRemoteAddr();
        analyticsService.logClick(shortCode, ipAddress);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl)).build();
    }

    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<List<ClickLog>> getStats(@PathVariable String shortCode) {
        return ResponseEntity.ok(analyticsService.getClicks(shortCode));
    }
}

