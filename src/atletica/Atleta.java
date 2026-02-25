import java.io.*;
import java.util.Arrays;

public class Atleta implements Serializable {

    private String nominativo;
    private String sesso;
    private String categoria;
    private Atleta[] atleti = new Atleta[100];
    private int dimensione = 0;

    public Atleta(String nominativo, String sesso, String categoria) {
        this.nominativo = nominativo;
        this.sesso = sesso;
        this.categoria = categoria;
    }

    public Atleta() {
    }

    public void saveAtleti(Atleta atleta) {
        atleti[dimensione] = atleta;
        dimensione++;

    }

    public void saveAtleti(Boolean bool) throws FileNotFoundException, IOException {
        if (bool == true) {

            FileOutputStream f = new FileOutputStream("atleti.dat", true);
            ObjectOutputStream fOut = new ObjectOutputStream(f);

            for (int i = 0; i < dimensione; i++) {
                fOut.writeObject(atleti[i]);
            }
            fOut.flush();
            fOut.close();
        }
    }

    public void readAtleti()
            throws EOFException, FileNotFoundException, IOException, ClassNotFoundException, StreamCorruptedException {

        try {
            FileInputStream f = new FileInputStream("atleti.dat");
            ObjectInputStream fIn = new ObjectInputStream(f);

            do {
                atleti[dimensione] = (Atleta) fIn.readObject();
                System.out.println(atleti[dimensione]);
                dimensione++;

            } while (fIn.readObject() != null);

            fIn.close();
        } catch (EOFException e) {
            System.err.println(e);
        } catch (StreamCorruptedException e) {
            System.err.println(e);
        }

        /*
         * try {
         * do {
         * 
         * atleti[dimensione] = (Atleta) fIn.readObject();
         * System.out.println(atleti[dimensione]);
         * dimensione++;
         * 
         * } while (fIn.readObject() != null);
         * } catch (EOFException e) {
         * 
         * }
         */

    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Atleta [nominativo=" + nominativo + ", sesso=" + sesso + ", categoria=" + categoria + "]";
    }

}
