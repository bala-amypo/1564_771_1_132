package com.example.barter.controller;

import com.example.barter.model.BarterTransaction;
import com.example.barter.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction", description = "Barter transaction endpoints")
@CrossOrigin(origins = "*")
public class TransactionController {
    
    private final TransactionService transactionService;
    
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    @PostMapping
    public ResponseEntity<BarterTransaction> createTransaction(@RequestParam Long matchId) {
        return ResponseEntity.ok(transactionService.createTransaction(matchId));
    }
    
    @GetMapping
    public ResponseEntity<List<BarterTransaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BarterTransaction> getTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }
    
    @PutMapping("/{id}/complete")
    public ResponseEntity<BarterTransaction> completeTransaction(
            @PathVariable Long id,
            @RequestParam(required = false) Integer offererRating,
            @RequestParam(required = false) Integer requesterRating) {
        return ResponseEntity.ok(transactionService.completeTransaction(id, offererRating, requesterRating));
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<BarterTransaction>> getTransactionsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(transactionService.getTransactionsByStatus(status));
    }
}