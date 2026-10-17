package text;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CopyText {

    private static final String IN_TXT = "cas01/src/text/in.txt";
    private static final String OUT_TXT = "cas01/src/text/out.txt";
    private static final int BUFF_SIZE = 512;

    public static void main(String[] args) {

        /*
         * 1. U ovom zadatku se radi sa tekstom tj. potrebno je prepisati tekstualni sadrzaj jednog fajla u drugi.
         * 2. Zbog toga potrebno je koristiti neke klase koje omogucavaju PREVODJENJE tih procitanih bajtova u tekst.
         * 3. FileInputStream - uzima sirove bajtove iz fajla.
         * 4. InputStreamReader - sluzi kao prevodilac koji te sirove bajtove pretvara u citljive karaktere/slova
         *    koristeci UTF-8 standard.
         * 5. BufferedReader - uzima ta prevedena slova i pakuje ih u bafer radi brzeg rada i lakseg citanja.
         */
        try (BufferedReader bfin = new BufferedReader(new InputStreamReader(new FileInputStream(IN_TXT), StandardCharsets.UTF_8));
             BufferedWriter bfout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUT_TXT), StandardCharsets.UTF_8));
            ) {
            char[] buf = new char[BUFF_SIZE];
            int bytesRead = 0;
            while ((bytesRead = bfin.read(buf)) != -1) {
                bfout.write(buf, 0, bytesRead);
            }
            /* naredni deo koda ne ispisuje nista na stdout jer je u prethodnoj petlji
               sav sadrzaj ulaznog fajla vec procitan i pokazivac je stigao do EOF-a */
            String linija1;
            while ((linija1 = bfin.readLine()) != null) {
                System.out.println(linija1);
            }
            /* ako zelimo da procitan sadrzaj ulaznog fajla istovremeno bude ispisan na stdout
               i da bude prepisan u out.txt koristimo naredni deo koda */
            String linija2;
            while ((linija2 = bfin.readLine()) != null) {
                System.out.println(linija2);
                bfout.write(linija2);
                bfout.newLine(); // treba nam posto readLine() skida '\n'
            }
        } catch (FileNotFoundException e) {
            System.err.println("Greska pri otvaranju fajlova!");
        } catch (IOException e) {
            System.err.println("Greska pri Input/Output operacijama.");
        }
    }
}
