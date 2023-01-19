import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Ausführen der Mathoden aus der Klasse MathFunctions
 *
 * @author Daniel Mayer, Aeneas Kremer
 * @version 24.11.2022
 */
public class MathFunctionsDialog
{
    /**
     * Erstellen der Menü Punkte
     */

    private Scanner input;

    private static final int BERECHNE_TEILERSUMME = 1;
    private static final int BERECHNE_CHECKSUMME_ISBN = 2;
    private static final int BERECHNE_NULLSTELLEN = 3;
    private static final int IST_SUMME_VON_POTENZEN = 4;
    private static final int BERECHNE_GGT = 5;
    private static final int BERECHNE_FAKULTAET = 6;
    private static final int BERECHNE_REIHENSUMME = 7;
    private static final int END = 8;

    public MathFunctionsDialog() {
        input = new Scanner(System.in);
    }

    /**
     * Hauptschleife des Programms
     */

    public void start() {
        int funktion = 0;

        do {
            try {
                menueAusgabe();
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
              System.out.println("Falsch Eingabe!");
              input.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (funktion != END);
    }

    /**
     * Ausgabe des Menues
     */

    private void menueAusgabe() {
        System.out.print(BERECHNE_TEILERSUMME + " - Berechnet die Teilersumme einer Zahl\n" +
                         BERECHNE_CHECKSUMME_ISBN + " - Berechnet die Prüfziffer einer ISBN-10\n" +
                         BERECHNE_NULLSTELLEN + " - Berechnet die Nullstellen von p und q\n" +
                         IST_SUMME_VON_POTENZEN + " - Zeigt an ob die eingegeben Zahl eine " +
                         "Summe von Potenzen ist\n" + 
                         BERECHNE_GGT + " - Berechnet den größten gemeinsamen Teiler\n" +
                         BERECHNE_FAKULTAET + " - Berechnet die Fakultät\n" +
                         BERECHNE_REIHENSUMME + " - Berechnet die Reihensumme\n" +
                         END + " - Beenden des Programms\n");
    }

    /**
     * Einlesen der Eingabe des Benutzers um einen Menüpunkt auszuwählen
     * 
     * @return gibt die auszuführende Funktion mit einer Ganzzahl zurück
     */

    private int einlesenFunktion() {
        int funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Aufrufen der unterschiedlichen Funktionen
     * 
     * @param funktion die Funktion die eingegeben wurde wird aufgerufen
     */

    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case BERECHNE_TEILERSUMME:
                berechneTeilersumme();
                break;
            case BERECHNE_CHECKSUMME_ISBN:
                berechneChecksummeIsbn();
                break;
            case BERECHNE_NULLSTELLEN:
                berechneNullstellen();
                break;
            case IST_SUMME_VON_POTENZEN:
                istSummeVonPotenzen();
                break;
            case BERECHNE_GGT:
                berechneGgt();
                break;
            case BERECHNE_FAKULTAET:
                berechneFakultaet();
                break;
            case BERECHNE_REIHENSUMME:
                berechneReihensumme();
                break;
            case END:
                System.out.println("Programm beendet!");
                break;
            default:
                System.out.println("Falsche Eingabe! Bitte geben sie eine Option als Zahl von 1 bis 8 ein!");
                break;
            }
    }

    /**
     * Die Funktion berechneTeilersumme() wird aus der Klasse Mathfunction 
     * aufgerufen
     */

    private void berechneTeilersumme() {
        System.out.println("Bitte geben Sie eine Zahl ein von der Sie die " +
                            "Teilersumme wissen wollen: ");
        long zahl = input.nextLong();
        long teilersumme = MathFunctions.berechneTeilersumme(zahl);
        System.out.println("Die Teilersumme von der Zahl " + zahl + " ist: " +
                            teilersumme);
    }
    
    /**
     * Die Funktion berechneCecksummeIsbn() wird aus der Klasse Mathfunction 
     * aufgerufen
     */

    private void berechneChecksummeIsbn() {
        System.out.println("Bitte geben Sie eine Isbn-10 von der Sie die " +
                           "Prüfziffer wissen wollen: ");
        long isbn = input.nextLong();
        String pruefziffer = MathFunctions.berechneChecksummeIsbn(isbn);
        System.out.println("Die Prüfziffer ist:" + pruefziffer);
    }
    
    /**
     * Die Funktion berechneNullstellen() wird aus der Klasse Mathfunction 
     * aufgerufen
     */
    
    private void berechneNullstellen() {
        System.out.println("Bitte geben Sie p und q an um die Nullstellen " +
                           "der Funktion zu berechnen");

        System.out.print("p: ");
        double p = input.nextDouble();
        System.out.print("q: ");
        double q = input.nextDouble();
        
        String nullstellen = MathFunctions.berechneNullstellen(p, q);
        System.out.println(nullstellen);
    }
    
    /**
     * Die Funktion istSummeVonPotenzen() wird aus der Klasse Mathfunction 
     * aufgerufen
     */
    
    private void istSummeVonPotenzen() {
        System.out.println("Bitte geben Sie eine Zahl ein:");
        long zahl = input.nextLong();
        boolean istSumme = MathFunctions.istSummeVonPotenzen(zahl);
        if (istSumme == true) {
            System.out.println("Die Zahl ist eine Summe von Potenzen!");
        } else {
            System.out.println("Die Zahl ist keine Summe von Potenzen!");
        }
        }
    
    
    /**
     * Die Funktion berechneGgt() wird aus der Klasse Mathfunction 
     * aufgerufen
     */
    
    private void berechneGgt() {
        System.out.println("Bitte geben Sie die erste Zahl ein: ");
        int zahl1 = input.nextInt();
        System.out.println("Bitte geben Sie die zweite Zahl ein: ");
        int zahl2 = input.nextInt();
        
        int ggt = MathFunctions.berechneGgt(zahl1, zahl2);
        System.out.println("Der größte gemeinsame Teiler ist: " + ggt);
    }
    
    /**
     * Die Funktion berechneFakultaet() wird aus der Klasse Mathfunction 
     * aufgerufen
     */
    
    private void berechneFakultaet() {
        System.out.print("Bitte geben Sie eine Zahl ein: ");
        
        int zahl = input.nextInt();
        
        long fakultaet = MathFunctions.berechneFakultaet(zahl);
        
        System.out.println("Die Fakultät ist: " + fakultaet);
    }
    
    /**
     * Die Funktion berechneReihensumme() wird aus der Klasse Mathfunction 
     * aufgerufen
     */
    
    private void berechneReihensumme() {
        System.out.println("Geben Sie bitte die Anzahl an: ");
        int anzahl = input.nextInt();
        System.out.println("Bitte geben Sie die Zahl für x ein:");
        double x = input.nextDouble();
        
        double reihensumme = MathFunctions.berechneReihensumme(anzahl, x);
        
        System.out.println("Die Reihensumme ist: " + reihensumme);
    }
    
    /**
     * erstellen der main Methode
     */

    public static void main(String[] args) {
        new MathFunctionsDialog().start();
    }
}
