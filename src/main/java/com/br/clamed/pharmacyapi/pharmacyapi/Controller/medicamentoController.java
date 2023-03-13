package com.br.clamed.pharmacyapi.pharmacyapi.Controller;

import com.br.clamed.pharmacyapi.pharmacyapi.Entity.medicamentoEntity;
import com.br.clamed.pharmacyapi.pharmacyapi.Service.medicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000 ")
@RequestMapping("/medicamentos")
public class medicamentoController {


    private final com.br.clamed.pharmacyapi.pharmacyapi.Service.medicamentoService medicamentoService;

    public medicamentoController(medicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarMedicamento(@Validated @RequestBody medicamentoEntity medicamento) {
        return medicamentoService.cadastrarMedicamento(medicamento);
    }

    @GetMapping
    public ResponseEntity<?> listarMedicamentos() {
        return medicamentoService.listarMedicamentos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarMedicamento(@PathVariable Long id, @RequestBody medicamentoEntity medicamento) {
        return medicamentoService.atualizarMedicamento(id, medicamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMedicamentoporID(@PathVariable Long id) {
        return medicamentoService.buscarMedicamentoporID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorID(@PathVariable Long id) {

        return medicamentoService.deletarPorID(id);
    }
}