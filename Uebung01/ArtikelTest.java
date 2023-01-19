

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse ArtikelTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ArtikelTest
{
    int artikelNr = 1234;
    String art = "Staubsauger";
    int bestand = 10;
    int preis = 100;
    Artikel artikel = new Artikel(artikelNr, art, bestand, preis);
    
    //korrekte Faelle
    
    @Test 
    void testArtikel_mit_artikelNr_korrekt() {
        int erwarteteArtikelNr = 5938;        
        Artikel neuerArtikel = new Artikel(erwarteteArtikelNr, this.art, this.bestand, this.preis);
        
        int tatsaechlicheArtikelNr = neuerArtikel.getArtikelNr();
        
        assertEquals(erwarteteArtikelNr, tatsaechlicheArtikelNr);
    }
    
    @Test
    public void testBucheAbgang_mit_10() {
        int aktuellerBestand = artikel.getBestand();
        int abgang = 10;
        final int erwarteterBestand = aktuellerBestand - abgang;
        
        artikel.bucheAbgang(abgang);
        
        final int tatsaechlicherBestand = artikel.getBestand();
        
        assertEquals(erwarteterBestand, tatsaechlicherBestand);

    }
    
    @Test
    public void testBucheZugang_mit_10() {
        int aktuellerBestand = artikel.getBestand();
        int zugang = 10;
        final int erwarteterBestand = aktuellerBestand + zugang;
        
        artikel.bucheZugang(zugang);
        
        final int tatsaechlicherBestand = artikel.getBestand();
        
        assertEquals(erwarteterBestand, tatsaechlicherBestand);

    }
    
    //Fehlerfaelle
    
    @Test
    public void testArtikel_mit_ungueltiger_artikelNr() {
        int ungueltigeArtikelNr = 12345;
        assertThrows(IllegalArgumentException.class, () -> {
            new Artikel(ungueltigeArtikelNr, this.art, this.bestand, this.preis);
        });
    }
    
    @Test
    public void testArtikel_Bestand_wird_falsch_übergeben() {
        int ungueltigerBestand = -10;
        assertThrows(IllegalArgumentException.class, () -> {
            new Artikel(this.artikelNr, this.art, ungueltigerBestand, this.preis);
        });
    }
    
    @Test
    public void testBucheAbgang_mit_minus_1_sollte_exception_werfen() {
        assertThrows(IllegalArgumentException.class, () -> {
            artikel.bucheAbgang(-1);
        });
    }
    
    @Test
    public void testBucheAbgang_mit_bestand_unter_0_sollte_exception_werfen() {
        assertThrows(IllegalArgumentException.class, () -> {
            artikel.bucheAbgang(11);
        });
    }
    

    }
