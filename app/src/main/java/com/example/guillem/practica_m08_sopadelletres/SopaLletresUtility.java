package com.example.guillem.practica_m08_sopadelletres;


import java.util.ArrayList;
import java.util.Random;

public final class SopaLletresUtility {

    public static String paraules[];
    public static int posicions[][];
    public static String taula[];

    /**
     * mètode encarregat d'escriure les paraules en horitzontal
     * @param t on t és igual a la posició dins l'array de la paraula que volem escriure
     */
    private static void generarParaula(int t, int tipus) {
        boolean sortida = false;
        int delta = 1;
        switch (tipus){
            case 0:
                delta = 1;
                break;
            case 1:
                delta = 7;
                break;
            case 2:
                delta = 7+1;
                break;
        }
        int cmpt = 0;
        do {
            int pinicial = posicioInicial();
            int pfinal = pinicial + (paraules[t].length() - 1) * delta;
            boolean ple = false;
            System.out.println("tipus: " + tipus + "delta: " + delta + "posicioinicial: " + pinicial + "t: " + t);
            boolean error = false;
            switch (tipus){
                case 0:
                    if (calcularFila(pinicial) != calcularFila(pfinal))
                        error = true;
                    break;
                case 1:
                    if(pfinal > 48)
                        error = true;
                    break;
                case 2:
                    if(calcularColumna(pinicial) > calcularColumna(pfinal) || pfinal > 48)
                        error = true;
                    break;
            }
            if (!error) {
                /*System.out.println("estims dins error");
                for (String n:taula) {
                    System.out.println(n);
                }*/
                for (int j = 0, k = 0; j < paraules[t].length(); j++, k += delta) {
                    System.out.println("a" + taula[pinicial + k] +"a");
                    if (!taula[pinicial + k].equals(" ")) {
                        ple = true;
                    }
                }
                if (!ple) {
                    for (int i = 0, k = 0; i < paraules[t].length(); i++, k+= delta) {
                        taula[pinicial + k] = Character.toString(paraules[t].charAt(i));
                        posicions[t][i] = pinicial + k;
                        System.out.println("char[" + i + "]" + taula[pinicial + k]);
                    }
                    System.out.println("true");
                    sortida = true;
                }
            }
            cmpt++;
            if(cmpt == 400){
                System.exit(1);
            }
        } while (!sortida);
    }

    /**
     * mètode encarregat de decidir aleatoriament en quina direcció se situaran les paraules dins la sopa de lletres (horitzontal, diagonal o vertical)
     */
    static void direccioParaula() {
        Random r = new Random();
        for (int t = 0; t < 5; t++) {
            generarParaula(t, r.nextInt(3));
        }
        for(int t = 0; t < 5; t++){
            for(int i= 0; i < 8; i++){
                System.out.println("posicio[" + t + "]" + "[" + i + "]" + posicions[t][i]);
            }
        }
    }

    static void inicialitzarTaula() {
        taula = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        posicions = new int[5][8];
    }


    /**
     * funció que tria aleatoriament la posició de la primera lletra de la paraula en qüestió
     *
     * @return obtenim la posició de la primera lletra
     */
    public static int posicioInicial() {

        Random r = new Random();
        int posicioInicial = r.nextInt(48);
        return posicioInicial;
    }

    /**
     * @param position posició d'una lletra
     * @return ens torna un valor que ens permet controlar si la paraula s'ha escrit en la fila desitjada
     */
    public static int calcularFila(int position) {
        return position / 7;
    }

    /**
     * @param position posició d'una lletra
     * @return ens torna un valor que ens permet controlar si la paraula s'ha escrit en la columna desitjada
     */
    public static int calcularColumna(int position) {
        return position % 7;
    }

}

/*      [ 0][ 1][ 2][ 3][ 4][ 5][ 6]
        [ 7][ 8][ 9][10][11][12][13]
        [14][15][16][17][18][19][20]
        [21][22][23][24][25][26][27]
        [28][29][30][31][32][33][34]
        [35][36][37][38][39][40][41]
        [42][43][44][45][46][47][48]

        */

