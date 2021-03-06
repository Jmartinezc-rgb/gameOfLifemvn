/*Copyright 2021 Javier Martínez Cristóbal
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package main.java.practica2.dominio;
/*
* Esta clase es responsable de leer el tablero de un
* fichero en forma de ceros y unos, ir transitando de
* estados e ir mostrando dichos estados.
*/

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @version final 24/03/2021
 * @author Javier Martínez
 */
public class Tablero {
    private static int DIMENSION = 30;
    private int[][] estadoActual = new int[DIMENSION+2][DIMENSION+2];
    private int[][] estadoSiguiente = new int[DIMENSION+2][DIMENSION+2]; 

    /********************************************************
     * Lee el estado inicial de un fichero llamado ‘matriz‘.
     ********************************************************/
     // La secuencia de ceros y unos del fichero es guardada en ‘estadoActual‘ y, utilizando las reglas del juego de la vida,
    // se insertan los ceros y unos correspondientes en ‘estadoSiguiente‘.

    /********************************************************
     * Genera un estado inicial aleatorio. Para cada celda
     * genera un número aleatorio en el intervalo [0, 1). Si
     * el número es menor que 0,5, entonces la celda está
     * inicialmente viva. En caso contrario, está muerta.
     * Las variables f y c representan las filas y columnas de la matriz
     * 
     * Complejidad temporal: O(n log n)
     * Complejidad espacial: O(1)
     *******************************************************/
    public void leerEstadoActual() {
        FileReader fichero;
        try {
            fichero = new FileReader("matriz");
            Scanner sc = new Scanner(fichero);
            for (int f = 0; f < DIMENSION; f++) {
                String linea = sc.nextLine();
                for (int c = 0; c < DIMENSION; c++) {
                    estadoActual[f+1][c+1] = Character.getNumericValue(linea.charAt(c));
                }
            }

            for (int f = 1; f < DIMENSION+ 1; f++) {
                for (int c = 1; c < DIMENSION+1; c++) {
                    int vecinasVivas = estadoActual[f - 1][c - 1] + estadoActual[f - 1][c] + estadoActual[f - 1][c + 1]
                                + estadoActual[f][c - 1] + estadoActual[f][c + 1] + estadoActual[f + 1][c - 1] +
                                estadoActual[f + 1][c] + estadoActual[f + 1][c + 1];
                    if (estadoActual[f][c] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                        estadoSiguiente[f][c] = 1;
                    } else if (estadoActual[f][c] == 0 && vecinasVivas == 3) {
                        estadoSiguiente[f][c] = 1;
                    } else {
                        estadoSiguiente[f][c] = 0;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // La secuencia de ceros y unos generada es guardada
    // en ‘estadoActual‘ y, utilizando las reglas del juego
    // de la vida, se insertan los ceros y unos
    // correspondientes en ‘estadoSiguiente‘.
    /********************************************************
    * Transita al estado siguiente según las reglas del
    * juego de la vida.

    * Complejidad temporal: O(n log n)
    * Complejidad espacial: O(1)
    ********************************************************/
    public void generarEstadoActualPorMontecarlo() {

        for (int f = 0; f < DIMENSION; f++) {
            for (int c = 0; c < DIMENSION; c++) {
                estadoActual[f+1][c+1] = (int) Math.round(Math.random());
            }
        }

        for (int f = 1; f < DIMENSION+1; f++) {
            for (int c = 1; c < DIMENSION+1; c++) {
                int vecinasVivas = estadoActual[f - 1][c - 1] + estadoActual[f - 1][c] + estadoActual[f - 1][c + 1]
                        + estadoActual[f][c - 1] + estadoActual[f][c + 1] + estadoActual[f + 1][c - 1] +
                        estadoActual[f + 1][c] + estadoActual[f + 1][c+ 1];
                if (estadoActual[f][c] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                    estadoSiguiente[f][c] = 1;
                } else if (estadoActual[f][c] == 0 && vecinasVivas == 3) {
                    estadoSiguiente[f][c] = 1;
                } else {
                    estadoSiguiente[f][c] = 0;
                }
            }
        }
    }

    // La variable ‘estadoActual‘ pasa a tener el contenido
    // de ‘estadoSiguiente‘ y, éste útimo atributo pasar a
    // reflejar el siguiente estado.
    /*******************************************************
    * Devuelve, en modo texto, el estado actual.
    * @return el estado actual.

    * Complejidad temporal: O(n log n)
    * Complejidad espacial: O(1)
    *******************************************************/
    public void transitarAlEstadoSiguiente() {
        estadoSiguiente = new int[DIMENSION+2][DIMENSION+2];
        for (int f = 1; f < DIMENSION+1; f++) {
            for (int c = 1; c < DIMENSION+1; c++) {
                int vecinasVivas = estadoActual[f - 1][c - 1] + estadoActual[f - 1][c] + estadoActual[f - 1][c + 1]
                        + estadoActual[f][c- 1] + estadoActual[f][c+ 1] + estadoActual[f + 1][c - 1] +
                        estadoActual[f + 1][c] + estadoActual[f+ 1][c + 1];
                if (estadoActual[f][c] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                    estadoSiguiente[f][c] = 1;
                } else if (estadoActual[f][c] == 0 && vecinasVivas == 3) {
                    estadoSiguiente[f][c] = 1;
                } else {
                    estadoSiguiente[f][c] = 0;
                }
            }
        }
        estadoActual = estadoSiguiente;
    }
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for (int f = 1; f < DIMENSION+1; f++) {
            for (int c = 1; c < DIMENSION+1; c++) {
                if (estadoActual[f][c] == 0) {
                    cadena.append(" ");
                } else {
                    cadena.append("x");
                }
            }
            cadena.append("\n");
        }
        return cadena.toString();
    }
}
