/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalTime;
import java.util.Arrays;
/**
 *
 * @author alit2967
 */
import java.io.*;

public class Gara implements Serializable {

    private String nomeGara;
    private String posizione;
    private String dettagli;
    private float tempo;
    Atleta[] partecipanti = new Atleta[100];
    int dimPartecipanti = 0;
    private Gara[] gare = new Gara[100];

    // input e output

    int dimensione = 0;

    // FileOutputStream f = new FileOutputStream("gara.dat", true);
    // ObjectOutputStream fOut = new ObjectOutputStream(f);

    public Gara() {

    }

    public Gara(String nomeGara, String dettagli, int tempo, Atleta partecipante) {

        this.partecipanti[dimPartecipanti] = partecipante;
        this.nomeGara = nomeGara;
        this.dettagli = dettagli;
        this.tempo = tempo;

    }

    public void saveGara(Gara gara) throws FileNotFoundException, IOException {
        gare[dimensione] = gara;
        dimensione++;
    }

    public void saveGara(boolean bool) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("gare.dat");
        boolean fileExist = file.exists();

        FileOutputStream f = new FileOutputStream("gara.dat", true);
        ObjectOutputStream fOut;

        if (fileExist) {
            readGare();
        }

        fOut = new ObjectOutputStream(f);

        for (int i = 0; i < dimensione; i++) {
            fOut.writeObject(gare[i]);
        }
        fOut.flush();
        fOut.close();
    }

    public void readGare()
            throws EOFException, FileNotFoundException, IOException, ClassNotFoundException, StreamCorruptedException {

        try {
            FileInputStream f = new FileInputStream("gare.dat");
            ObjectInputStream fIn = new ObjectInputStream(f);

            dimensione = 0;

            Object obj;
            while ((obj = fIn.readObject()) != null) {
                gare[dimensione] = (Gara) obj;
                System.out.println(gare[dimensione]);
                dimensione++;
            }
            fIn.close();
        } catch (EOFException e) {
            System.err.println(e);
        } catch (StreamCorruptedException e) {
            System.err.println(e);
        }

    }

    public String getNomeGara() {
        return nomeGara;
    }

    public void setNomeGara(String nomeGara) {
        this.nomeGara = nomeGara;
    }

    public String getDettagli() {
        return dettagli;
    }

    public void setDettagli(String dettagli) {
        this.dettagli = dettagli;
    }

    @Override
    public String toString() {
        return "Gara [nomeGara=" + nomeGara + ", posizione=" + posizione + ", dettagli=" + dettagli + ", tempo=" + tempo
                + ", partecipanti=" + Arrays.toString(partecipanti) + "]";
    }

}
