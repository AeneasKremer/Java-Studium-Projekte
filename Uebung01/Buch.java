
/**
 * Beschreiben Sie hier die Klasse CD.
 * 
 * @author Aeneas Kremer, Daniel Mayer 
 * @version 16.02.2023
 */
public class Buch extends Artikel
{
    private String titel;
    private String autor;
    private String verlag;
    
    //Fehlerbehandlungen
    private static final String TITEL_IST_LEER = "Bitte geben Sie einen Titel an!";
    private static final String AUTOR_IST_LEER = "Bitte geben Sie einen Autor an!";
    private static final String VERLAG_IST_LEER = "Bitte geben Sie einen Verlag an!";
    
    /**
     * Ein Konstruktor der ein Buch erzeugt
     */
    
    public Buch(int artikelNr, int bestand, double preis, String titel, String autor, String verlag) {
        super(artikelNr, "Medien", bestand, preis);
        
        this.titel = titel;
        this.autor = autor;
        this.verlag = verlag;
    }
    
    /**
     * Eine equals Methode um Objekte der Klasse Buch besser zu vergleichen als 
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
        Buch other = (Buch) obj;
        if (autor == null) {
            if (autor != null) {
                return false;
            }
        } else if (!autor.equals(other.autor)) {
            return false;
        }
        
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
        String ausgabe = (autor + ": " + titel);
        return ausgabe;
    }
    
    /**
     * Ausgabe eines Buches
     */
    
    public String toString() {
        String ausgabe = "Artikel Nummer: " + artikelNr + " / Artikel Art: Buch" + 
                         " / Bestand: " + bestand + " / Preis: " + preis + 
                         "/ Titel: " +  titel + "/ Autor: " + autor + 
                         "/ Verlag: " + verlag;
        return ausgabe;
    }
}
