import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ListaDruzyn implements Serializable
{
    public static ArrayList<Druzyna> lista_druzyn;
    private ArrayList<String> lista_pomocnicza;
    private FileOutputStream fileIn;
    private ObjectOutputStream objectIn;
    private FileInputStream fileOut;
    private ObjectInputStream objectOut;
    //konstruktor listy druzyn
    public ListaDruzyn()
    {   
        lista_druzyn = new ArrayList<>();
    }

    public void dodajDruzyne(String nazwa_druzyny) throws IOException 
    {   //dodawanie druzyny do listy poprzez podaną nazwe w parametrze
        fileIn = new FileOutputStream("listaDruzyn.dat");
        objectIn = new ObjectOutputStream(fileIn);
        Druzyna dr = new Druzyna(nazwa_druzyny);
        lista_druzyn.add(dr);
    }
    //usuniecie druzyny z listy druzyn poprzez podaną nazwe w parametrze
    public void usunDruzyne(String nazwa_druzyny) throws IOException, BrakDruzyny
    { 
        fileIn = new FileOutputStream("listaDruzyn.dat");
        objectIn = new ObjectOutputStream(fileIn);
        try{
            if(lista_pomocnicza.contains(nazwa_druzyny))
            {
                for(Druzyna dr : lista_druzyn)
                {
                    if(dr.getDruzyna().equals(nazwa_druzyny))
                    {
                        lista_druzyn.remove(dr);
                        break;
                    }
                }
            }
            else
            throw new BrakDruzyny("Brak druzyny na liscie: " + nazwa_druzyny);
        }   catch(Exception e)
        {
            e.printStackTrace();
        }
    //wpisanie do pliku listy zmodyfikowanej jako obiekt
        objectIn.writeObject(lista_druzyn);
        fileIn.close();
        objectIn.close();
    }
    //odczyt druzyn z pliku
    public void zPliku() throws IOException, ClassNotFoundException
    {  
        fileOut= new FileInputStream("listaDruzyn.dat");
        objectOut = new ObjectInputStream(fileOut);
        lista_druzyn = (ArrayList<Druzyna>) objectOut.readObject();
        fileOut.close();
        objectOut.close();
    }  
    //zapis listy druzyn do pliku jako obiektu
    public void doPliku() throws IOException
    {  
        fileIn = new FileOutputStream("listaDruzyn.dat");
        objectIn = new ObjectOutputStream(fileIn);
        objectIn.writeObject(lista_druzyn);
        fileIn.close();
        objectIn.close();
    }
    //wyswietlanie wszystkich druzyn z listy
    public void wyswietl()
    {   
        for(Druzyna dr : lista_druzyn)
        {
            System.out.print(dr.getDruzyna() + "  ");
        }
        System.out.println();
    }
    //tworzenie pomocniczej listy do sprawdzania czy dana druzyna jest na liscie
    public void pomoc()
    {   
        lista_pomocnicza = new ArrayList<>();
        for(Druzyna dr : lista_druzyn)
        {
            lista_pomocnicza.add(dr.getDruzyna());
        }
    }
    //dodawanie wyniku do druzyny podanej jej nazwe i dyscypliny w jakiej brała udział
    public void dodajWynik(String zwyciezca, String sport)
    {
        int i = 0;
        if(lista_pomocnicza.contains(zwyciezca))
        {
             i = lista_pomocnicza.indexOf(zwyciezca);
        }
        lista_druzyn.get(i).dodajWynik(sport);
    }
    //wyswietlanie wynikow druzyny o podanej nazwie
    public void wyswietlWyniki(String nazwa_druzyny) throws BrakDruzyny
    {
        int i = 0;
        try{
            if(lista_pomocnicza.contains(nazwa_druzyny))
            {
                i = lista_pomocnicza.indexOf(nazwa_druzyny);
                System.out.println("Siatkowka: " + lista_druzyn.get(i).wynikSiatkowka());
                System.out.println("Dwa Ognie: " + lista_druzyn.get(i).wynikDwaOgnie());
                System.out.println("Przeciaganie Liny: " + lista_druzyn.get(i).wynikPrzeciaganieLiny());
            }   
            else
            throw new BrakDruzyny("Brak druzyny na liscie: " + nazwa_druzyny);
        }   catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //zwrocenie listy druzyn
    public ArrayList<Druzyna> zwrocListe()
    {
        return lista_druzyn;
    }
    //sprawdzenie czy lista zawiera dana druzyne
    public boolean czyZawiera(String nazwa_druzyny)
    {
        return lista_pomocnicza.contains(nazwa_druzyny);
    }
}
