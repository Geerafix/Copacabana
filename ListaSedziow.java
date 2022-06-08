import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaSedziow 
{
    private ArrayList<Sedzia> lista_sedziow;
    private File plik = new File("listaSedziow.txt");
    private Scanner odczyt;
    private FileWriter doPliku;
     
    public ListaSedziow()
    {
        lista_sedziow = new ArrayList<>();
    }

    public void dodajSedziego(Sedzia sedzia) throws IOException
    {
        lista_sedziow.add(sedzia);
        doPliku = new FileWriter(plik, true);
        doPliku.write(sedzia.getSedzia());
        doPliku.write("\n");
        doPliku.close();
    }

    public void usunSedziego(String nazwa_druzyny) throws IOException
    {
        for(int i = 0; i < lista_sedziow.size(); i++)
        {
            if(nazwa_druzyny == lista_sedziow.get(i).getSedzia())
            {
                lista_sedziow.remove(lista_sedziow.get(i));
            }
            else 
                continue;
        }      

        doPliku = new FileWriter(plik, false);
            
        for(Sedzia sedzia : lista_sedziow)
            {
                doPliku.write(sedzia.getSedzia());
                doPliku.write("\n");
            }
        doPliku.close();
    }

    public void zPliku() throws FileNotFoundException
    {
        odczyt = new Scanner(plik);
        String wiersz;
        Sedzia sedzia;
        while(odczyt.hasNextLine())
            {
                wiersz = odczyt.nextLine();
                sedzia = new Sedzia(wiersz);
                lista_sedziow.add(sedzia);
            }
    }  
    
    public void wyswietl()
    {
        for(int i = 0; i < lista_sedziow.size(); i++)
        {
            System.out.println(lista_sedziow.get(i).getSedzia());
        }
    }

}
