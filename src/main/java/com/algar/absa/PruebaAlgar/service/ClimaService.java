package com.algar.absa.PruebaAlgar.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.algar.absa.PruebaAlgar.model.Clima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class ClimaService {

    @Autowired
    private HistoricoService historicoService;

    @Value("${clima.apikey}")
    private String apiKey;

    public String obtenerClimaActual(String ciudad) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", ciudad, apiKey);

        String datosClima = "";

        ResponseEntity<Clima> response = restTemplate.getForEntity(url, Clima.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            Clima.Weather weather = response.getBody().getWeather()[0];
            datosClima = "El clima de " + ciudad + " es " + weather.getMain();
        } else {
            datosClima = "No se pudo obtener el clima para " + ciudad;
        }

        historicoService.agregarRegistroHistorico(ciudad, datosClima);
        return datosClima;
    }
}