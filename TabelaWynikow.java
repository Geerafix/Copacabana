import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TabelaWynikow 
{
    private File plik = new File("listaSpotkan.txt");
    private ArrayList<Spotkanie> lista_spotkan;
    private Scanner odczyt;
    private FileWriter doPliku;

    public TabelaWynikow()
    {
        lista_spotkan = new ArrayList<>();
    }

    public void dodajSpotkanie(Spotkanie spotkanie) throws IOException
    {
        lista_spotkan.add(spotkanie);
        doPliku = new FileWriter(plik, true);
        doPliku.write(spotkanie.getDruzyna1().getDruzyna() + " ");
        doPliku.write(spotkanie.getDruzyna2().getDruzyna() + " ");
        doPliku.write(spotkanie.getSport());
        doPliku.write(spotkanie.getSedzia1().getSedzia());
        doPliku.close();     
    }

    public void zPliku()
    {

    }
    
    public void wyswietl()
    {
        for(int i = 0; i < lista_spotkan.size(); i++)
        {
            System.out.println(lista_spotkan.get(i).getDruzyna1().getDruzyna() + "-" 
            + lista_spotkan.get(i).getDruzyna2().getDruzyna() + ", "
            + lista_spotkan.get(i).getSport() + " | "
            + lista_spotkan.get(i).getSedzia1().getSedzia());
        }
    }
}
