package com.algar.absa.PruebaAlgar.service;

import org.springframework.stereotype.Service;
import com.algar.absa.PruebaAlgar.model.RegistroClima;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricoService {

    private final List<RegistroClima> historico = new ArrayList<>();

    public List<RegistroClima> obtenerHistorico() {
        return new ArrayList<>(historico);
    }

    public void agregarRegistroHistorico(String ciudad, String datosClima) {
        if (historico.size() >= 10) {
            historico.remove(0);
        }
        historico.add(new RegistroClima(ciudad, datosClima));
    }
}