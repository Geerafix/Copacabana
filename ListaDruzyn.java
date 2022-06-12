import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ListaDruzyn implements Serializable
{
    private ArrayList<Druzyna> lista_druzyn;
    private FileOutputStream fileIn;
    private ObjectOutputStream objectIn;
    private FileInputStream fileOut;
    private ObjectInputStream objectOut;

    public ListaDruzyn()
    {   //konstruktor listy druzyn
        lista_druzyn = new ArrayList<>();
    }

    public void dodajDruzyne(String nazwa_druzyny) throws IOException 
    {   //dodawanie druzyny do listy poprzez podaną nazwe w parametrze
        fileIn = new FileOutputStream("listaDruzyn.dat");
        objectIn = new ObjectOutputStream(fileIn);
        Druzyna dr = new Druzyna(nazwa_druzyny);
        lista_druzyn.add(dr);
    }

    public void usunDruzyne(String nazwa_druzyny) throws IOException
    {   //usuniecie druzyny z listy druzyn poprzez podaną nazwe w parametrze
        fileIn = new FileOutputStream("listaDruzyn.dat");
        objectIn = new ObjectOutputStream(fileIn);
        for(Druzyna dr : lista_druzyn)
        {
            if(dr.getDruzyna().equals(nazwa_druzyny))
            {
                lista_druzyn.remove(dr);
                break;
            }
        }
        //wpisanie do pliku listy zmodyfikowanej jako obiekt
        objectIn.writeObject(lista_druzyn);
        fileIn.close();
        objectIn.close();
    }

    public void zPliku() throws IOException, ClassNotFoundException
    {   //odczyt druzyn z pliku
        fileOut= new FileInputStream("listaDruzyn.dat");
        objectOut = new ObjectInputStream(fileOut);
        lista_druzyn = (ArrayList<Druzyna>) objectOut.readObject();
        fileOut.close();
        objectOut.close();
    }  

    public void listaDoPliku() throws IOException
    {   //zapis listy druzyn do pliku jako obiektu
        fileIn = new FileOutputStream("listaDruzyn.dat");
        objectIn = new ObjectOutputStream(fileIn);
        objectIn.writeObject(lista_druzyn);
        fileIn.close();
        objectIn.close();
    }

    public void wyswietl()
    {   //wyswietlanie wszystkich druzyn z listy
        for(Druzyna dr : lista_druzyn)
        {
            System.out.print(dr.getDruzyna() + "  ");
        }
        System.out.println();
    }

    public void wyswietlWyniki(String nazwa_druzyny)
    {
        //wyswietlanie wynikow druzyny o podanej nazwie
        for(Druzyna dr : lista_druzyn)
        {
            if(dr.getDruzyna().equals(nazwa_druzyny));
            {
                System.out.println("Siatkowka: " + dr.wynikSiatkowka());
                System.out.println("Dwa Ognie: " + dr.wynikDwaOgnie());
                System.out.println("Przeciaganie Liny: " + dr.wynikPrzeciaganieLiny());
                break;
            }
        }
    }
}
