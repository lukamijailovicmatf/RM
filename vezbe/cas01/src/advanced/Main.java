package advanced;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        /* Kod obicnih OutputStream-ova mogli smo da radimo samo sa bajtovima ili nizovima bajtova.
        *  PrintStream nam donosi mnoge pogodnosti - omogucava nam da direktno upisujemo tekst, cele brojeve (int),
        *  decimalne brojeve (double), pa cak i logicke vrednosti (boolean) preko dobro poznate metode println().
        *  Ta metoda automatski pretvara te tipove u tekstualni zapis i ispisuje ih u fajl.
        *  Drugi argument u PrintStream(..., true) aktivira takozvani auto-flash. To znaci da se bafer automatski prazni
        *  i upisuje u fajl cim se pozove metoda println(), bez cekanja da se program zavrsi.
        */
        try (PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("cas01/src/advanced/file.txt")), true)) {
            ps.println("Hello world!");
            ps.println(250);
            ps.println(true);
            ps.println("Great! ");
            ps.println(3.2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* Scanner moze da uzima/cita podatke sa razlicitih mesta. Moze da cita ono sto korisnik kuca preko tastature
        *  (new Scanner(System.in)), ali moze da cita i iz fajlova (new FileInputStream(...)). Scanner podrazumevano
        *  koristi razmake, tabulatore i nove redove kao granicu. Svaki komad oivicen tim znakovima naziva se token.
        *  Najznacajnije metode koje se nalaze u klasi Scanner:
        *  1. sc.next() - cita sledecu rec (token)
        *  2. sc.nextLine() - cita ceo preostali red teksta
        *  3. sc.nextInt() - cita tekst i automatski ga pretvara i celi broj
        *  4. sc.nextDouble() - cita tekst i automatski ga pretvara u decimalni broj
        *  5. sc.hasNext() / sc.hasNextLine() - proverava da li u izvornom fajlu ima jos podataka za citanje (sprecava
        *     pucanje pograma kada stigne do kraja fajla) */
        try (Scanner sc = new Scanner(new FileInputStream("cas01/src/advanced/file.txt"))) {
            System.out.println("Po tokenima:");
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
            /* Ovaj slucaj nece ispisati resenje jer se pre toga vec procita sadrzaj fajla u sklopu prve
             * while petlje i pokazivac dodje do EOF-a i onda druga petlja nema sta da cita vise, medjutim
             * ako se kod prve petlje zakomentarise onda druga petlja cita i ispisuje rezultat.
             */
            System.out.println("Po linijama:");
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
