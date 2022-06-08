import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaDruzyn 
{
    private ArrayList<Druzyna> lista_druzyn;
    private File plik = new File("listaDruzyn.txt");
    private Scanner odczyt;
    private FileWriter doPliku;
     
    public ListaDruzyn()
    {
        lista_druzyn = new ArrayList<>();
    }

    public void dodajDruzyne(Druzyna druzyna) throws IOException
    {
        lista_druzyn.add(druzyna);
        doPliku = new FileWriter(plik, true);
        doPliku.write(druzyna.getDruzyna());
        doPliku.write("\n");
        doPliku.close();
    }

    public void usunDruzyne(String nazwa_druzyny) throws IOException
    {
        for(int i = 0; i < lista_druzyn.size(); i++)
        {
            if(nazwa_druzyny == lista_druzyn.get(i).getDruzyna())
            {
                lista_druzyn.remove(lista_druzyn.get(i));
            }
            else 
                continue;
        }      

        doPliku = new FileWriter(plik, false);
            
        for(Druzyna druzyna : lista_druzyn)
            {
                doPliku.write(druzyna.getDruzyna());
                doPliku.write("\n");
            }
        doPliku.close();
    }

    public void zPliku() throws FileNotFoundException
    {
        odczyt = new Scanner(plik);
        String wiersz;
        Druzyna druzyna;
        while(odczyt.hasNextLine())
            {
                wiersz = odczyt.nextLine();
                druzyna = new Druzyna(wiersz);
                lista_druzyn.add(druzyna);
            }
    }  
    
    public void wyswietl()
    {
        for(int i = 0; i < lista_druzyn.size(); i++)
        {
            System.out.println(lista_druzyn.get(i).getDruzyna());
        }
    }

}
