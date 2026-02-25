/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalTime;
/**
 *
 * @author alit2967
 */
import java.io.*;

public class Gara implements Serializable {

    private String nomeGara;
    private String posizione;
    private String dettagli;
    private LocalTime tempo;
    private Gara[] gare = new Gara[100];

    // input e output

    int dimensione = 0;

    // FileOutputStream f = new FileOutputStream("gara.dat", true);
    // ObjectOutputStream fOut = new ObjectOutputStream(f);

    public Gara() {

    }

    public Gara(String nomeGara, String dettagli, LocalTime tempo) {

        Atleta[] partecipanti;
        this.nomeGara = nomeGara;
        this.dettagli = dettagli;
        this.tempo = tempo;

    }

    public void saveGara(Gara gara) throws FileNotFoundException, IOException {
        gare[dimensione] = gara;
        dimensione++;

        FileOutputStream f = new FileOutputStream("gara.dat", true);
        ObjectOutputStream fOut = new ObjectOutputStream(f);

        fOut.writeObject(gara);

        f.close();
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

    public LocalTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalTime tempo) {
        this.tempo = tempo;
    }

}
