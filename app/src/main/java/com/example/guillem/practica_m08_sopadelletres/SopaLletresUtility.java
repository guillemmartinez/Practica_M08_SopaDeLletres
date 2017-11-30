package com.example.guillem.practica_m08_sopadelletres;


import java.util.ArrayList;
import java.util.Random;

public final class SopaLletresUtility {

    public static String paraules[] = {"ANDROID", "JAVA", "PYTHON", "RUBY", "PHP"};
    public static String taula[] = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};

    public static void generarParaula(int position) {

        boolean sortida = false;


        for (int t = 0; t < 5; t++) {
            do {
                int pinicial = posicioInicial();
                int pfinal = pinicial + paraules[t].length() - 1;

                int igual = 0;
                System.out.println("aaaaaaaaaaaaaaaaaaaaa" + t);

                if (calcularFila(pinicial) == calcularFila(pfinal)) {

                    for (int j = 0; j < paraules[j].length() - 1; j++) {
                        if (!taula[pinicial + j].equals(" ")) {

                            igual = 1;
                        }
                    }
                    if (igual == 0) {


                        for (int i = 0; i <= (paraules[t].length() - 1); i++) {
                            taula[pinicial + i] = Character.toString(paraules[t].charAt(i));
                            System.out.println("char[" + i + "]" + taula[pinicial + i]);
                        }
                        System.out.println("true");

                        sortida = true;
                    }

                }

            } while (!sortida);
            sortida = false;
        }


    }

    public static int posicioInicial() {

        Random r = new Random();
        int posicioInicial = r.nextInt(48);
        return posicioInicial;
    }

    public static int calcularFila(int position) {
        return position / 7;
    }

    public static int calcularColumna(int position) {
        return position % 7;
    }

}



