package com.algar.absa.PruebaAlgar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.algar.absa.PruebaAlgar.service.ClimaService;

@RestController
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping("/clima/actual/{ciudad}")
    public String obtenerClimaActual(@PathVariable String ciudad) {
        return climaService.obtenerClimaActual(ciudad);
    }
}