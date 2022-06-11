public class Druzyna 
{
    private String nazwa_druzyny;
    int wynik_dwaOgnie, wynik_siatkowka, wynik_przeciaganieLiny;

    public Druzyna(String nazwa_druzyny)
    {
        this.nazwa_druzyny = nazwa_druzyny;
        wynik_dwaOgnie = 0;
        wynik_siatkowka = 0;
        wynik_przeciaganieLiny = 0;
    }

    public void dodajWynik(String sport)
    {
        if(sport.equals("dwaognie"))
        {
            ++wynik_dwaOgnie;
        }
        else if(sport.equals("siatkowka"))
        {
            ++wynik_siatkowka;
        }
        else if(sport.equals("przeciaganieliny"))
        {
            ++wynik_przeciaganieLiny;
        }
    }

    public String getDruzyna()
    {
        return nazwa_druzyny;
    }
    

}