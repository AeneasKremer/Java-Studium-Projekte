
/**
 * Eine Klasse die das Lager von Artikeln organisiert 
 * 
 * @author Aeneas Kremer, Daniel Mayer
 * @version 16.01.2023
 */

public class Lager
{
    private int artikelZaehler = 0;
    private Artikel[] lager;
    
    //Fehlerbehandlungen
    private static final String ARTIKELNUMMER_EXISTIERT_BEREITS = "Diese Artikel Nummer existiert bereits";
    private static final String ARTIKEL_EXISTIERT_BEREITS = "Der Artikel existiert beriets!";
    private static final String SPEICHERPLATZ_UNTER_EINS = "Die gewünschte Speicherplatz Anzahl darf nicht unter 1 liegen!";
    private static final String LAGER_IST_VOLL = "Das Lager ist voll!";
    private static final String ARTIKELNUMMER_EXISTIERT_NICHT = "Diese Artikelnummer existiert nicht!";
    private static final String INDEX_GROESSER_ALS_LAGERKAPAZITAET = "Der Index darf nicht größer als die Lagerkapazität sein!";
    private static final String KEIN_ARTIKEL_IM_LAGER = "Es befindet sich kein Artikel im Lager!";
    
    /**
     * Ein Lager mit der Groesse 10 und dem Datentyp Artikel wird erstellt
     */
    
    public Lager() {
        lager = new Artikel[10];
    }
    
    /**
     * Ein Lager mit einer angegebenen Groesse und dem Datentyp Artikel wird 
     * erstellt
     * 
     * @param groesseLager die groesse des Lagers
     */
    
    public Lager(int groesseLager) {
        if (groesseLager <= 0) {
            throw new IllegalArgumentException(SPEICHERPLATZ_UNTER_EINS);
        } else {
            this.lager = new Artikel[groesseLager];
        }
    }
    
    /**
     * Ein Artikel wird in einen Speicherort abgelegt
     * 
     * @param artikel ein Artikel der dem Lager hinzugefuegt werden soll
     */
    
