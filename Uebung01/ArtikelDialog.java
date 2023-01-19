import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Diese Klasse testet die Klasse Artikel
 *
 * @author Aeneas Kremer, Daniel Mayer
 * @version 14.11.2022
 */
public class ArtikelDialog
{
    /**
     * Erstellen der Menüpunkte
     */
     
    private Artikel artikel;
    private Scanner input;

    private static final int ANLEGEN_MIT_BESTAND = 1;
    private static final int ANLEGEN_OHNE_BESTAND = 2;
    private static final int BUCHE_ZUGANG = 3;
    private static final int BUCHE_ABGANG = 4;
    private static final int ARTIKEL_AUSGEBEN = 5;
    private static final int SET_BESTAND = 6;
    private static final int END = 7;

    public ArtikelDialog() {
        input = new Scanner(System.in);
    }

    /**
     * Hauptschleife des Dialogs
     */

    public void start() {
        artikel = null;
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
     * Zeigt das Menü mit der Auswahl auf dem Monitor
     */

    private void menueAusgabe() {
        System.out.print(ANLEGEN_MIT_BESTAND + " - Anlegen eines Artikels mit Bestand\n" +
                         ANLEGEN_OHNE_BESTAND + " - Anlegen eines Artikels ohne Bestand\n" +
                         BUCHE_ZUGANG + " - Bestand zubuchen\n" +
                         BUCHE_ABGANG + " - Bestand abbuchen\n" +
                         ARTIKEL_AUSGEBEN + " - Ausgabe der Atribute des Artikels\n" +
                         SET_BESTAND + " - Setzt einen Bestand\n" +
                         END + " - Beenden des Programms\n");
    }
    
    /**
     * Einlesen der Eingabe des Benutzers um einen Menüpunkt auszuwählen
     * @return gibt die auszuführende Funktion mit einer Ganzzahl zurück
     */
    
    private int einlesenFunktion() {
        int funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }
    
    /**
     * Aufrufen der unterschiedlichen Funktionen
     */
    
    private void ausfuehrenFunktion(int funktion) {
        if (funktion == ANLEGEN_MIT_BESTAND) {
            artikelMitBestandAnlegen();
        } else if (funktion == ANLEGEN_OHNE_BESTAND) {
            artikelOhneBestandAnlegen();
        } else if (funktion == BUCHE_ZUGANG) {
            bucheZugang();
        } else if (funktion == BUCHE_ABGANG) {
            bucheAbgang();
        } else if (funktion == ARTIKEL_AUSGEBEN) {
            artikelAusgeben();
        }else if (funktion == SET_BESTAND) {
            setzeBestand();
        } else if (funktion == END) {
            System.out.println("Programm beendet!");
        } else {
            System.out.println("Falsche Eingabe!");
        }
    }
    
    /**
     * legt einen Artikel mit Artikel Nummer, Artikel Art und Bestand an
     */
    
    private void artikelMitBestandAnlegen() {
        if (artikel != null) {
            System.out.println("Der Artikel existiert bereits!");
        } else {
            System.out.println("Artikel Nummer: ");
            int tempArtikelNr = input.nextInt();
            if (tempArtikelNr >= 1000 && tempArtikelNr <= 9999) {
                int artikelNr = tempArtikelNr;
                System.out.println("Artikel Art: ");
                String art = input.next();
                System.out.println("Bestand: ");
                int bestand = input.nextInt();
                System.out.println("Preis: ");
                double preis = input.nextDouble();
                artikel = new Artikel(artikelNr, art, bestand, preis);
            } else {
                System.out.println("Die Artikel Nummer muss vierstellig sein!");
            }
        }
    }
    
    /**
     * legt einen Artikel an mit Artikel Nummer und Artikel Art
     */
    
    private void artikelOhneBestandAnlegen() {
        if (artikel != null) {
            System.out.println("Der Artikel existiert bereits!");
        } else {
            System.out.println("Artikel Nummer: ");
            int artikelNr = input.nextInt();
            input.nextLine();
            System.out.println("Artikel Art: ");
            String art = input.next();
            System.out.println("Preis: ");
            double preis = input.nextDouble();
    
            artikel = new Artikel(artikelNr, art, preis);
        }
    }
    
    /**
     * Bucht einen Zugang
     */
    
    private void bucheZugang() {
        if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel!");
        } else {
            System.out.println("Welcher Betrag soll zugebucht werden?");
            int zugang = input.nextInt();
            artikel.bucheZugang(zugang);
        }
    }
    
    /**
     * bucht einen Abgang
     */
    
    private void bucheAbgang() {
       if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel!");
        } else {
            System.out.println("Welcher Betrag soll abgebucht werden?");
            int abgang = input.nextInt();
            artikel.bucheAbgang(abgang);
        }
    }
    
    /**
     * Gibt die Atribute des Artikels aus
     */
    
    private void artikelAusgeben() {
        if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel!");
        } else {
            System.out.println(artikel.toString());
        }
    }
    
    /**
     * Setzt den Bestand auf einen angegebenen Wert
     */
    
    private void setzeBestand() {
        if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel!");
        } else {
            System.out.println("Was soll der Betrag sein?");
            int betrag = input.nextInt();
            artikel.setBestand(betrag);
        }
    }
    
    /**
     * Main-Methode zum erzeugen des ArtikelDialogs
     */
    
    public static void main(String[] args) {
        new ArtikelDialog().start();
    }
}
