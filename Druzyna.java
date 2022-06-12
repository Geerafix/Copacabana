import java.io.Serializable;

public class Druzyna implements Serializable
{
    private String nazwa_druzyny;
    int wynik_dwaOgnie, wynik_siatkowka, wynik_przeciaganieLiny;

    public Druzyna(String nazwa_druzyny)
    {   //konstruktor druzyny
        this.nazwa_druzyny = nazwa_druzyny;
        wynik_dwaOgnie = 0;
        wynik_siatkowka = 0;
        wynik_przeciaganieLiny = 0;
    }

    public void dodajWynik(String sport)
    {   //powiekszenie wyniku druzyny w danej dyscyplinie
        if(sport.equals("dwaOgnie"))
        {
            ++wynik_dwaOgnie;
        }
        else if(sport.equals("siatkowka"))
        {
            ++wynik_siatkowka;
        }
        else if(sport.equals("przeciaganieLiny"))
        {
            ++wynik_przeciaganieLiny;
        }
    }

    public String getDruzyna() 
    {   //zwrocenie nazwy druzyny
        return nazwa_druzyny;
    }

    public int wynikDwaOgnie()
    {   //zwrocenie wyniku z rozgrywki dwa ognie
        return wynik_dwaOgnie;
    }

    public int wynikPrzeciaganieLiny()
    {   //zwrocenie wyniku z rozgrywki przeciaganie liny
        return wynik_przeciaganieLiny;
    }

    public int wynikSiatkowka()
    {   //zwrocenie wyniku z rozgrywki siatkowka
        return wynik_siatkowka;
    }
}