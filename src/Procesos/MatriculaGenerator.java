package Procesos;

import java.io.PrintWriter;
import java.util.Scanner;

public class MatriculaGenerator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Numero de matriculas que deseas generar -->");
        int n = input.nextInt();

        try {

            PrintWriter outputStream = new PrintWriter("matricula.txt");

            for (int i = 1; i <= n; i++) {

                int random = (int) (Math.random() * ((99999 - 10000) + 1)) + 10000;

                if (i == n) {

                    outputStream.print(random);

                } else {

                    outputStream.println(random);

                }
            }

            outputStream.close();

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}
