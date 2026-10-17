package image;

import java.io.*;

public class CopyImage {

    private static final String IN_IMG = "cas01/src/image/in.PNG";
    private static final String OUT_PNG = "cas01/src/image/out.PNG";
    private static final int BUFF_SIZE = 512;

    public static void main(String[] args) {

        /*
         * 1. U ovom zadatku se radi sa binarnim fajlom (slikom) tj. potrebno je prepisati binarni sadrzaj (sliku) jednog fajla u drugi.
         * 2. Slike, muzika, video-zapisi i izvrsni fajlovi nisu napravljeni od slova i reci, vec od cistih nizova bajtova (sirovih
         *    podataka od 0 do 255). Njih ne zanima nikakvo slovo niti enkodiranje - za njih je sve samo obican niz nula i jedinica
         *    (bajtova) koji se preslikava 1 na 1.
         * 3. FileInputStream - uzima sirove bajtove iz fajla.
         * 4. BufferedInputStream - uzima procitane bajtove i pakuje ih u bafer radi brzeg rada.
         */
        try (BufferedInputStream bfin = new BufferedInputStream(new FileInputStream(IN_IMG));
             BufferedOutputStream bfout = new BufferedOutputStream(new FileOutputStream(OUT_PNG));
        ) {
            byte[] buf = new byte[BUFF_SIZE];
            int bytesRead = 0;
            while ((bytesRead = bfin.read(buf)) != -1) {
                bfout.write(buf, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Greska pri otvaranju fajlova!");
        } catch (IOException e) {
            System.err.println("Greska pri Input/Output operacijama.");
        }
    }
}
