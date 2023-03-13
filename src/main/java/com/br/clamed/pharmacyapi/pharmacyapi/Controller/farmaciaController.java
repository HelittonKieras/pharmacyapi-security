package com.br.clamed.pharmacyapi.pharmacyapi.Controller;


import com.br.clamed.pharmacyapi.pharmacyapi.Entity.farmaciaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000 ")
@RequestMapping("/farmacia")
public class farmaciaController {



    private final com.br.clamed.pharmacyapi.pharmacyapi.Service.farmaciaService farmaciaService;

    public farmaciaController(com.br.clamed.pharmacyapi.pharmacyapi.Service.farmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @PostMapping()
    public ResponseEntity<?> cadastrarFarmacia(@RequestBody farmaciaEntity farmacia){

        return farmaciaService.cadastrarFarmacia(farmacia);
    }
    @GetMapping
    public ResponseEntity<?> buscarFarmacia(){

        return farmaciaService.buscarFarmacia();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFarmacia(@PathVariable Long id) {
        return farmaciaService.buscarFarmaciaPorID(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorID(@PathVariable Long id) {

        return farmaciaService.deletarPorID(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFarmacia(@PathVariable Long id,@RequestBody farmaciaEntity farmacia){
        return farmaciaService.atualizarFarmacia(id, farmacia);
    }
}