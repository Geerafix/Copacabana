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
    //konstruktor listy sedziow
    public ListaSedziow()
    {   
        lista_sedziow = new ArrayList<>();
    }
    //dodawanie sedziego do listy poprzez podaną nazwe w parametrze i automatyczne wpisanie do pliku
    public void dodajSedziego(String imie_nazwisko) throws IOException
    {   
        fileIn = new FileOutputStream("listaSedziow.dat");
        objectIn = new ObjectOutputStream(fileIn);
        Sedzia se = new Sedzia(imie_nazwisko);
        lista_sedziow.add(se);  
    }
    //usuniecie sedziego z listy sedziow poprzez podaną nazwe w parametrze
    public void usunSedziego(String imie_nazwisko) throws IOException
    {   
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
    //odczyt druzyn z pliku
    public void zPliku() throws IOException, ClassNotFoundException
    {   
        fileOut = new FileInputStream("listaSedziow.dat");
        objectOut = new ObjectInputStream(fileOut);
        lista_sedziow = (ArrayList<Sedzia>) objectOut.readObject();
        fileOut.close();
        objectOut.close();
    }  
    //zapis listy druzyn do pliku jako obiektu
    public void doPliku() throws IOException
    {   
        fileIn = new FileOutputStream("listaSedziow.dat");
        objectIn = new ObjectOutputStream(fileIn);
        objectIn.writeObject(lista_sedziow);
        fileIn.close();
        objectIn.close();
    }
    //wyswietlanie wszystkich druzyn z listy
    public void wyswietl()
    {  
        for(Sedzia se : lista_sedziow)
        {
            System.out.print(se.getSedzia() + "  ");
        }
        System.out.println();
    }
    //zwrocenie listy sedziow
    public ArrayList<Sedzia> zwrocListe()
    {
        return lista_sedziow;
    }
}
