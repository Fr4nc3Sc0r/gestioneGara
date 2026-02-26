/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalTime;

/**
 *
 * @author alit2967
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int scelta = 0;
        Scanner input = new Scanner(System.in);
        Atleta atleta = new Atleta();
        Gara gara = new Gara();

        do {

            System.out.println("Fai la tua scelta " +
                    "\n 1 --- crea nuovo atleta" +
                    "\n 2 -- crea nuova gara" +
                    "\n 3 --- leggi tutte le gare" +
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

                    atleta.saveAtleti(new Atleta(nominativo, sesso, categoria));

                }
                    break;

                case 2: {

                    String nomeGara;
                    String posizione;
                    String dettagli;
                    int tempo;
                    int tempPartecipante;
                    Atleta partecipante;

                    System.out.println("Inserisci il nome della gara");

                    nomeGara = input.next();

                    System.out.println("Inserisci i dettagli");

                    dettagli = input.next();

                    System.out.println("Inserisci il tempo del classificato in secondi (secondi.millessimi)");

                    tempo = input.nextInt();

                    System.out.println(
                            "Inserire un partecipante della gara con la sua rispettiva posizione in classifica");

                    atleta.readAtleti();

                    tempPartecipante = input.nextInt();

                    gara.saveGara(new Gara(nomeGara, dettagli, tempo, atleta.getAtletaByIndice(tempPartecipante)));
                    gara.saveGara(true);

                }
                    break;
                case 3: {
                    gara.readGare();
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
