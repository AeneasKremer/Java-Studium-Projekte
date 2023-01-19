
/**
 * Klasse Artikel mit den Atributen: Artikel Nummer, Artikel Art, Bestand
 *
 * @author Daniel Mayer, Aeneas Kremer
 * @version 09.11.2022
 */
public class Artikel
{
    protected int artikelNr;
    protected String art;
    protected int bestand;
    protected double preis;

    private final static String FALSCHE_ARTIKELNUMMER = "Die Artikelnummer muss 4 stellig sein!";
    private final static String MENGE_UNTER_1 = "Die Menge muss größer als 0 sein!";
    private final static String BESTAND_UNTER_0 = "Der Betand darf nicht unter 0 sein!";
    private final static String PREIS_UNTER_0 = "Der Preis darf nicht unter 0 sein!";

    /** Konstruktoren mit unterschiedlichen Atributen Zuweisungen
     *  @param artikelNr Artikel Nummer
     *  @param bestand Bestand
     *  @param art Artikel Art
     *  @param preis Preis
     */

    public Artikel(int artikelNr, String art, int bestand, double preis) {
        if (bestand < 1) {
            throw new IllegalArgumentException(BESTAND_UNTER_0);
        } else if (String.valueOf(artikelNr).length() == 4) {
            this.artikelNr = artikelNr;
            this.bestand = bestand;
            this.art = art;
            this.preis = preis;
        } else {
            throw new IllegalArgumentException(FALSCHE_ARTIKELNUMMER);
        }
    }

    public Artikel(int artikelNr, String art, double preis) {
        this(artikelNr, art, 0, preis);
    }

    /** bucht einen Zugang zum Betrag
     *  @param menge Menge, wird zum Betrag zugebucht
     */


    public void bucheZugang(int menge) {
        if (menge <= 0) {
            throw new IllegalArgumentException(MENGE_UNTER_1);
        } else {
            this.bestand = bestand + menge;
        }
    }

    /** bucht einen Abgang zum Betrag
     *  @param menge Menge, wird zum Betrag abgebucht
     */

    public void bucheAbgang(int menge) {
        if (menge <= 0) {
            throw new IllegalArgumentException(MENGE_UNTER_1);
        } else if (bestand - menge < 0) {
            throw new IllegalArgumentException(BESTAND_UNTER_0);
        } else {
            this.bestand = bestand - menge;
        }
    }

    // gibt eine Ausgabe von allen Atributen in Text

    public String toString() {
        String ausgabe = "Artikel Nummer: " + artikelNr + " / Artikel Art: " +
                         art + " / Bestand: " + bestand + " / Preis: " + preis;
        return ausgabe;
    }

    // get Methoden fuer alle Atribute

    public int getArtikelNr() {
        return artikelNr;
    }

    public int getBestand() {
        return bestand;
    }

    public String getArt() {
        return art;
    }
    
    public double getPreis() {
        return preis;
    }

    /** set Methode fuer den Bestand
     *  @param menge Menge, wird dem Bestand zugewiesen
     */

    public void setBestand(int menge) {
        if (menge < 0) {
            throw new IllegalArgumentException(BESTAND_UNTER_0);
        } else {
            this.bestand = menge;
        }
    }
    
    /** set Methode fuer den Preis
     * @param neuerPreis der neue Preis der zugewiesen wird
     */
    
    public void setPreis(double neuerPreis) {
        if (neuerPreis < 0) {
            throw new IllegalArgumentException(PREIS_UNTER_0);
        }
        this.preis = neuerPreis;
    }
    
    public String getBeschreibung() {
        String ausgabe = art;
        return ausgabe;
    }
}
