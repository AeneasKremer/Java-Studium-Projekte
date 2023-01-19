import java.util.Scanner;
import java.lang.Math;
/**
 * Klasse mit einfachen mathematischen Funktionen
 *
 * @author Aeneas Kremer, Daniel Mayer
 * @version 28.11.2022
 */
public class MathFunctions
{
    /**
     * Erstellt einen privaten Konstruktor damit kein Objekt von außen erstellt 
     * werden kann
     */
    
     private MathFunctions(){

     }
    
    /**
    * Berechnen der Teilersumme
    * 
    * @param zahl Zahl aus der die Teilersumme berechnet wird
    */
    public static long berechneTeilersumme(long zahl) {
       int zaehler = 1;
       int summe = 0;
       if (zahl > 0) {
           while (zaehler <= zahl) {
               if (zahl%zaehler == 0) {
                   summe += zaehler;
               }
               zaehler++;
           }
       } else {
           throw new IllegalArgumentException("Die Zahl muss eine natürliche " + 
                                              "Zahl sein");
       }
       return summe;
    }

    /**
     * Berechnen der Checksumme
     * 
     * @param isbn Die ISBN 10 die zum pruefen uebergeben wird
     */

    public static String berechneChecksummeIsbn(long isbn) {
      if (isbn >= 100000000 && isbn <= 999999999) {
        String isbnString = Long.toString(isbn);
        int[] isbnZiffern = new int[isbnString.length()];
        int checksumme = 0;

        for (int i = 0; i < isbnString.length(); i++) {
          isbnZiffern[i] = isbnString.charAt(i) - '0';
        }

        for (int i = 0; i < isbnString.length(); i++) {
            checksumme += isbnZiffern[i]*(i+1);
        }

        int pruefzifferZwischenSpeicher = checksumme%11;
        String pruefziffer = "";

        if (pruefzifferZwischenSpeicher == 10) {
            pruefziffer = "X";
        } else {
            pruefziffer = Integer.toString(pruefzifferZwischenSpeicher);
        }

        return pruefziffer;
      } else {
          throw new IllegalArgumentException("ISBN flasch angegeben!");
      }
    }

    /**
     * berechnen der Nullstellen
     * 
     * @param p Das p zum einsetzen in der Formel
     * @param q Das q zum einsetzen in der Formel
     */

    public static String berechneNullstellen(double p, double q) {
      double negativFastNull = -0.000001;
      double positivFastNull = 0.000001;
      double diskriminante = (Math.pow((p/2), 2) - q);

      double wurzelDiskriminante = Math.sqrt(diskriminante);
      double minusPHalbe = -(p/2);

      double x1 = minusPHalbe + wurzelDiskriminante;
      double x2 = minusPHalbe - wurzelDiskriminante;

      String ausgabeZweiNullStellen = ("Zwei Nullstellen:  " + x1 + "|" + x2);
      String ausgabeDopNullStelle = ("Doppelte Nullstelle:  " + x1  );
      String ausgabeKompNullStellen = ("Komplexe Nullstellen");

      //kann man als case machen, wäre besser aber es funktioniert dennoch
      if (diskriminante > 0.0) {
        return ausgabeZweiNullStellen;
      } else if (diskriminante <= positivFastNull && diskriminante >= negativFastNull) {
        return ausgabeDopNullStelle;
      } else if (diskriminante < 0.0) {
        return ausgabeKompNullStellen;
      } else {
          throw new IllegalArgumentException("Error");
      }
    }
    
    /**
     * Berechnen, ob die Zahl eine Summe aus Potenzen sein kann
     * 
     * @param zahl Die Zahl zum pruefen der Summe von Potenzen
     */

    public static boolean istSummeVonPotenzen(long zahl){
        boolean ergebnis = false;
        long summe = 0;
        if (zahl > 0) {
            double maxA = (Math.pow(zahl, (1.0/4.0)));
            double maxB = (Math.pow(zahl, (1.0/3.0)));
            double maxC = (Math.pow(zahl, (1.0/2.0)));
            
            
            for (int a = 1; a <= maxA; a++) {
                for (int b = 1; b <= maxB; b++) {
                    for (int c = 1; c <= maxC; c++) {
                        summe = ((long)Math.pow(a, 4) + (long)Math.pow(b, 3) + (long)Math.pow(c, 2));
                        if (summe == zahl) {
                            ergebnis = true;
                            break;
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Bitte geben Sie eine natürliche Zahl ein!");
        }
        return ergebnis;
    }
    
    /**
     * Berechnet den groessten Teiler von zwei Zahlen
     * 
     * @param zahl1 Die erste Zahl zum ueberpruefen
     * @param zahl2 Die zweite Zahl zum ueberpruefen
     */
    
    public static int berechneGgt(int zahl1, int zahl2){
        int Ggt = 0;
        if (zahl1 <= 0 || zahl2 <= 0) {
            throw new IllegalArgumentException("Die Zahlen müssen natürliche Zahlen sein!");
        } else {
            if (zahl1 > zahl2) {
                int zwischenZahl2 = zahl2;
                zahl2 = zahl1;
                zahl1 = zwischenZahl2;
            }
            int teiler = 1;
            while (teiler < zahl1) {
                if (zahl1 % teiler == 0 && zahl2 % teiler == 0) {
                    Ggt = teiler;
                }
                teiler++;
            } 
        }
        return Ggt;
    }
    
    /**
     * Berechnet die Fakultaet einer angegebener zahl
     * 
     * @param zahl Zahl von der die Fakultaet berechnet wird
     */

    public static long berechneFakultaet(int zahl){
      long fakultaet = 1;
      if (zahl <= 0) {
          throw new IllegalArgumentException("Die Zahl muss eine natürliche Zahl sein!");
      } else {
          for (int faktor = 1; faktor<=(zahl);faktor++) {
              fakultaet = fakultaet * faktor;
          }
      }
      return fakultaet;
    }
    
    /**
     * Berechnet die Reihensumme von einer Zahl mit anzahl
     * 
     * @param anzahl Die Anzahl der dauer der Schleife
     * @param x Die Zahl die eingesetzt wird
     */
    
    public static double berechneReihensumme(int anzahl, double x){
    double reihensumme = 0;
    if (anzahl % 1 == 0 && anzahl > 0) {
        try {
            for (double i = 1.0; i<=anzahl; i++) {
                reihensumme += ((Math.pow((x-1), i))/(i*(Math.pow(x, i))));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error");
        }
    } else {
        throw new IllegalArgumentException("Geben Sie eine ganze Zahl für " + 
                                           "die Anzahl ein!");
    }
    
    return reihensumme;
    }
}