    public void legeAnArtikel(Artikel artikel) {
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null &&lager[i].getArtikelNr() == artikel.getArtikelNr()) {
                throw new IllegalArgumentException(ARTIKELNUMMER_EXISTIERT_BEREITS);
            }
        }
        if (artikelZaehler >= lager.length) {
            throw new IllegalArgumentException(LAGER_IST_VOLL);
        }
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] == null) {
                validieren(artikel);
                this.lager[i] = artikel;
                System.out.println("Der Artikel wurde erstellt!");
                this.artikelZaehler++;
                break;
            }
        }
    }
    
    /**
     * Ein Video wird in einen Speicherort abgelegt
     * 
     * @param video ein Video der dem Lager hinzugefuegt werden soll
     */
    
    public void legeAnVideo(Video video) {
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null &&lager[i].getArtikelNr() == video.getArtikelNr()) {
                throw new IllegalArgumentException(ARTIKELNUMMER_EXISTIERT_BEREITS);
            }
        }
        if (artikelZaehler >= lager.length) {
            throw new IllegalArgumentException(LAGER_IST_VOLL);
        }
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] == null) {
                validieren(video);
                this.lager[i] = video;
                System.out.println("Das Video wurde erstellt!");
                this.artikelZaehler++;
                break;
            }
        }
    }
    
    /**
     * Eine CD wird in einen Speicherort abgelegt
     * 
     * @param cd eine CD der dem Lager hinzugefuegt werden soll
     */
    
    public void legeAnCd(Cd cd) {
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null &&lager[i].getArtikelNr() == cd.getArtikelNr()) {
                throw new IllegalArgumentException(ARTIKELNUMMER_EXISTIERT_BEREITS);
            }
        }
        if (artikelZaehler >= lager.length) {
            throw new IllegalArgumentException(LAGER_IST_VOLL);
        }
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] == null) {
                validieren(cd);
                this.lager[i] = cd;
                System.out.println("Die CD wurde erstellt!");
                this.artikelZaehler++;
                break;
            }
        }
    }
    
    /**
     * Ein Buch wird in einen Speicherort abgelegt
     * 
     * @param artikel ein Buch der dem Lager hinzugefuegt werden soll
     */
    
    public void legeAnBuch(Buch buch) {
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null &&lager[i].getArtikelNr() == buch.getArtikelNr()) {
                throw new IllegalArgumentException(ARTIKELNUMMER_EXISTIERT_BEREITS);
            }
        }
        if (artikelZaehler >= lager.length) {
            throw new IllegalArgumentException(LAGER_IST_VOLL);
        }
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] == null) {
                validieren(buch);
                this.lager[i] = buch;
                System.out.println("Die CD wurde erstellt!");
                this.artikelZaehler++;
                break;
            }
        }
    }
    
    /**
     * Ein Artikel wird ueber die Artikel Nummer aus dem Lager entfernt
     * 
     * @param artikelNr die Artikel Nummer um den Artikel im Lager zu finden
     */
    
    public void entferneArtikel(int artikelNr) {
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null) {
                if (lager[i].getArtikelNr() == artikelNr) {
                    int loeschen = i;
                    for (int u = loeschen; u < lager.length-1; u++) {
                        lager[u] = lager[u + 1];
                    }
                    this.artikelZaehler--;
                    System.out.println("Der Artikel wurde gelöscht!");
                    break;
                }
            } else {
                throw new IllegalArgumentException(ARTIKELNUMMER_EXISTIERT_NICHT);
            }
        }
    }
    
    /**
     * Bucht einen Zugang zu einem Artikel aus dem Lager
     * 
     * @param artikelNr die Artikel Nummer um den Artikel im Lager zu finden
     * @param zugang die zahl die zum Betrag addiert werden soll
     */
    
    public void bucheZugang(int artikelNr, int zugang) {
        if (zugang <= 0) {
            throw new IllegalArgumentException("Der Zugang muss größer gleich 1 sein!");
        } else if (zugang > 0) {
            for (int i = 0; i <= (lager.length)-1; i++) {
                if (lager[i] != null) {
                    if (lager[i].getArtikelNr() == artikelNr) {
                        lager[i].bucheZugang(zugang);
                        System.out.println("Die Zubuchung war erfolgreich!");
                        break;
                    } 
                } else {
                    throw new IllegalArgumentException(ARTIKELNUMMER_EXISTIERT_NICHT);
                }
            }
        }
        
    }
    
    /**
     * Bucht einen Abgang zum Betrag
     * 
     * @param artikelNr die Artikel Nummer um den Artikel im Lager zu finden
     * @param abgang die zahl die vom Betrag abgehen soll
     */
    
    public void bucheAbgang(int artikelNr, int abgang) {
        if (abgang <= 0) {
            throw new IllegalArgumentException("Der Abgang muss größer gleich 1 sein!");
        } else if (abgang > 0) {
            for (int i = 0; i <= (lager.length)-1; i++) {
                if (lager[i] != null) {
                    if (lager[i].getArtikelNr() == artikelNr) {
                        lager[i].bucheAbgang(abgang);
                        System.out.println("Die Abbuchung war erfolgreich!");
                        break;
                    }
                } else {
                    throw new IllegalArgumentException(ARTIKELNUMMER_EXISTIERT_NICHT);
                }
            }
        }
    }
    
    /**
     * Aendert den Preis von einem bestimmten Artikel aus dem Lager
     * 
     * @param artikelNr die Artikel Nummer um den Artikel im Lager zu finden
     * @param prozent die anzahl an prozent die vom Preis abgezogen werden
     */
    
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null) {
                if (lager[i].getArtikelNr() == artikelNr) {
                    double preis = lager[i].getPreis();
                    double neuerPreis = preis + ((preis/100)*prozent);
                    lager[i].setPreis(neuerPreis);
                    System.out.println("Der Preis wurde aktualisiert!");
                    break;
                }
            } else {
                    throw new IllegalArgumentException(ARTIKELNUMMER_EXISTIERT_NICHT);
                }
        }
    }
    
    /**
     * Aendert den Preis von allen Artikel aus dem Lager
     * 
     * @param prozent Die Anzahl von Prozent die jedem Artikel im Lager abgezogen werden
     */
    
    public void aenderePreisAllerArtikel(double prozent) {
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null) {
                double preis = lager[i].getPreis();
                double neuerPreis = preis + ((preis/100)*prozent);
                lager[i].setPreis(neuerPreis);
            } else {
                break;
            }
        }
        System.out.println("Der Preis wurde aktualisiert!");
    }
    
    /**
     * Zeigt einen Artikel an Hand seines Indexes
     * 
     * @param index der Index zu dem passenden Artikel aus dem Lager den man haben moechte
     */
    public Artikel getArtikel(int index) {
        if (index <= lager.length) {
            return lager[index];
        } else {
            throw new IllegalArgumentException(INDEX_GROESSER_ALS_LAGERKAPAZITAET);
        }
    }
    
    /**
     * Die Ausgabe aller Artikel die im Lager gespeichert sind
     */
    
    public String toString() {
        String ausgabe = "";
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null) {
                ausgabe += (i+1) + ": " + lager[i].toString() + "\n";
            }
        }
        return ausgabe;
    }
    
    /**
     * Ausgabe aller Artikel mit ausrechnen des Gesamtpreises
     */
    
    public String ausgebenBestandsListe() {
        if (artikelZaehler == 0) {
            throw new IllegalArgumentException(KEIN_ARTIKEL_IM_LAGER);
        } else {
            double summe = 0;
            String ausgabe = String.format("%-10s %-30s %-10s %-10s %-10s \n", "ArtNr",
                                           "Bescreibung", "Preis", "Bestand", "Gesamt");
            String border = "----------------------------------------------------------------------\n";
            ausgabe += border;
                                
            for (int i = 0; i <= (lager.length)-1; i++) {
                if (lager[i] != null) {
                    double gesamt = (lager[i].getPreis() * lager[i].getBestand());
                    summe += gesamt;
                    ausgabe += String.format("%-10s %-30s %-10.2f %-10s %-8.2f \n", lager[i].getArtikelNr(),
                                         lager[i].getBeschreibung(), lager[i].getPreis(), lager[i].getBestand(),
                                         gesamt);
                }
            }
            ausgabe += border;
            ausgabe += String.format("%-61s %8.2f", "Gesamtwert", summe);
            return ausgabe;
        }
    }
    
    /**
     * Die Anzahl an Artikeln die im Lager gespeichert sind
     */
    
    public int getArtikelAnzahl() {
        return this.artikelZaehler;
    }
    
    /**
     * Die Anzahl an Speicherplaetzen im Lager
     */
    
    public int getLagerGroesse() {
        return lager.length;
    }
    
    /**
     * Kontrolle ob der gleiche Artikel besteht
     */
    public void validieren(Artikel artikel) {
        for (int i = 0; i <= (lager.length)-1; i++) {
            if (lager[i] != null) {
                if (artikel.equals(lager[i])) {
                    throw new IllegalArgumentException(ARTIKEL_EXISTIERT_BEREITS);
                }
            }
        }
    }
}
