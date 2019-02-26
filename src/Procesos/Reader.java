package Procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Reader {


    public static void main(String[] args) {

        //Declarar variables locas

        ArrayList matriculas = new ArrayList<Integer>();
        ArrayList matriculas1 = new ArrayList<Integer>();
        ArrayList matriculas2 = new ArrayList<Integer>();

        Proceso hilo1 = new Proceso();
        Proceso hilo2 = new Proceso();

        Proceso sincrono = new Proceso();

        int divider;

        long Tinicio, TFin, Tiempo;

        // Recuperar el archivo

        File file = new File("matricula.txt");

        try {
            matriculas = readFile(file); //Guardar el resultado en el array con el metodo
        } catch (Exception e) {
            System.out.println(e);
        }

        // Calcular en donde se hara la division del arreglo
        if (matriculas.size() % 2 == 0) {
            divider = matriculas.size() / 2;
        } else {
            divider = (matriculas.size() / 2) + 1;
        }

        Collections.sort(matriculas);
        //Dividiendo el arreglo
        for (int i = 0; i < divider; i++) {
            matriculas1.add(matriculas.get(i));
        }
        for (int j = divider; j < matriculas.size(); j++) {
            matriculas2.add(matriculas.get(j));
        }


        System.out.println("<------------Sincrona---------------->\n\n");

        Tinicio = System.currentTimeMillis();
        sincrono.calcularValores(matriculas);
        System.out.println("Matriculas --> " + sincrono.getContador() +
                "\nPar --> " + sincrono.getPar() +
                "\nImpar --> " + sincrono.getImpar() +
                "\nRepetidas --> " + sincrono.getRepetidos());
        TFin = System.currentTimeMillis();
        Tiempo = TFin - Tinicio;
        System.out.println("Tiempo del proceso -->" + Tiempo + " mlls");


        System.out.println("\n\n<------------Hilos---------------->\n\n");


        hilo1.setHilo(matriculas1);
        hilo2.setHilo(matriculas2);

        Tinicio = System.currentTimeMillis();
        hilo1.start();
        hilo2.start();


        while (true) {
            if (hilo1.isAlive() != true && hilo2.isAlive() != true) {
                break;
            }
        }
        TFin = System.currentTimeMillis();
        System.out.println("Matriculas --> " + (hilo1.getContador() + hilo2.getContador()) +
                "\nPar --> " + (hilo1.getPar() + hilo2.getPar()) +
                "\nImpar --> " + (hilo1.getImpar() + hilo2.getImpar()) +
                "\nRepetidas --> " + (hilo1.getRepetidos() + hilo2.getRepetidos()));
        Tiempo = TFin - Tinicio;
        System.out.println("Tiempo del proceso -->" + Tiempo + " mlls");


    }

    public static ArrayList readFile(File file) throws IOException {

        ArrayList matriculas = new ArrayList<Integer>();

        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        while ((line = br.readLine()) != null) {

            matriculas.add(Integer.parseInt(line));

        }

        br.close();
        fileReader.close();


        return matriculas;
    }


}

