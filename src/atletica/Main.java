/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alit2967
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int scelta = 0;
        Scanner input = new Scanner(System.in);
        Atleta atleta = new Atleta();

        do {

            System.out.println("Fai la tua scelta " +
                    "\n 1 --- crea nuovo atleta" +
                    "\n 2 -- crea nuova gara" +
                    "\n 3 --- salva risultati correnti" +
                    "\n 4 --- importa risultati" +
                    "\n 5 --- leggi tutti gli atleti" +
                    "\n 6 -- salva gli atleti di questa sessione" +
                    "\n 5 -- esci");

            // scelta = input.nextInt();

            scelta = input.nextInt();

            switch (scelta) {
                case 1: {
                    String nominativo;
                    String sesso;
                    String categoria;
                    atleta.readAtleti();

                    System.out.println("Scrivi il nome dell'atleta");

                    nominativo = input.next();

                    System.out.println("Scrivi il sesso dell'atleta");

                    sesso = input.next();

                    System.out.println("Scrivi lo sport dell'atleta");

                    categoria = input.next();

                    atleta = new Atleta(nominativo, sesso, categoria);

                    atleta.saveAtleti(atleta);

                }
                    break;

                case 2: {

                }
                    break;
                case 3: {

                }
                    break;
                case 4: {

                }
                    break;
                case 5: {
                    atleta.readAtleti();
                }
                    break;
                case 6: {
                    atleta.saveAtleti(true);
                }
                    break;

            }

        } while (scelta != 0);

        input.close();

    }

}
