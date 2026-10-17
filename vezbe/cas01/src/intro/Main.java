package intro;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        OutputStream out;

        try (FileOutputStream fout = new FileOutputStream("cas01/src/intro/file.txt");
             BufferedOutputStream bfout = new BufferedOutputStream(fout);
            ) {
            bfout.write(100);
            bfout.write(new byte[] {97, 98, 99}, 0, 3);
        } catch (FileNotFoundException e) {
            System.err.println("Fajl ne moze da se otvori!");
        } catch (IOException e) {
            System.err.println("Greska pri Input/Output operacijama.");
        }

        InputStream in;

        try (FileInputStream fin = new FileInputStream("cas01/src/intro/file.txt");
             BufferedInputStream bfin = new BufferedInputStream(fin);
            ) {
            int b = bfin.read();
            System.out.println(b);
            byte[] read = new byte[2];
            int bb = bfin.read(read);
            for (int i = 0; i < bb; i++) {
                System.out.println(read[i]);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fajl ne moze da se otvori!");
        } catch (IOException e) {
            System.err.println("Greska pri Input/Output operacijama.");
        }

        Writer w;

        try (FileWriter fout = new FileWriter("cas01/src/intro/file-rw.txt");
             BufferedWriter bfout = new BufferedWriter(fout);
            ) {
            bfout.write('d');
            bfout.write(new char[] {'l', 'u', 'k', 'a', 'a', 'b', 'c'}, 0, 7);
        } catch (RuntimeException e) {
            System.err.println("Fajl ne moze da se otvori!");
        } catch (IOException e) {
            System.err.println("Greska pri Input/Output operacijama.");
        }

        Reader r;

        try (FileReader fin = new FileReader("cas01/src/intro/file-rw.txt");
             BufferedReader bfin = new BufferedReader(fin);
            ) {
            // System.out.println(bfin.readLine());
            char[] buf = new char[8];
            int len = bfin.read(buf);
            System.out.println(len);
            System.out.println("Sadrzaj bafera ispisan println-om: ");
            System.out.println(buf);
            System.out.println("Sadrzaj badera ispisan petljom: ");
            for (int i = 0; i < len; i++) {
                System.out.print(buf[i]);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fajl ne moze da se otvori!");
        } catch (IOException e) {
            System.err.println("Greska pri Input/Output operacijama.");
        }
    }
}
