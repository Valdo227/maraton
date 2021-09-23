package com.maraton;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Verificador extends Thread{
    static int podio = 1;

    List<Corredor> corredores;
    List<Corredor> resultados;

    Verificador(List<Corredor> corredores) {
        this.corredores = corredores;
        this.resultados = new ArrayList<>();
    }

    @Override
    public void run() {
        while (resultados.size() < corredores.size()) {
            corredores.forEach(corredor -> {
                if (!corredor.isAlive() && !resultados.contains(corredor)) {
                    resultados.add(corredor);
                }
            });
        }
        resultados.sort(Comparator.comparingInt(o -> o.lugar));
        System.out.println("\n\t\t\033[33mRESULTADOS DE LA CARRERA");
        System.out.println("\033[33m# \tAgua \tCorredor \t\tNivel");

        resultados.forEach(corredor -> {
            System.out.println("\033[33m" + corredor.lugar + "\t\u001B[0m " +corredor.agua + "\t\t[" + corredor.numero +"] "+corredor.getNombre() + "\t\t" + corredor.nivel);
        });

    }
}
