import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class TabelaWynikow implements Serializable
{
    private ArrayList<Spotkanie> lista_spotkan;
    private FileOutputStream fileIn;
    private ObjectOutputStream objectIn;
    private FileInputStream fileOut;
    private ObjectInputStream objectOut;
    
    public TabelaWynikow()
    {   //konstruktor listy spotkan
        lista_spotkan = new ArrayList<>();
    }

    public void dodajSpotkanie(Spotkanie spotkanie) throws IOException
    {   //dodanie spotkania i wpisanie do pliku
        lista_spotkan.add(spotkanie);   
    }

    public void zPliku() throws IOException, ClassNotFoundException
    {   //odczytanie spotkan z pliku
        fileOut = new FileInputStream("listaSpotkan.dat");
        objectOut = new ObjectInputStream(fileOut);
        lista_spotkan = (ArrayList<Spotkanie>) objectOut.readObject();
        fileOut.close();
        objectOut.close();
    }

    public void listaDoPliku() throws IOException
    {   //zapis listy spotkan do pliku jako obiektu
        fileIn = new FileOutputStream("listaSpotkan.dat");
        objectIn = new ObjectOutputStream(fileIn);
        objectIn.writeObject(lista_spotkan);
        fileIn.close();
        objectIn.close();
    }
    
    public void wyswietl()
    {   //wyswietlenie wszystkich spotkan
        for(Spotkanie spotkanie : lista_spotkan)
        {
            int i = 1;
            System.out.print(i + ". Druzyny: " + spotkanie.getDruzyna1().getDruzyna() + ", " +
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
            ++i;
        }
    }

}
