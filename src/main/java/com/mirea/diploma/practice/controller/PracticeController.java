package com.mirea.diploma.practice.controller;

import com.mirea.diploma.practice.model.Practice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mirea.diploma.practice.dto.*;
import com.mirea.diploma.practice.service.PracticeService;
import java.util.List;

@RestController
@RequestMapping("/api/practices")
@RequiredArgsConstructor
public class PracticeController {

    private final PracticeService svc;

    @GetMapping
    public ResponseEntity<List<PracticeDto>> list(@RequestParam Long studentId) {
        return ResponseEntity.ok(svc.listForStudent(studentId));
    }

    @PostMapping
    public ResponseEntity<PracticeDto> create(@RequestBody PracticeDto dto) {
        return ResponseEntity.ok(svc.createPractice(dto));
    }


    @PutMapping("/{pracId}/changeStatus")
    public ResponseEntity<ChangeStatusDto> changeStatus (@PathVariable Long pracId, @RequestBody ChangeStatusDto dto) {
        return ResponseEntity.ok(svc.changeStatusOfPractice(pracId, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PracticeDto> update(@PathVariable Long id,
                                              @RequestBody PracticeDto dto) {
        return ResponseEntity.ok(svc.updatePractice(id, dto));
    }

    @GetMapping("/{id}/versions")
    public ResponseEntity<List<VersionDto>> versions(@PathVariable Long id) {
        return ResponseEntity.ok(svc.listVersions(id));
    }

    @PostMapping("/{id}/versions")
    public ResponseEntity<VersionDto> createVersion(@PathVariable Long id,
                                                    @RequestBody VersionDto dto) {
        return ResponseEntity.ok(svc.createVersion(id, dto));
    }

    @PutMapping("/versions/{id}/comment")
    public ResponseEntity<CommentDto> commentVersion(@PathVariable Long id,
                                              @RequestBody CommentDto dto) {
        return ResponseEntity.ok(svc.commentVersion(id, dto));
    }

    @GetMapping("/versions/{verId}/blocks")
    public ResponseEntity<List<BlockDto>> blocks(@PathVariable Long verId) {
        return ResponseEntity.ok(svc.listBlocks(verId));
    }

    @PostMapping("/versions/{verId}/blocks")
    public ResponseEntity<BlockDto> addBlock(@PathVariable Long verId,
                                             @RequestBody BlockDto dto) {
        return ResponseEntity.ok(svc.addBlock(verId, dto));
    }
}