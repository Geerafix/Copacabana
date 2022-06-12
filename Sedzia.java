import java.io.Serializable;

public class Sedzia implements Serializable
{
    private String imie_nazwisko;

    public Sedzia(String imie_nazwisko)
    {   //konstruktor sedzi
        this.imie_nazwisko = imie_nazwisko;
    }

    public String getSedzia()
    {   //zwrocenie nazwy sedzi
        return imie_nazwisko;
    }
}