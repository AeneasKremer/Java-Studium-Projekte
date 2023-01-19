import java.util.Scanner;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Diese Klasse Filtert aus HTML-Dateien beinhaltete Links
 * 
 * @author Aeneas Kremer, Daniel Mayer
 * @version 16.02.2023
 */
public class linkFilter
{
    public static void main(String args[])
    {
        //Scanner scanner = new Scanner(System.in);
        
        // Brauchst du nicht mehr wenn du abgibst von hier
        Scanner input;
        input = new Scanner(System.in);
    
        Scanner scanner; //Initialisieren des Scanners
        
        try {
            System.out.println("Welche Datei soll eingelesen werden?");
            String datei = input.next();
            scanner = new Scanner(new File(datei), "UTF-8"); //Einlesen der Datei
            
            //Erstellen der Variabeln
            String href = "";
            int hrefInZeileEnthalten = 0;
            int zeilenIndex = 0;
            
            //Hauptschleife
            while (scanner.hasNext()) {
                String zeile = scanner.nextLine(); //Zeilen werden eingelesen
                zeilenIndex++; //Pro Zeile wird der Index hochgezaehlt
                
                //Kontrolle, ob eine Zeile einen Link beinhaltet
                if (zeile.contains("<a href=")) {
                    String regexString = "\\b((https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~|!:,.;]*[-a-zA-Z0-9+&@#/%=~|])";//Erstellen des regex
                    Pattern pattern = Pattern.compile(regexString,Pattern.CASE_INSENSITIVE);//Erstellen eines Patterns
                    Matcher match = pattern.matcher(zeile);//Suchen ob das Pattern passt
                    
                    //Filtern der Links aus der Zeile
                    while (match.find()) {
                        href = zeile.substring(match.start(0),match.end(0));
                    }
                    
                    //Filtern des Namens der Website aus der Zeile
                    String website = "";
                    String[] s = zeile.split(">");
                    boolean booldex = true;
                    for (int i = 0; i < s.length; i++) {
                        if (s[i].contains("/a")) {
                           website = s[i].substring(0, (s[i].length() -3));
                        }
                    }
                    
                    //Hochzaehlen des Index fuer die Zeilen die einen Link beinhalten
                    hrefInZeileEnthalten++;
                    
                    //Ausgabe Part 1
                    String ausgabe = String.format("%-20s %s", website, href);
                    System.out.println(ausgabe);
                }
                
            }
            
            //Ausgabe Part 2
            System.out.println("Es wurden " + hrefInZeileEnthalten + " Links in " + zeilenIndex +
                " Zeilen gefunden!");
        } catch (Exception e) {
            //Exception falls die eingegebene Datei nicht gefunden wurde
            throw new IllegalArgumentException("Datei nicht gefunden!");
        }
        
        //bis hier

        
        

    }
}
