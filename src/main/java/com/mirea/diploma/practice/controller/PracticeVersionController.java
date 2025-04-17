package com.mirea.diploma.practice.controller;

import com.mirea.diploma.practice.model.PracticeVersion;
import com.mirea.diploma.practice.service.PracticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/practices")
public class PracticeVersionController {
    private final PracticeService practiceService;
    public PracticeVersionController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }
    @PostMapping("/{id}/version")
    public ResponseEntity<PracticeVersion> createVersion(@PathVariable Long id, @RequestBody PracticeVersion version) {
        return ResponseEntity.ok(practiceService.createVersion(id, version));
    }
}
