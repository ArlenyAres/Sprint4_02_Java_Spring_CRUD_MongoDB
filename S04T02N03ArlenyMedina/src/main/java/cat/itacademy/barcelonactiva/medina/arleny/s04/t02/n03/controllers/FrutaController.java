package cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.controllers;


import cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.exceptions.FrutaNotFoundException;
import cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.model.domain.Fruta;
import cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.model.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>> getAllFrutas() {
        try {
            List<Fruta> frutasList = frutaService.getAllFrutas();
            if (frutasList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(frutasList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruta> getFrutaById(@PathVariable long id) {
        try {
            Fruta frutaData = frutaService.getFrutaById(id);
            return new ResponseEntity<>(frutaData, HttpStatus.OK);
        } catch (FrutaNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Fruta> addFruta(@RequestBody Fruta fruta) {
        try {
            Fruta frutaObj = frutaService.addFruta(fruta);
            return new ResponseEntity<>(frutaObj, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Fruta> updateFrutaById(@PathVariable long id, @RequestBody Fruta newFrutaData) {
        try {
            Fruta updatedFruta = frutaService.updateFruta(id, newFrutaData);
            return new ResponseEntity<>(updatedFruta, HttpStatus.OK);
        } catch (FrutaNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFrutaById(@PathVariable long id) {
        try {
            frutaService.deleteFruta(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FrutaNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
