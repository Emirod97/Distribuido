package Procesos;

import java.util.ArrayList;

public class Proceso extends Thread {

    private int Par = 0, Impar = 0, Repetidos = 0, Contador = 0;

    private ArrayList<Integer> Hilo;

    @Override
    public void run() {
        calcularValores(getHilo());
    }

    public ArrayList<Integer> getHilo() {
        return Hilo;
    }

    public void setHilo(ArrayList<Integer> hilo) {
        Hilo = hilo;
    }

    public Proceso() {
    }

    public int getPar() {
        return Par;
    }

    public void setPar(int par) {
        Par = Par + par;
    }

    public int getImpar() {
        return Impar;
    }

    public void setImpar(int impar) {
        Impar = Impar + impar;
    }

    public int getRepetidos() {
        return Repetidos;
    }

    public void setRepetidos(int repetidos) {
        Repetidos = Repetidos + repetidos;
    }

    public int getContador() {
        return Contador;
    }

    public void setContador(int contador) {
        Contador = Contador + contador;
    }

    public void calcularValores(ArrayList<Integer> lista) {

        int even = 1, odd = 1, count = 1, test = 0, rep = 1;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i) % 2 == 0) {
                setPar(even);
            } else {
                setImpar(odd);
            }

            //Collections.sort(lista);

            test = 0;
            for (int j = 0; j < lista.size(); j++) {

                int uno = lista.get(i);
                int dos = lista.get(j);
                if (uno == dos) {
                    test++;
                    if (test == 2) {
                        //System.out.println(uno);
                        setRepetidos(rep);
                        break;
                    }
                }

            }

            setContador(count);

        }


    }

}
