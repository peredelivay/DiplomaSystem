package com.mirea.diploma.practice.controller;

import com.mirea.diploma.practice.model.Block;
import com.mirea.diploma.practice.service.PracticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/practices/version")
public class BlockController {
    private final PracticeService practiceService;
    public BlockController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }
    @PostMapping("/{versionId}/block")
    public ResponseEntity<Block> addBlock(@PathVariable Long versionId, @RequestBody Block block) {
        return ResponseEntity.ok(practiceService.addBlock(versionId, block));
    }
}
