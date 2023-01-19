import java.util.Arrays;
/**
 * Eine Klasse um Arrays auszuwerten
 * 
 * @author Aeneas Kremer, Daniel Mayer
 * @version 08.01.2023
 */
public class ArrayFunctions
{
    //Vererbung von der Klasse Mittelwert
    private Mittelwert mittelwert;
    
    /**
     * Methode um das arithmetische Mittel, den naechst moeglichen Wert am Mittel und
     * den am weitesten entfernten Wert vom arithmetischem Mittel
     * 
     * @param messwerte das Array mit den Werten
     */
    
    public Mittelwert berechneMittelwert(double[] messwerte) {
        //Initialisieren der Variabeln
        int summe = 0;
        int werteLaenge = messwerte.length;
        double naechsterWert = 0.0;
        double entferntesterWert = 0.0;
        
        // addieren der Messewerte zu einer Summe
        for (int i = 0; i <= werteLaenge-1; i++) {
            summe += messwerte[i];
            }
        
        //ausrechnen des arithmetischen Mittels
        double arithmetischesMittel = summe/werteLaenge;
        
        //Sortieren des Arrays
        Arrays.sort(messwerte);
        int index = 0;
        //Suche nach dem Wert der am naechsten am Mittel dran liegt
        int i = Arrays.binarySearch(messwerte, arithmetischesMittel);
        //Testen ob das Mittel im Array enthalten ist
        if (i < 0) {
            index = -i -1;
            //Testen ob der Index vom naechsten Wert groesser als die Laenge des Arrays ist
            if (index < werteLaenge) {
                naechsterWert = messwerte[index];
            }
        } else {
            naechsterWert = messwerte[i];
        }

        //Suche nach dem Wert der am weitesten vom Mittel entfernt ist
        if (index > (werteLaenge-index)) {
            entferntesterWert = messwerte[0];
        } else {
            entferntesterWert = messwerte[werteLaenge-1];
        }
        
        //erstellen eines Objektes mit den Werten die ausgegeben werden sollen
        Mittelwert mittelwert = new Mittelwert(arithmetischesMittel, naechsterWert, entferntesterWert);
        
        return mittelwert;
    }
    
    /**
     * Methode um Strings zu zaehlen die ausschliesslich in gross- oder
     * Kleinbuchstaben geschrieben sind
     * 
     * @param strings das Array mit den Strings
     */
    
    public int stringsAuswerten(String[] strings) {
        int ergebnis = 0;
        
        //Vergleich des Normalen Strings zu einem String der nur in Groß oder Kleinbuchstaben gechrieben ist
        for (int i = 0; i <= strings.length-1; i++) {
            if (strings[i].toUpperCase().equals(strings[i]) || strings[i].toLowerCase().equals(strings[i])) {
                ergebnis += 1;
            }
        }
        
        return ergebnis;
    }
}
