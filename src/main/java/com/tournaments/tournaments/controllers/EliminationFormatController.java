package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.entities.EliminationFormat;
import com.tournaments.tournaments.services.EliminationFormatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournament/elimination-formats")
public class EliminationFormatController {
    private final EliminationFormatService eliminationFormatService;

    public EliminationFormatController(EliminationFormatService eliminationFormatService) {
        this.eliminationFormatService = eliminationFormatService;
    }

    // Create a new EliminationFormat
    @PostMapping
    public ResponseEntity<EliminationFormat> createEliminationFormat(@RequestBody EliminationFormat eliminationFormat) {
        EliminationFormat createdFormat = eliminationFormatService.createEliminationFormat(eliminationFormat);
        return ResponseEntity.ok(createdFormat);
    }

    // Get all EliminationFormats
    @GetMapping
    public ResponseEntity<List<EliminationFormat>> getAllEliminationFormats() {
        List<EliminationFormat> formats = eliminationFormatService.getAllEliminationFormats();
        return ResponseEntity.ok(formats);
    }

    // Get an EliminationFormat by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EliminationFormat>> getEliminationFormatById(@PathVariable("id") Integer id) {
        Optional<EliminationFormat> format = eliminationFormatService.getEliminationFormatById(id);
        return ResponseEntity.ok(format);
    }

    // Update an EliminationFormat
    @PutMapping("/{id}")
    public ResponseEntity<Optional<EliminationFormat>> updateEliminationFormat(
            @PathVariable("id") Integer id,
            @RequestBody EliminationFormat eliminationFormat) {
        Optional<EliminationFormat> updatedFormat = eliminationFormatService.updateEliminationFormatById(id, eliminationFormat);
        return ResponseEntity.ok(updatedFormat);
    }

    // Delete an EliminationFormat
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEliminationFormat(@PathVariable("id") Integer id) {
        eliminationFormatService.deleteEliminationFormatById(id);
        return ResponseEntity.noContent().build();
    }
}