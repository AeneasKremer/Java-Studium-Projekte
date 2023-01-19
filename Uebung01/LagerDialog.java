import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Ein Dialog zu der Klasse Lager
 * 
 * @author Aeneas Kremer, Daniel Mayer 
 * @version 05.12.2022
 */
public class LagerDialog
{
    private Lager lager;
    private Scanner input;
    private Artikel artikel;
    
    /**
     * Erstellen der Menuepunkte
     */
    
    private static final int LAGER_ERSTELLEN = 1;
    private static final int LAGER_ERSTELLEN_MIT_GROESSE = 2;
    private static final int LEGE_AN_ARRTIKEL = 3;
    private static final int ENTFERNE_ARTIKEL = 4;
    private static final int BUCHE_ZUGANG = 5;
    private static final int BUCHE_ABGANG = 6;
    private static final int AENDERE_PREIS_EINES_ARTIKELS = 7;
    private static final int AENDERE_PREIS_ALLER_ARTIKEL = 8;
    private static final int GET_ARTIKEL = 9;
    private static final int STRING_TO_STRING = 10;
    private static final int AUSGEBEN_BESTANDS_LISTE = 11;
    private static final int GET_ARTIKEL_ANZAHL = 12;
    private static final int GET_LAGER_GROESSE = 13;
    private static final int END = 14;
    
    /**
     * Exception behandlung
     */
    
    private static final String LAGER_NONEXISTENT = "Es existiert noch kein Lager!";
    private static final String LAGER_EXISTENT = "Es existiert bereits ein Lager!";
    private static final String FALSCHER_MENUEPUNKT = "Bitte geben Sie einen der oben genannten Menüpunkte (1-4) ein!";
    
    public LagerDialog() {
        input = new Scanner(System.in);
    }
    
    /**
     * Hauptschleife des Dialogs
     */
    
