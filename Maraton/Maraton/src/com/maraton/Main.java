package com.maraton;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String rojo ="\033[31m";
        String verde ="\033[32m";
        String amarillo ="\033[33m";
        String azul ="\033[34m";
        String purpura ="\033[35m";

        Corredor corredor1 = new Corredor(1,"Juan", "Profesional", rojo);
        Corredor corredor2 = new Corredor(2,"Berto", "Experto", verde);
        Corredor corredor3 = new Corredor(3,"Mario", "Experto", amarillo);
        Corredor corredor4 = new Corredor(4,"Hiram", "Novato", azul);
        Corredor corredor5 = new Corredor(5,"Valdo", "Novato", purpura);
        Corredor corredor6 = new Corredor(6,"Carla", "Profesional", rojo);
        Corredor corredor7 = new Corredor(7,"Mauro", "Novato", verde);
        Corredor corredor8 = new Corredor(8,"Pablo", "Experto", amarillo);
        Corredor corredor9 = new Corredor(9,"Pedro", "Profesional", azul);
        Corredor corredor10 = new Corredor(10,"Luis", "Novato", purpura);

        List<Corredor> corredores = Arrays.asList(corredor1, corredor2, corredor3, corredor4, corredor5,
                corredor6, corredor7, corredor8, corredor9, corredor10);

        Verificador verificador = new Verificador(corredores);
        verificador.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Los corredores se preparan");

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();
        corredor9.start();
        corredor10.start();

        verificador.start();
    }

}
