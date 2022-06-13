import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        ListaDruzyn ldr = new ListaDruzyn();
        ListaSedziow lse = new ListaSedziow();
        TabelaWynikow tabw = new TabelaWynikow();
        int i = 1;

        ldr.zPliku();
        lse.zPliku();
        tabw.zPliku();
        ldr.pomoc();

        while(i == 1)
        {
            switch(sc.next())
            {
                case "siatkowka" :
                {
                    Druzyna dr1 = new Druzyna(sc.next());                 
                    Druzyna dr2 = new Druzyna(sc.next());
                    Sedzia sedzia = new Sedzia(sc.next());
                    Sedzia pom1 = new Sedzia(sc.next());
                    Sedzia pom2 = new Sedzia(sc.next());
                    String zwyciezca = sc.next();
                    Siatkowka spotkanie = new Siatkowka(dr1, dr2, sedzia, pom1, pom2, "siatkowka", zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "siatkowka");
                    break;
                }
                case "dwaOgnie" :
                {
                    Druzyna dr1 = new Druzyna(sc.next());                 
                    Druzyna dr2 = new Druzyna(sc.next());
                    Sedzia sedzia = new Sedzia(sc.next());
                    String zwyciezca = sc.next();
                    DwaOgnie spotkanie = new DwaOgnie(dr1, dr2, "dwaOgnie", sedzia, zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "dwaOgnie");
                    break;
                }
                case "przeciaganieLiny" :
                {
                    Druzyna dr1 = new Druzyna(sc.next());                 
                    Druzyna dr2 = new Druzyna(sc.next());
                    Sedzia sedzia = new Sedzia(sc.next());
                    String zwyciezca = sc.next();
                    PrzeciaganieLiny spotkanie = new PrzeciaganieLiny(dr1, dr2, "przeciaganieLiny", sedzia, zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "przeciaganieLiny");
                    break;
                }
                case "dodajD" :
                {
                    ldr.dodajDruzyne(sc.next());
                    ldr.doPliku();
                    break;
                }
                case "dodajS" :
                {
                    lse.dodajSedziego(sc.next());
                    lse.doPliku();
                    break;
                }
                case "usunD" :
                {
                    ldr.usunDruzyne(sc.next());
                    break;
                }
                case "usunS" :
                {
                    lse.usunSedziego(sc.next());
                    break;
                }
                case "druzyny" :
                {
                    ldr.wyswietl();
                    break;
                }
                case "sedziowie" :
                {
                    lse.wyswietl();
                    break;
                }
                case "spotkania" :
                {
                    tabw.wyswietl();
                    break;
                }
                case "wyniki" :
                {
                    ldr.wyswietlWyniki(sc.next());
                    break;
                }
                case "ldp" :
                {
                    tabw.doPliku();
                    ldr.doPliku();
                    lse.doPliku();
                }
                case "end" :
                {
                    i = 0;
                }
           }
        }
        sc.close();
    }
}
