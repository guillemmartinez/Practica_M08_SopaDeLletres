package com.example.guillem.practica_m08_sopadelletres;


import java.util.ArrayList;
import java.util.Random;

public final class SopaLletresUtility {

    public static String paraules[];
    public static String taula[];

    /**
     * mètode encarregat d'escriure les paraules en horitzontal
     * @param t on t és igual a la posició dins l'array de la paraula que volem escriure
     */
    public static void generarParaulaHoritzontal(int t) {

        boolean sortida = false;

        // for (int t = 0; t < 5; t++) {
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
        //    sortida = false;
        //}
    }

    /**
     * mètode encarregat d'escriure les paraules en vertical
     * @param t on t és igual a la posició dins l'array de la paraula que volem escriure
     */
    public static void generarParaulaVertical(int t) {
        boolean sortida = false;

        //for (int t = 0; t < 5; t++) {
        do {
            int pinicial = posicioInicial();
            int pfinal = (pinicial) + ((paraules[t].length() - 1) * 7);
            int igual = 0; // variable que controla si una paraula ja ocupa posicions dins la sopa de lletres
            System.out.println("aaaaaaaaaaaaaaaaaaaaa" + t);


            if (calcularColumna(pinicial) == calcularColumna(pfinal) && pfinal < 49) {
                for (int j = 0, k = 0; j < paraules[j].length() - 1; j++, k += 7) { //comprovem que la paraula mai sobreescrigui una altra anterior abans d'escriure-la
                    if (!taula[pinicial + k].equals(" ")) {
                        igual = 1;
                    }
                }
                if (igual == 0) {
                    for (int i = 0, k = 0; i <= (paraules[t].length() - 1); i++, k += 7) { // si la posició està disponible llavors l'escriu
                        taula[pinicial + k] = Character.toString(paraules[t].charAt(i));
                        System.out.println("char[" + i + "]" + taula[pinicial + k]);
                    }
                    System.out.println("true");
                    sortida = true;
                }
            }
        }
        while (!sortida); //repetim el procés per cada paraula fins que s'hagi pogut col·locar amb èxit
        sortida = false;
        //}
    }


    /**
     * mètode encarregat d'escriure les paraules en diagonal
     * @param t on t és igual a la posició dins l'array de la paraula que volem escriure
     */
    public static void generarParaulaDiagonal(int t) {

        boolean sortida = false;

        // for (int t = 0; t < 5; t++) {
        do {
            int pinicial = posicioInicial();
            int pfinal = (pinicial) + ((paraules[t].length() - 1) * 7) + (paraules[t].length() - 1);
            int igual = 0;
            System.out.println("aaaaaaaaaaaaaaaaaaaaa" + t);

            if (calcularColumna(pinicial) < calcularColumna(pfinal) && pfinal < 49) {
                for (int j = 0, k = 0; j < paraules[j].length() - 1; j++, k += 8) {
                    if (!taula[pinicial + k].equals(" ")) {
                        igual = 1;
                    }
                }
                if (igual == 0) {
                    for (int i = 0, k = 0; i <= (paraules[t].length() - 1); i++, k += 8) {
                        taula[pinicial + k] = Character.toString(paraules[t].charAt(i));
                        System.out.println("char[" + i + "]" + taula[pinicial + k]);
                    }
                    System.out.println("true");
                    sortida = true;
                }
            }
        } while (!sortida);
        sortida = false;
        // }
    }

    /**
     * mètode encarregat de decidir aleatoriament en quina direcció se situaran les paraules dins la sopa de lletres (horitzontal, diagonal o vertical)
     */
    public static void direccioParaula() {
        Random r = new Random();

        for (int t = 0; t < 5; t++) {
            switch (r.nextInt(3)) {
                case 0:
                    generarParaulaHoritzontal(t);
                    break;
                case 1:
                    generarParaulaVertical(t);
                    break;
                case 2:
                    generarParaulaDiagonal(t);
                    break;
            }
        }
    }

    public static void inicialitzarTaula() {
        taula = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
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

