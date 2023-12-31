package com.algar.absa.PruebaAlgar.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class MatrizService {

    public int[][] multiplicar(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int columnas2 = matriz2[0].length;
        int[][] resultado = new int[filas1][columnas2];

        ExecutorService executor = Executors.newFixedThreadPool(filas1);

        for (int i = 0; i < filas1; i++) {
            final int fila = i;
            executor.execute(() -> {
                for (int j = 0; j < columnas2; j++) {
                    int valor = 0;
                    for (int k = 0; k < columnas1; k++) {
                        valor += matriz1[fila][k] * matriz2[k][j];
                    }
                    resultado[fila][j] = valor;
                }
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return resultado;
    }
}