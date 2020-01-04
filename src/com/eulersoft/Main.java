package com.eulersoft;

import java.util.Scanner;

public class Main {
    static Simbolo simbolos[] = new Simbolo[6];
    static String simbolo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String listaSimbolos[] = {"F", "V", "&", "|", "!", "="};
        String listaEstados[];

        String estado = "OP";

        do {
            System.out.println("Escriba el simbolo \n SIMBOLOS PERMITIDOS: (F, V, &, |, !, =) SIN ESPACIOS " +
                    "\n PARA TERMINAR ESCRIBA 0");
            simbolo = scanner.next();
            if (!simbolo.equals("0")) {
                switch (estado) {
                    case "OP":
                        listaEstados = new String[]{"FV", "FV", "E", "E", "!N", "E"};
                        llenarArreglo(listaSimbolos, listaEstados);
                        estado = retornarEstado();
                        break;
                    case "FV":
                        listaEstados = new String[]{"E", "E", "&", "|", "!DL=", "!DL="};
                        llenarArreglo(listaSimbolos, listaEstados);
                        estado = retornarEstado();
                        break;
                    case "&":
                        listaEstados = new String[]{"E", "E", "OP", "E", "E", "E"};
                        llenarArreglo(listaSimbolos, listaEstados);
                        estado = retornarEstado();
                        break;
                    case "|":
                        listaEstados = new String[]{"E", "E", "E", "OP", "E", "E"};
                        llenarArreglo(listaSimbolos, listaEstados);
                        estado = retornarEstado();
                        break;
                    case "!DL=":
                        listaEstados = new String[]{"E", "E", "E", "E", "E", "OP"};
                        llenarArreglo(listaSimbolos, listaEstados);
                        estado = retornarEstado();
                        break;
                    case "!N":
                        listaEstados = new String[]{"FV", "FV", "E", "E", "E", "E"};
                        llenarArreglo(listaSimbolos, listaEstados);
                        estado = retornarEstado();
                        break;
                    case "E":
                        System.out.println("Hay un error en tu expresión");
                        break;
                    default:
                        throw new IllegalStateException("No es un caracter permitido: " + estado);
                }
            }
        } while (!simbolo.equals("0"));

    }

    private static String retornarEstado() {
        String estado = "";
        for (int i = 0; i < simbolos.length; i++) {
            if (simbolos[i].getSimbolo().equals(simbolo)) {
                estado = simbolos[i].getEstado();
                break;
            } else {
                estado = "E";
            }
        }
        if (estado.equals("E")) {
            System.out.println("Hay un error en tu expresión");
            simbolo = "0";
        }
        return estado;
    }

    static void llenarArreglo(String[] listaSimbolos, String[] listaEstados) {
        for (int i = 0; i < simbolos.length; i++) {
            simbolos[i] = new Simbolo();
            simbolos[i].setSimbolo(listaSimbolos[i]);
            simbolos[i].setEstado(listaEstados[i]);
        }
    }


}
