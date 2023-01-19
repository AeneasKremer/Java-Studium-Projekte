
/**
 * Beschreiben Sie hier die Klasse PatientenWarteschlange.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PatientenWarteschlange
{
    //Atribute erstellen
    private Patient[] warteschlange;
    private int patientenZaehler = 0;
    
    //Fehlermeldungen erstellen
    private static final String PATIENTENNUMMER_EXISTIERT_BEREITS = ("Diese Patientennummer existiert bereits!");
    private static final String WARTESCHLANGE_VOLL = ("Die Warteschlange ist voll!");
    private static final String PATIENTENNUMMER_EXISTIERT_NICHT = ("Die Patientennummer existiert nicht!");
    
    /**
     * Konstruktor um eine Warteschlange mit einer vorgegebener Laenge
     * 
     * @param groesse bestimmt wie gross die Warteschlange ist
     */
    
    public PatientenWarteschlange(int groesse) {
        warteschlange = new Patient[groesse];
    }
    
    /**
     * Erstellt einen neuen Patienten und fügt ihn der Warteschlange hinzu
     * 
     * @param patientenNummer die Nummer um den Patienten zu identifizieren
     * @param vorname der Vorname des Patienten
     * @param nachname der Nachname des Patienten
     */
    
    public void neuerPatient(int patientenNummer, String vorname, String nachname) {
        Patient patient = new Patient(patientenNummer, vorname, nachname);
        for (int i = 0; i <= (warteschlange.length)-1; i++) {
            if (warteschlange[i] != null &&warteschlange[i].getPatientenNummer() == patient.getPatientenNummer()) {
                throw new IllegalArgumentException(PATIENTENNUMMER_EXISTIERT_BEREITS);
            }
        }
        if (patientenZaehler >= warteschlange.length) {
            throw new IllegalArgumentException(WARTESCHLANGE_VOLL);
        }
        for (int i = 0; i <= (warteschlange.length)-1; i++) {
            if (warteschlange[i] == null) {
                this.warteschlange[i] = patient;
                System.out.println("Der Patient wurde erstellt!");
                this.patientenZaehler++;
                break;
            }
        }
    }
    
    /**
     * Entfernt einen Patienten aus der Warteschlange mit Hilfe der Patientennummer
     * 
     * @param patientenNummer die Patientennummer von dem Patienten der entfernt werden soll
     */
    public Patient entfernePatient(int patientenNummer) {
        Patient entfernterPatient = new Patient(1234, "", "");
        for (int i = 0; i <= (warteschlange.length)-1; i++) {
            if (warteschlange[i] != null) {
                if (warteschlange[i].getPatientenNummer() == patientenNummer) {
                    int loeschen = i;
                    entfernterPatient = warteschlange[i];
                    for (int u = loeschen; u < warteschlange.length-1; u++) {
                        warteschlange[u] = warteschlange[u + 1];
                    }
                    this.patientenZaehler--;
                    System.out.println("Der Patient wurde gelöscht!");
                    break;
                }
            } else {
                throw new IllegalArgumentException(PATIENTENNUMMER_EXISTIERT_NICHT);
            }
        }
        return entfernterPatient;
    }
    
    //Der naechste Patient wird aufgerufen, alle nachfolgenden Patienten ruecken auf
    public Patient derNaechsteBitte() {
        Patient naechsterPatient = warteschlange[0];
        
        for (int i = 0; i <= warteschlange.length-2; i++) {
            warteschlange[i] = warteschlange[i+1];
            warteschlange[warteschlange.length-1] = null;
        }
        
        return naechsterPatient;
    }
    
    //Eine Ausgabe fuer die Auflistung der Patienten
    public String toString() {
        String ausgabe = ("Warteliste \n");
        ausgabe += String.format("%-20s%-10s%-10s", "Patientennummer", "Vorname", "Nachname \n");
        for (int i = 0; i <= (warteschlange.length)-1; i++) {
            if (warteschlange[i] != null) {
                ausgabe += String.format("%-20d%-10s%-10s", warteschlange[i].getPatientenNummer(), warteschlange[i].getVorname(),
                        warteschlange[i].getNachname());
                ausgabe += "\n";
            }
        }
        return ausgabe;
    }
}
