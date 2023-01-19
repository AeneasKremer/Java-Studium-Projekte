
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse LagerTest.
 *
 * @author  Aeneas Kremer, Daniel Mayer
 * @version 12.12.2022
 */

public class LagerTest
{
    private static final double EPSILON = 0.000001;
    private Artikel artikel1;
    private Artikel artikel2;
    private Lager lager;
    
    /**
     * Wird ausgefuehrt bevor jeder Testmethode
     */
    
    @BeforeEach
    public void setup() {
        artikel1 = new Artikel(1234, "Staubsauger", 10, 100);
        artikel2 = new Artikel(1235, "Toaster", 10, 100);
    }
    
    //korrekte Faelle
    
    @Test
    public void testLager_mit_gueltiger_LagerGroesse_gleich_32() {
        int erwarteteLagerGroesse = 32;
        Lager neuesLager = new Lager(erwarteteLagerGroesse);
        
        int tatsaechlicheLagerGroesse = neuesLager.getLagerGroesse();
        
        assertEquals(erwarteteLagerGroesse, tatsaechlicheLagerGroesse);
    }
    
    @Test
    public void testLager_ohne_LagerGroesse() {
        int erwarteteLagerGroesse = 10;
        Lager neuesLager = new Lager();
        
        int tatsaechlicheLagerGroesse = neuesLager.getLagerGroesse();
        
        assertEquals(erwarteteLagerGroesse, tatsaechlicheLagerGroesse);
    }
    
    @Test
    public void testLegeArtikelAn_mit_artikel_der_noch_nicht_im_lager_existiert() {
        Lager lager = new Lager();
        lager.legeAnArtikel(artikel1);
        Artikel tatsaechlicherArtikel = lager.getArtikel(0);
        
        assertEquals(artikel1, tatsaechlicherArtikel);
    }
    
    @Test
    public void testEntferneArtikel_mit_im_lager_bestehenden_artikel() {
        Lager lager = new Lager();
        lager.legeAnArtikel(artikel1);
        lager.entferneArtikel(artikel1.getArtikelNr());
        
        int zero = 0;
        assertEquals(zero, lager.getArtikelAnzahl());
    }
    
    @Test
    public void testBucheZugang_mit_5() {
        Lager lager = new Lager();
        lager.legeAnArtikel(artikel1);
        int zugang = 5;
        int erwarteterBestand = artikel1.getBestand() + zugang;
        
        lager.bucheZugang(artikel1.getArtikelNr(), zugang);
        int tatsaechlicherBestand = artikel1.getBestand();
        
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
    @Test
    public void testAenderePreisEinesArtikels_mit_50_Prozent() {
        Lager lager = new Lager();
        lager.legeAnArtikel(artikel1);
        
        double prozent = 50.0;
        int erwarteterPreis = (int)(artikel1.getPreis()+(artikel1.getPreis()/100)*prozent);
        
        lager.aenderePreisEinesArtikels(artikel1.getArtikelNr(), prozent);
        int tatsaechlicherPreis = (int)(artikel1.getPreis());
        
        assertEquals(erwarteterPreis, tatsaechlicherPreis);
    }
    
    @Test
    public void testAenderePreisEinesArtikels_mit_minus_50_Prozent() {
        Lager lager = new Lager();
        lager.legeAnArtikel(artikel1);
        
        double prozent = -50.0;
        int erwarteterPreis = (int)(artikel1.getPreis()+(artikel1.getPreis()/100)*prozent);
        
        lager.aenderePreisEinesArtikels(artikel1.getArtikelNr(), prozent);
        int tatsaechlicherPreis = (int)(artikel1.getPreis());
        
        assertEquals(erwarteterPreis, tatsaechlicherPreis);
    }
    
    //fehler Faelle
    
    @Test
    public void testLager_mit_LagerGroesse_gleich_minus_12_sollte_exception_werfen() {
        int ungueltigeLagerGroesse = -12;
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Lager(ungueltigeLagerGroesse);
        });
    }
    
    @Test
    public void testLegeAnArtikel_der_bereits_im_lager_existiert_sollte_exception_werfen() {
        Lager lager = new Lager();
        lager.legeAnArtikel(artikel1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            lager.legeAnArtikel(artikel1);
        });
        
    }
    
    @Test
    public void testLegeAnArtikel_wenn_das_lager_voll_ist_sollte_exception_wefen() {
        Lager lager = new Lager(1);
        lager.legeAnArtikel(artikel1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            lager.legeAnArtikel(artikel2);
        });
    }
    
    @Test
    public void testAenderePreisEinesArtikels_mit_preis_wird_negativ() {
        Lager lager = new Lager();
        lager.legeAnArtikel(artikel1);
        double prozent = -101.0;
        
        assertThrows(IllegalArgumentException.class, () -> {
            lager.aenderePreisEinesArtikels(artikel1.getArtikelNr(), prozent);
        });

    }
}
