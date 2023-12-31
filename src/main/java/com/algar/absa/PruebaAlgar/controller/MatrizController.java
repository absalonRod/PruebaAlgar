package com.algar.absa.PruebaAlgar.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.algar.absa.PruebaAlgar.service.MatrizService;
import com.algar.absa.PruebaAlgar.model.Matriz;

@RestController
@RequestMapping("/matriz")
public class MatrizController {

    @Autowired
    private MatrizService matrizService;

    @PostMapping("/multiplicar")
    public ResponseEntity<?> multiplicarMatrices(@RequestBody Matriz matrizRequest) {
        try {
            int[][] resultado = matrizService.multiplicar(matrizRequest.getMatriz1(), matrizRequest.getMatriz2());
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}