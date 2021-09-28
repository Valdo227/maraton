package com.maraton;

import java.text.DecimalFormat;
import java.util.Random;

public class Corredor extends Thread{

    int numero;
    String color;
    String nombre;
    String nivel;
    float velocidad;
    int lugar;
    int agua;
    int condicion;
    String termino;

    public Corredor(int numero, String nombre,String nivel, String color) {
        Random random = new Random();
        this.numero = numero;
        this.nombre = nombre;
        this.color = color;
        this.nivel = nivel;
        this.lugar = 0;
        this.agua = 0;
        this.condicion = 0;
        this.termino = "Sí";

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
        DecimalFormat df = new DecimalFormat("#.0");
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
                    System.out.println(color +"Corredor "+ numero +""+ reset +" lleva "+ i +" KM (" + rand + ") (Tomando agua)");
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println(color +"Corredor "+ numero +""+ reset +" lleva "+ i +" KM "+rand);
                }
            }
            else if(i%2 == 0){
                int rand = random.nextInt(10) + 1;
                if(rand <= 6){
                    System.out.println(color +"Corredor "+ numero +""+ reset +" lleva "+ i +" KM ("+ rand + ")");
                }
                else if(rand <= 8){
                    System.out.println(color +"Corredor "+ numero +""+ reset +" lleva "+ i +" KM " + " y tuvo una pequeña lesión ("+ rand +")");
                    velocidad += velocidad*.2;
                }
                else  if(rand == 9){
                    System.out.println(color +"Corredor "+ numero +""+ reset +" lleva "+ i +" KM " + " y tuvo una lesión grave ("+ rand +")");
                    velocidad += velocidad*.5;
                }
                else{
                    System.out.println(color +"Corredor "+ numero +""+ reset +" llego al "+ i +" KM " + " y se retiró ("+ rand +")");
                    termino = "No";
                    lugar = 11;
                    this.stop();
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

        if(termino.equals("Sí")) {
            System.out.println(color + "El " + nivel + " " + nombre + " con el numero " + numero + " llegó a la meta a " + df.format((1 / velocidad) * 12) + " km/h" + reset);
            lugar = Verificador.podio++;
        }
    }

    public String getNombre() {
        return nombre;
    }
}
