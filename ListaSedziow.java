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
    private FileWriter doPliku;
    private Scanner odczyt;
    
    public ListaSedziow()
    {
        lista_sedziow = new ArrayList<>();
    }

    public void dodajSedziego(String sedzia) throws IOException
    {
        Sedzia se = new Sedzia(sedzia);
        lista_sedziow.add(se);
        doPliku = new FileWriter(plik, true);
        doPliku.write(sedzia);
        doPliku.write("\n");
        doPliku.close();   
    }

    public void usunSedziego(String imie_nazwisko) throws IOException
    {
        Sedzia pomoc = null;
        for(Sedzia se1 : lista_sedziow)
        {
            if(se1.getSedzia().equals(imie_nazwisko))
            {
                pomoc = se1;
            }
            else
                continue;
        }     
        lista_sedziow.remove(pomoc);

        doPliku = new FileWriter(plik, false);

        for(Sedzia se2 : lista_sedziow)
        {
            doPliku.write(se2.getSedzia());
            doPliku.write("\n");
        }
        doPliku.close();
    }

    public void zPliku() throws FileNotFoundException
    {
        odczyt = new Scanner(plik);
        String wiersz;
        while(odczyt.hasNextLine())
            {
                wiersz = odczyt.nextLine();
                Sedzia sedzia = new Sedzia(wiersz);
                lista_sedziow.add(sedzia);
            }
    }  
    
    public void wyswietl()
    {
        for(int i = 0; i < lista_sedziow.size(); i++)
        {
            System.out.print(lista_sedziow.get(i).getSedzia() + "  ");
        }
        System.out.println();
    }

    public boolean czyZawiera(Sedzia se1)
    {
        return lista_sedziow.contains(se1);
    }
}
