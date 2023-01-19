
/**
 * Beschreiben Sie hier die Klasse Mittelwert.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mittelwert
{
    private double arithmetischesMittel;
    private double naechsterWert;
    private double entferntesterWert;
    
    public Mittelwert(double arithmetischesMittel, double naechsterWert, double entferntesterWert) {
        this.arithmetischesMittel = arithmetischesMittel;
        this.naechsterWert = naechsterWert;
        this.entferntesterWert = entferntesterWert;
    }

    public double getArithmetischesMittel()
    {
        return this.arithmetischesMittel;
    }
    
    public double getNaechsterWert() {
        return this.naechsterWert;
    }
    
    public double getEntferntesterWert() {
        return this.entferntesterWert;
    }
}
