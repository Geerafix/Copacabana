import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ListaSedziow implements Serializable
{
    private ArrayList<Sedzia> lista_sedziow;
    private FileOutputStream fileIn;
    private ObjectOutputStream objectIn;
    private FileInputStream fileOut;
    private ObjectInputStream objectOut;
    
    public ListaSedziow()
    {   //konstruktor listy sedziow
        lista_sedziow = new ArrayList<>();
    }

    public void dodajSedziego(String imie_nazwisko) throws IOException
    {   //dodawanie sedziego do listy poprzez podaną nazwe w parametrze i automatyczne wpisanie do pliku
        fileIn = new FileOutputStream("listaSedziow.dat");
        objectIn = new ObjectOutputStream(fileIn);
        Sedzia se = new Sedzia(imie_nazwisko);
        lista_sedziow.add(se);  
    }

    public void usunSedziego(String imie_nazwisko) throws IOException
    {   //usuniecie sedziego z listy sedziow poprzez podaną nazwe w parametrze
        fileIn = new FileOutputStream("listaDruzyn.dat");
        objectIn = new ObjectOutputStream(fileIn);
        for(Sedzia se : lista_sedziow)
        {
            if(se.getSedzia().equals(imie_nazwisko))
            {
                lista_sedziow.remove(se);
                break;
            }
        }
        //wpisanie do pliku zmodyfikowanej listy sedziow jako obiekt
        objectIn.writeObject(lista_sedziow);
        fileIn.close();
        objectIn.close();
    }

    public void zPliku() throws IOException, ClassNotFoundException
    {   //odczyt druzyn z pliku
        fileOut = new FileInputStream("listaSedziow.dat");
        objectOut = new ObjectInputStream(fileOut);
        lista_sedziow = (ArrayList<Sedzia>) objectOut.readObject();
        fileOut.close();
        objectOut.close();
    }  

    public void listaDoPliku() throws IOException
    {   //zapis listy druzyn do pliku jako obiektu
        fileIn = new FileOutputStream("listaSedziow.dat");
        objectIn = new ObjectOutputStream(fileIn);
        objectIn.writeObject(lista_sedziow);
        fileIn.close();
        objectIn.close();
    }
    
    public void wyswietl()
    {   //wyswietlanie wszystkich druzyn z listy
        for(Sedzia se : lista_sedziow)
        {
            System.out.print(se.getSedzia() + "  ");
        }
        System.out.println();
    }
}
