
/**
 * Beschreiben Sie hier die Klasse CD.
 * 
 * @author Aeneas Kremer, Daniel Mayer 
 * @version 16.02.2023
 */
public class Cd extends Artikel
{
    private String interpret;
    private String titel;
    private int anzahlTitel;
    
    //Fehlerbehandlungen
    private static final String INTERPRET_IST_LEER = "Bitte geben Sie einen Interpreten an!";
    private static final String TITEL_IST_LEER = "Bitte geben Sie einen Titel ein!";
    private static final String ANZAHL_IST_NULL = "Bitte geben Sie eine Anzahl die größer als Null ist!";
    
    /**
     * Konstruktor der eine CD erstellt
     * 
     * @param artikelNr Artikel Nummer
     * @param bestand Bestand
     * @param preis Preis
     * @param interpret Interpret
     * @param titel Titel
     * @param anzahlTitel anzahl der Titel
     */
    
    public Cd (int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, "Medien", bestand, preis);
        if (String.valueOf(interpret).length() != 0) {
            this.interpret = interpret;
        } else {
            throw new IllegalArgumentException(INTERPRET_IST_LEER);
        }
        if (String.valueOf(titel).length() != 0) {
            this.titel = titel;
        } else {
            throw new IllegalArgumentException(TITEL_IST_LEER);
        }
        if (anzahlTitel > 0) {
            this.anzahlTitel = anzahlTitel;
        } else {
            throw new IllegalArgumentException(ANZAHL_IST_NULL);
        }
    }
    
    /**
     * Eine equals Methode um Objekte der Klasse Cd besser zu vergleichen als mit
     * der normalen equals Methode
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
        Cd other = (Cd) obj;
        if (titel == null) {
            if (titel != null) {
                return false;
            }
        } else if (!titel.equals(other.titel)) {
            return false;
        }
        
        
        if (interpret == null) {
            if (interpret != null) {
                return false;
            }
        } else if (!interpret.equals(other.interpret)) {
            return false;
        }
    
        return true;
    }
    
    /**
     * Gibt die Beschreibung zurück die spaeter in der Ausgabe der Bestands Liste
     * gebraucht wird
     */
    
    public String getBeschreibung() {
        String ausgabe = (interpret + ": " + titel);
        return ausgabe;
    }
    
    /**
     * Eine Ausgabe einer CD
     */
    
    public String toString() {
        String ausgabe = "Artikel Nummer: " + artikelNr + " / Artikel Art: CD" + 
                         "/ Bestand: " + bestand + " / Preis: " + preis + 
                         "/ Interpret: " +  interpret + "/ Titel: " + titel + 
                         "/ Anzahl Titel: " + anzahlTitel;
        return ausgabe;
    }
}
