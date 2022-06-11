import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TabelaWynikow 
{
    private ArrayList<Spotkanie> lista_spotkan;
    private File plik = new File("tabelaWynikow.txt");
    private FileWriter doPliku;
    public TabelaWynikow()
    {
        lista_spotkan = new ArrayList<>();
    }

    public void dodajSpotkanie(Spotkanie spotkanie, String sport) throws IOException
    {
        if(sport.equals("siatkowka"))
        {
            lista_spotkan.add(spotkanie);
            doPliku = new FileWriter(plik, true);
            doPliku.write(spotkanie.getDruzyna1().getDruzyna() + " ");
            doPliku.write(spotkanie.getDruzyna2().getDruzyna() + " ");
            doPliku.write(spotkanie.getSport() + " ");
            doPliku.write(spotkanie.getSedzia1().getSedzia() + " ");
            doPliku.write(spotkanie.getSedzia2().getSedzia() + " ");
            doPliku.write(spotkanie.getSedzia3().getSedzia() + " ");
            doPliku.write(spotkanie.getZwyciezca() + "\n");
            doPliku.close(); 
        }
        else
        {
            lista_spotkan.add(spotkanie);
            doPliku = new FileWriter(plik, true);
            doPliku.write(spotkanie.getDruzyna1().getDruzyna() + " ");
            doPliku.write(spotkanie.getDruzyna2().getDruzyna() + " ");
            doPliku.write(spotkanie.getSport() + " ");
            doPliku.write(spotkanie.getSedzia1().getSedzia() + " ");
            doPliku.write(spotkanie.getZwyciezca() + "\n");
            doPliku.close();    
        }
    }

    public void zPliku() throws FileNotFoundException
    {
        Scanner odczyt = new Scanner(plik);
        while(odczyt.hasNextLine())
        {
            Druzyna dr1 = new Druzyna(odczyt.next());
            Druzyna dr2 = new Druzyna(odczyt.next());
            String sport = odczyt.next();
            if(sport.equals("siatkowka"))
            {
                Sedzia sedzia = new Sedzia(odczyt.next());
                Sedzia pom1 = new Sedzia(odczyt.next());
                Sedzia pom2 = new Sedzia(odczyt.next());
                String zwyciezca = odczyt.next();
                Spotkanie spotkanie = new Spotkanie(dr1, dr2, sedzia, pom1, pom2, "siatkowka", zwyciezca);
                lista_spotkan.add(spotkanie);
            }
            else
            {
                Sedzia sedzia = new Sedzia(odczyt.next());
                String zwyciezca = odczyt.next();
                Spotkanie spotkanie = new Spotkanie(dr1, dr2, sport, sedzia, zwyciezca);
                lista_spotkan.add(spotkanie);
            }
            if(odczyt.nextLine() == null)
            {
                continue;
            }        
        }
        odczyt.close();
    }
    
    public void wyswietl()
    {
        for(Spotkanie spotkanie : lista_spotkan)
        {
            System.out.print("Druzyny: " + spotkanie.getDruzyna1().getDruzyna() + ", " +
            spotkanie.getDruzyna2().getDruzyna() + "; " +
            "Sport: " + spotkanie.getSport() + "; " + 
            "Sedziowie: " + spotkanie.getSedzia1().getSedzia() + ", ");
            if(spotkanie.getSedzia2() != null)
            {
                System.out.print(spotkanie.getSedzia2().getSedzia() + ", ");
            }
            if(spotkanie.getSedzia3() != null)
            {
                System.out.print(spotkanie.getSedzia3().getSedzia() + ", ");
            }
            System.out.print("Zwyciezca: " + spotkanie.getZwyciezca());
            System.out.println();
        }
    }

}
