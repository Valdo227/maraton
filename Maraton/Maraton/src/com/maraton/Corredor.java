package com.maraton;

import java.util.Random;

public class Corredor extends Thread{

    int numero;
    String color;
    String nombre;
    String nivel;
    float velocidad;
    int lugar;
    int agua;

    public Corredor(int numero, String nombre,String nivel, String color) {
        Random random = new Random();
        this.numero = numero;
        this.nombre = nombre;
        this.color = color;
        this.nivel = nivel;
        this.lugar = 0;
        this.agua = 0;

        switch (nivel) {
            case "Novato":
                velocidad = random.nextInt(2) + 3;
                break;
            case "Experto":
                velocidad = random.nextInt(2) + 2;
                break;
            case "Profesional":
                velocidad = random.nextInt(2) + 1;
                break;
        }
    }

    @Override
    public void run(){
        Random random = new Random();
        String reset="\u001B[0m";

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(color +"El "+ nivel +" "+nombre +" con numero "+ numero +" ha iniciado la carrera"+ reset);

        for(int i = 1; i<10; i++){
            if(i%3 == 0){
                int rand = random.nextInt(9) + 1;
                if(rand <= 2){
                    agua++;
                    System.out.println(color +"Corredor "+ numero +""+ reset +" lleva "+ i +" KM (" + rand + ") (Tomando agua 2seg)");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println(color +"Corredor "+ numero +""+ reset +" lleva "+ i +" KM "+rand);
                }
            }
            else{
                System.out.println(color +"Corredor "+ numero +""+ reset +" lleva "+ i +" KM ");
            }

            try {
                Thread.sleep((long) (velocidad* 400L));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.lugar = Verificador.podio++;
        System.out.println(color +"El "+ nivel +" "+nombre +" con el numero "+ numero +" llegó a la meta a "+ (1/velocidad)*12 +" km/h"+ reset);

    }

    public String getNombre() {
        return nombre;
    }
}
