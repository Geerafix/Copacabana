import java.io.Serializable;

public class Druzyna implements Serializable
{
    private String nazwa_druzyny;
    int wynik_dwaOgnie, wynik_siatkowka, wynik_przeciaganieLiny;
    //konstruktor druzyny
    public Druzyna(String nazwa_druzyny)
    {  
        this.nazwa_druzyny = nazwa_druzyny;
        this.wynik_dwaOgnie = 0;
        this.wynik_siatkowka = 0;
        this.wynik_przeciaganieLiny = 0;
    }
    //powiekszenie wyniku druzyny w danej dyscyplinie
    public void dodajWynik(String sport)
    {   
        if(sport.equals("dwaOgnie"))
        {
            ++this.wynik_dwaOgnie;
        }
        else if(sport.equals("siatkowka"))
        {
            ++this.wynik_siatkowka;
        }
        else if(sport.equals("przeciaganieLiny"))
        {
            ++this.wynik_przeciaganieLiny;
        }
    }
    //zwrocenie nazwy druzyny
    public String getDruzyna() 
    {   
        return this.nazwa_druzyny;
    }
    //zwrocenie wyniku z rozgrywki dwa ognie
    public int wynikDwaOgnie()
    {   
        return this.wynik_dwaOgnie;
    }
    //zwrocenie wyniku z rozgrywki "Przeciaganie Liny"
    public int wynikPrzeciaganieLiny()
    {   
        return this.wynik_przeciaganieLiny;
    }
    //zwrocenie wyniku z rozgrywki siatkowka
    public int wynikSiatkowka()
    {  
        return this.wynik_siatkowka;
    }
}