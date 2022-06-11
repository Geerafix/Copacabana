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
    private FileWriter doPliku;
    private Scanner odczyt;

    public ListaDruzyn()
    {
        lista_druzyn = new ArrayList<>();
    }

    public void dodajDruzyne(String druzyna) throws IOException
    {
        Druzyna dr = new Druzyna(druzyna);
        lista_druzyn.add(dr);
        doPliku = new FileWriter(plik, true);
        doPliku.write(druzyna);
        doPliku.write("\n");
        doPliku.close();
    }

    public void usunDruzyne(String nazwa_druzyny) throws IOException
    {
        Druzyna pomoc = null;
        for(Druzyna dr1 : lista_druzyn)
        {
            if(dr1.getDruzyna().equals(nazwa_druzyny))
            {
                pomoc = dr1;
            }
            else
                continue;
        }     
        lista_druzyn.remove(pomoc);

        doPliku = new FileWriter(plik, false);

        for(Druzyna dr2 : lista_druzyn)
        {
            doPliku.write(dr2.getDruzyna());
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
                Druzyna druzyna = new Druzyna(wiersz);
                lista_druzyn.add(druzyna);
            }
    }  
    
    public void wyswietl()
    {
        for(int i = 0; i < lista_druzyn.size(); i++)
        {
            System.out.print(lista_druzyn.get(i).getDruzyna() + "  ");
        }
        System.out.println();
    }

    public boolean czyZawiera(Druzyna dr1)
    {
        return lista_druzyn.contains(dr1);
    }
}
