package com.algar.absa.PruebaAlgar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.algar.absa.PruebaAlgar.service.HistoricoService;
import com.algar.absa.PruebaAlgar.model.RegistroClima;

import java.util.List;

@RestController
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/historico")
    public List<RegistroClima> obtenerHistorico() {
        return historicoService.obtenerHistorico();
    }
}