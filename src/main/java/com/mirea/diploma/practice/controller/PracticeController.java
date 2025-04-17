package com.mirea.diploma.practice.controller;

import com.mirea.diploma.practice.dto.PracticeReportDto;
import com.mirea.diploma.practice.model.PracticeReport;
import com.mirea.diploma.practice.model.PracticeVersion;
import com.mirea.diploma.practice.model.Block;
import com.mirea.diploma.practice.service.PracticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/practices")
public class PracticeController {
    private final PracticeService practiceService;
    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }
    @GetMapping
    public ResponseEntity<List<PracticeReport>> getAllPractices() {
        return ResponseEntity.ok(practiceService.getAllPractices());
    }
    @PostMapping
    public ResponseEntity<PracticeReport> createPractice(@RequestBody PracticeReportDto dto) {
        return ResponseEntity.ok(practiceService.createPractice(dto));
    }
    @PostMapping("/{id}/submit")
    public ResponseEntity<PracticeReport> submitPractice(@PathVariable Long id) {
        return ResponseEntity.ok(practiceService.submitPractice(id));
    }
}
