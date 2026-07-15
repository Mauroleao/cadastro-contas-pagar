package com.example.cadastrocontaspagar.controller;

import com.example.cadastrocontaspagar.model.Contaspagar;
import com.example.cadastrocontaspagar.service.ContapagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contas-pagar")
public class ContapagarController {

    @Autowired
    private ContapagarService contapagarService;

    // Endpoint para salvar uma nova conta a pagar
    @PostMapping
    public ResponseEntity<Contaspagar> save(@RequestBody Contaspagar contaspagar) {
        if (contaspagar.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(contapagarService.save(contaspagar));
    }

    // Endpoint para buscar todas as contas a pagar
    @GetMapping
    public ResponseEntity<List<Contaspagar>> findAll() {
        return ResponseEntity.ok(contapagarService.findAll());
    }

    // Endpoint para buscar uma conta a pagar pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Contaspagar> findById(@PathVariable Long id) {
        Optional<Contaspagar> contapagar = contapagarService.findById(id);
        if (contapagar.isPresent()) {
            return ResponseEntity.ok(contapagar.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para atualizar uma conta a pagar
    @PutMapping("/{id}")
    public ResponseEntity<Contaspagar> update(@PathVariable Long id, @RequestBody Contaspagar contaspagar) {
        if (contaspagar.getId() == null || !contaspagar.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Contaspagar updatedContapagar = contapagarService.update(id, contaspagar);
        return ResponseEntity.ok(updatedContapagar);
    }

    // Endpoint para deletar uma conta a pagar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contapagarService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
