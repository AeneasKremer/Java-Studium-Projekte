
/**
 * Beschreiben Sie hier die Klasse Patient.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Patient
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int patientenNummer;
    private String vorname;
    private String nachname;
    
    private final static String FALSCHE_PATIENTENNUMMER = "Die Patientennummer muss 4 stellig sein!";

    /**
     * Konstruktor für Objekte der Klasse Patient
     */
    public Patient(int patientenNummer, String vorname, String nachname)
    {
        if (String.valueOf(patientenNummer).length() == 4) {
            this.patientenNummer = patientenNummer;
            this.vorname = vorname;
            this.nachname = nachname;
        } else {
            throw new IllegalArgumentException(FALSCHE_PATIENTENNUMMER);
        }
    }
    
    public int getPatientenNummer() {
        return this.patientenNummer;
    }
    
    public String getVorname() {
        return this.vorname;
    }
    
    public String getNachname() {
        return this.nachname;
    }
    
    public String toString() {
        String ausgabe = (patientenNummer + ", " + vorname + " " + nachname);
        
        return ausgabe;
    }
}