    public void start() {
        lager = null;
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
        System.out.print(LAGER_ERSTELLEN + " - Anlegen eines Lagers mit der Standardgröße 10\n" +
                         LAGER_ERSTELLEN_MIT_GROESSE + " - Anlegen eines Lagers mit einer angegebenen Größe\n" +
                         LEGE_AN_ARRTIKEL + " - Legt einen Artikel in dem Lager an\n" +
                         ENTFERNE_ARTIKEL + " - Entfernt ein im Lager bestehenden Artikel\n" +
                         BUCHE_ZUGANG + " - Bucht einen Zugang zum Bestand\n" +
                         BUCHE_ABGANG + " - Bucht einen Abgang zum Bestand\n" +
                         AENDERE_PREIS_EINES_ARTIKELS + " - Ändert den Preis eines im Lager gespeicherten Artikels\n" +
                         AENDERE_PREIS_ALLER_ARTIKEL + " - Ändert die Preise aller im Lager gespeicherten Artikel\n" +
                         GET_ARTIKEL + " - Findet einen Artikel im Lager durch den Index\n" + 
                         STRING_TO_STRING + " - Zeigt Ihnen das Lager\n" + 
                         AUSGEBEN_BESTANDS_LISTE + " - Zeigt den Lagerbestand an\n" +
                         GET_ARTIKEL_ANZAHL + " - Zeigt Ihnen die Anzahl der im Lager gespeicherten Artikel\n" + 
                         GET_LAGER_GROESSE + " - Zeigt Ihnen die Größe des Lagers\n" +
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
     * 
     * @param funktion die Funktion die eingegeben wurde wird aufgerufen
     */

    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case LAGER_ERSTELLEN:
                lagerErstellen();
                break;
            case LAGER_ERSTELLEN_MIT_GROESSE:
                lagerErstellenMitGroesse();
                break;
            case LEGE_AN_ARRTIKEL:
                legeAnArtikel();
                break;
            case ENTFERNE_ARTIKEL:
                etnferneArtikel();
                break;
            case BUCHE_ZUGANG:
                bucheZugang();
                break;
            case BUCHE_ABGANG:
                bucheAbgang();
                break;
            case AENDERE_PREIS_EINES_ARTIKELS:
                aenderePreisEinesArtikels();
                break;
            case AENDERE_PREIS_ALLER_ARTIKEL:
                aenderePreisAllerArtikel();
                break;
            case GET_ARTIKEL:
                getartikel();
                break;
            case STRING_TO_STRING:
                stringToString();
                break;
            case AUSGEBEN_BESTANDS_LISTE:
                ausgebenBestandsListe();
                break;
            case GET_ARTIKEL_ANZAHL:
                getartikelAnzahl();
                break;
            case GET_LAGER_GROESSE:
                getlagerGroesse();
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
     * Erstellt ein Lager mit der Groesse von 10
     */
    
    private void lagerErstellen() {
        if (lager != null) {
            throw new IllegalArgumentException(LAGER_EXISTENT);
        } else {
            lager = new Lager();
            System.out.println("Ein Lager wurde erstellt!");
        }
    }
    
    private void lagerErstellenMitGroesse() {
        if (lager != null) {
            throw new IllegalArgumentException(LAGER_EXISTENT);
        } else {
            System.out.println("Wie groß soll das Lager sein?");
            int groesse = input.nextInt();
            lager = new Lager(groesse);
        }
    }
    
    /**
     * Anlegen eines Artikels mit der Wahl der Artikel Art
     */
    private void legeAnArtikel() {
        if (lager == null) {
            throw new IllegalArgumentException(LAGER_NONEXISTENT);
        } else {
            System.out.println("Artikel Nummer: ");
            int tempArtikelNr = input.nextInt();
            if (tempArtikelNr >= 1000 && tempArtikelNr <= 9999) {
                int artikelNr = tempArtikelNr;
                System.out.println("Bestand: ");
                int bestand = input.nextInt();
                System.out.println("Preis: ");
                double preis = input.nextDouble();
                
                System.out.println("Welche Art Artikel wollen Sie erstellen?");
                System.out.println("1. Artikel");
                System.out.println("2. Video");
                System.out.println("3. CD");
                System.out.println("4. Buch");
                
                int eingabe = input.nextInt();
                
                if (eingabe > 4 || eingabe < 1) {
                    throw new IllegalArgumentException(FALSCHER_MENUEPUNKT);
                } else {
                    switch(eingabe) {
                        case 1:
                            System.out.println("Artikel Art: ");
                            String art = input.next();
                            
                            artikel = new Artikel(artikelNr, art, bestand, preis);
                            
                            lager.legeAnArtikel(artikel);
                            break;
                        case 2:
                            System.out.println("Titel: ");
                            String titel = input.next();
                            System.out.println("Spieldauer: ");
                            int spieldauer = input.nextInt();
                            System.out.println("Jahr: ");
                            int jahr = input.nextInt();
                            
                            Video video = new Video(artikelNr, bestand, preis, titel, spieldauer, jahr);
                            
                            lager.legeAnVideo(video);
                            break;
                        case 3:
                            System.out.println("Interpret: ");
                            String interpret = input.next();
                            System.out.println("Titel: ");
                            titel = input.next();
                            System.out.println("Anzahl Titel: ");
                            int anzahlTitel = input.nextInt();
                            
                            Cd cd = new Cd(artikelNr, bestand, preis, interpret, titel, anzahlTitel);
                            
                            lager.legeAnCd(cd);
                            break;
                        case 4:
                            System.out.println("Titel: ");
                            titel = input.next();
                            System.out.println("Autor: ");
                            String autor = input.next();
                            System.out.println("Verlag: ");
                            String verlag = input.next();
                            
                            Buch buch = new Buch(artikelNr, bestand, preis, titel, autor, verlag);
                            
                            lager.legeAnBuch(buch); 
                            break;
                    }
                }
                
                
            } else {
                System.out.println("Die Artikel Nummer muss vierstellig sein!");
            }
        }
    }
    
    private void etnferneArtikel() {
        if (lager == null) {
            throw new IllegalArgumentException(LAGER_NONEXISTENT);
        } else {
            System.out.println("Welchen Artikel wollen Sie löschen (Artikel Nummer)?");
            int artikelNr = input.nextInt();
            lager.entferneArtikel(artikelNr);
        }
    }
    
    private void bucheZugang() {
        if (lager == null) {
            throw new IllegalArgumentException(LAGER_NONEXISTENT);
        } else {
            System.out.println("Welchen Artikel wollen Sie löschen (Artikel Nummer)?");
            int artikelNr = input.nextInt();
            System.out.println("Wie hoch soll der Zugang sein?");
            int zugang = input.nextInt();
            
            lager.bucheZugang(artikelNr, zugang);
        }
    }
    
    private void bucheAbgang() {
        if (lager == null) {
            throw new IllegalArgumentException(LAGER_NONEXISTENT);
        } else {
            System.out.println("Bei welchen Artikel soll der Preis geändert werden (Artikel Nummer)?");
            int artikelNr = input.nextInt();
            System.out.println("Wie hoch soll der Abgang sein?");
            int abgang = input.nextInt();
            
            lager.bucheAbgang(artikelNr, abgang);
        }
    }
    
    private void aenderePreisEinesArtikels() {
        if (lager == null) {
            throw new IllegalArgumentException(LAGER_NONEXISTENT);
        } else {
            System.out.println("Bei welchen Artikel soll der Preis geändert werden (Artikel Nummer)?");
            int artikelNr = input.nextInt();
            System.out.println("Um wie viel Prozent soll der Preis geändert werden?");
            double prozent = input.nextDouble();
            
            lager.aenderePreisEinesArtikels(artikelNr, prozent);
        }
    }
    
    private void aenderePreisAllerArtikel() {
        System.out.println("Um wie viel Prozent sollen alle Preise verändert werden?");
        double prozent = input.nextDouble();
        lager.aenderePreisAllerArtikel(prozent);
    }
    
    private void getartikel() {
        if (lager == null) {
            throw new IllegalArgumentException(LAGER_NONEXISTENT);
        } else {
            System.out.println("Wie ist der Index des erwünschten Artikels?");
            int index = input.nextInt();
            
            Artikel artikel = lager.getArtikel(index);
            System.out.println(artikel);
        }
    }
    
    private void stringToString() {
        String ausgabe = lager.toString();
        System.out.println(ausgabe);
    }
    
    private void ausgebenBestandsListe() {
        String ausgabe = lager.ausgebenBestandsListe();
        System.out.println(ausgabe);
    }
    
    private void getartikelAnzahl() {
        int anzahl = lager.getArtikelAnzahl();
        System.out.println("Die Anzahl der Artikel im Lager ist: " + (anzahl));
    }
    
    private void getlagerGroesse() {
        int groesse = lager.getLagerGroesse();
        System.out.println("Die größe des Lagers ist: " + groesse);
    }
    
    /**
     * Main-Methode zum erzeugen des ArtikelDialogs
     */
    
    public static void main(String[] args) {
        new LagerDialog().start();
    }
}



