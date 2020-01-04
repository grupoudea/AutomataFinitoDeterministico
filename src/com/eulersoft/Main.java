package com.eulersoft;

import java.util.Scanner;

public class Main {
    static Simbolo simbolos[] = new Simbolo[6];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	    String listaSimbolos[] = {"F","V","&","|","!","="};
        String listaEstados[];

	    String estado = "OP";

	    do {
            System.out.println("escriba el simbolo");
            String simbolo = scanner.next();

            switch (estado){
                case "OP":
                    listaEstados = new String[]{"FV", "FV", "E", "E", "!N", "E"};
                    llenarArreglo(listaSimbolos, listaEstados);
                    estado = retornarEstado(simbolo);
                    break;
                case "FV":
                    listaEstados = new String[]{"E","E","&","|","!DL=","!DL="};
                    llenarArreglo(listaSimbolos, listaEstados);
                    estado = retornarEstado(simbolo);
                    break;
                case "&":
                    listaEstados = new String[]{"E","E","OP","E","E","E"};
                    llenarArreglo(listaSimbolos, listaEstados);
                    estado = retornarEstado(simbolo);
                    break;
                case "|":
                    listaEstados = new String[]{"E","E","E","OP","E","E"};
                    llenarArreglo(listaSimbolos, listaEstados);
                    estado = retornarEstado(simbolo);
                    break;
                case "!DL=":
                    listaEstados = new String[]{"E","E","E","E","E","OP"};
                    llenarArreglo(listaSimbolos, listaEstados);
                    estado = retornarEstado(simbolo);
                    break;
                case "!N":
                    listaEstados = new String[]{"FV","FV","E","E","E","E"};
                    llenarArreglo(listaSimbolos, listaEstados);
                    estado = retornarEstado(simbolo);
                    break;
                case "E":
                    //listaEstados = new String[]{"E","E","E","E","E","E"};
                    //llenarArreglo(listaSimbolos, listaEstados);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + estado);
            }
        }while (estado!="E");

    }

    private static String retornarEstado(String simbolo) {
        for (int i = 0; i < simbolos.length; i++) {
            if (simbolos[i].getSimbolo().equals(simbolo)){
                return simbolos[i].getEstado();
            }
        }
        return "E";
    }

    static void llenarArreglo(String[] listaSimbolos, String[] listaEstados){
        for (int i = 0; i < simbolos.length; i++) {
            simbolos[i]= new Simbolo();
            simbolos[i].setSimbolo(listaSimbolos[i]);
            simbolos[i].setEstado(listaEstados[i]);
        }
    }
}
