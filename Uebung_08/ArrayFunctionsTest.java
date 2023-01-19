

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse ArrayFunctionsTest.
 *
 * @author  Aeneas Kremer, Daniel Mayer
 * @version 08.01.2023
 */
public class ArrayFunctionsTest
{
    private ArrayFunctions arrayFunctions;
    private Mittelwert mittelwert;
    private final static double EPSILON = 0.00000000001;
    
    @Test
    public void testBerechneMittelwert_mit_korrekten_mittelwert() {
        double[] messwerte = {1.11, 3.33, 4.44, 5.55, 6.66};
        
        double erwarteterMittelwert = 3.0;
        
        Mittelwert mittelwert = new ArrayFunctions().berechneMittelwert(messwerte);
        
        double tatsaechlicherMittelwert = mittelwert.getArithmetischesMittel();
        
        assertEquals(erwarteterMittelwert, tatsaechlicherMittelwert, EPSILON);
    }
    
    @Test
    public void testBerechneMittelwert_mit_Mittel_enthalen_im_array() {
        double[] messwerte = {1.0, 2.0, 3.0};
        
        double erwarteterMittelwert = 2.0;
        
        Mittelwert mittelwert = new ArrayFunctions().berechneMittelwert(messwerte);
        
        double tatsaechlicherMittelwert = mittelwert.getArithmetischesMittel();
        
        assertEquals(erwarteterMittelwert, tatsaechlicherMittelwert, EPSILON);
    }
    
    @Test
    public void testBerechneMittelwert_mit_korrekten_naechsten_wert() {
        double[] messwerte = {1.11, 3.33, 4.44, 5.55, 6.66};
        
        double erwarteterNaechster = 3.33;
        
        Mittelwert mittelwert = new ArrayFunctions().berechneMittelwert(messwerte);
        
        double tatsaechlicherNaechster = mittelwert.getNaechsterWert();
        
        assertEquals(erwarteterNaechster, tatsaechlicherNaechster, EPSILON);
    }
    
    @Test
    public void testBerechneMittelwert_mit_korrekten_entferntesten_Wert() {
        double[] messwerte = {1.11, 3.33, 4.44, 5.55, 6.66};
        
        double erwarteterEntferntester = 6.66;
        
        Mittelwert mittelwert = new ArrayFunctions().berechneMittelwert(messwerte);
        
        double tatsaechlicherEntferntester = mittelwert.getEntferntesterWert();
        
        assertEquals(erwarteterEntferntester, tatsaechlicherEntferntester);
    }
    
    @Test
    public void testStringsAuswerten_mit_korrektem_Strings() {
        String[] strings = {"HTW", "saarland", "Saarbruecken", "MERZIG", "UNIversitaet"};
        
        int erwartetesErgebnis = 3;
        
        int tatsaechlichesErgebnis = new ArrayFunctions().stringsAuswerten(strings);
        
        assertEquals(erwartetesErgebnis, tatsaechlichesErgebnis);
    }
    
    @Test
    public void testStringsAuswerten_mit_leeren_Array() {
        String[] strings = {};
        
        int erwartetesErgebnis = 0;
        
        int tatsaechlichesErgebnis = new ArrayFunctions().stringsAuswerten(strings);
        
        assertEquals(erwartetesErgebnis, tatsaechlichesErgebnis);
    }
}
