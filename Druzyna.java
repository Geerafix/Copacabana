public class Druzyna 
{
    private String nazwa_druzyny;
    int wynik_do, wynik_s, wynik_pl;

    public Druzyna(String nazwa_druzyny)
    {
        this.nazwa_druzyny = nazwa_druzyny;
        wynik_do = 0;
        wynik_s = 0;
        wynik_pl = 0;
    }

    public void dodajWynik(String sport)
    {
        if(sport == "dwaognie")
        {
            ++wynik_do;
        }
        else if(sport == "siatkowka")
        {
            ++wynik_s;
        }
        else if(sport == "przeciaganieliny")
        {
            ++wynik_pl;
        }
    }

    public String getDruzyna()
    {
        return nazwa_druzyny;
    }

}
