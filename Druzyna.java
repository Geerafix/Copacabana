public class Druzyna 
{
    private String nazwa_druzyny;
    int wynik_dwaognie, wynik_siatkowka, wynik_przeciaganieliny;

    public Druzyna(String nazwa_druzyny)
    {
        this.nazwa_druzyny = nazwa_druzyny;
        wynik_dwaognie = 0;
        wynik_siatkowka = 0;
        wynik_przeciaganieliny = 0;
    }

    public void dodajWynik(String sport)
    {
        if(sport == "dwaognie")
        {
            ++wynik_dwaognie;
        }
        else if(sport == "siatkowka")
        {
            ++wynik_siatkowka;
        }
        else if(sport == "przeciaganieliny")
        {
            ++wynik_przeciaganieliny;
        }
    }

    public String getDruzyna()
    {
        return nazwa_druzyny;
    }

}
