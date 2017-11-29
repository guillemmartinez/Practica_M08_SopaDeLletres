package com.example.guillem.practica_m08_sopadelletres;


import java.util.ArrayList;
import java.util.Random;

public final class SopaLletresUtility {

 public static String paraules[] = {"ANDROID","JAVA","PYTHON","RUBY","PHP"};
 public static String taula[] = new String[49];

    public static void generarParaula(int position){

        boolean sortida = false;

        do{
            int pinicial = posicioInicial();
            int pfinal = pinicial + paraules[0].length()-1;
            System.out.println("aaaaaaaaaaaaaaaaaaaaa");
            if(calcularFila(pinicial) == calcularFila(pfinal)){

                for ( int i = 0; i<= (paraules[0].length() -1); i++){
                    taula[pinicial+i] = Character.toString(paraules[0].charAt(i));
                    System.out.println("char["+i+"]"+taula[pinicial+i]);
                }
                System.out.println("true");
                sortida = true;
            }

        }while (!sortida);



    }

    public static  int posicioInicial(){

        Random r = new Random();
        int posicioInicial = r.nextInt(48);
        return posicioInicial;
    }

    public static int calcularFila(int position){return position / 7;}
    public static int calcularColumna (int position){return position % 7;}

}



