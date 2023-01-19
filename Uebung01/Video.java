
/**
 * Beschreiben Sie hier die Klasse CD.
 * 
 * @author Aeneas Kremer, Daniel Mayer 
 * @version 16.02.2023
 */
public class Video extends Artikel
{
    private String titel;
    private int spieldauer;
    private int jahr;
    
    //Fehlerbehandlungen
    private static final String TITEL_IST_LEER = "Bitte geben Sie einen Titel an!";
    private static final String SPIELDAUER_IST_NULL = "Bitte geben Sie ein Anzahl an die größer als Null ist!";
    private static final String JAHR_FALSCH = "Bitte geben Sie ein Jahr zwischen 1900 und 2022 an!";
    
    /**
     * Ein Konstruktor der ein Video erstellt
     * 
     * @param artikelNr Artikel Nummer
     * @param bestand Bestand
     * @param preis Preis
     * @param titel Titel
     * @param spieldauer Spieldauer
     * @param jahr Erscheinungsjahr
     */
    
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, "Medien", bestand, preis);
        
        if (String.valueOf(titel).length() != 0) {
            this.titel = titel;
        } else {
            throw new IllegalArgumentException(TITEL_IST_LEER);
        }
        if (spieldauer > 0) {
            this.spieldauer = spieldauer;
        } else {
            throw new IllegalArgumentException(SPIELDAUER_IST_NULL);
        }
        if (jahr >= 1900 && jahr <= 2022) {
            this.jahr = jahr;
        } else {
            throw new IllegalArgumentException(JAHR_FALSCH);
        }
    }
    
    /**
     * Eine equals Methode um Objekte der Klasse Video besser zu vergleichen als 
     * mit der normalen equals Methode
     * 
     * @param obj das Objekt das verglichen wird
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Video other = (Video) obj;
        if (titel == null) {
            if (titel != null) {
                return false;
            }
        } else if (!titel.equals(other.titel)) {
            return false;
        }
        return true;
    }
    
    /**
     * Gibt die Beschreibung zurück die spaeter in der Ausgabe der Bestands Liste
     * gebraucht wird
     */
    
    public String getBeschreibung() {
        String ausgabe = titel;
        return ausgabe;
    }
    
    /**
     * Ausgabe eines Videos
     */
    public String toString() {
        String ausgabe = "Artikel Nummer: " + artikelNr + " / Artikel Art: Video" + 
                         " / Bestand: " + bestand + " / Preis: " + preis + 
                         "/ Titel: " +  titel + "/ Spieldauer: " + spieldauer + 
                         "/ Jahr: " + jahr;
        return ausgabe;
    }
}
