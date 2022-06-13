import java.io.Serializable;

public class Sedzia implements Serializable
{
    private String imie_nazwisko;
    //konstruktor sedzi
    public Sedzia(String imie_nazwisko)
    {   
        this.imie_nazwisko = imie_nazwisko;
    }
    //zwrocenie nazwy sedzi
    public String getSedzia()
    {   
        return imie_nazwisko;
    }
}