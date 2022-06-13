import java.util.Scanner;

public class Menu 
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        ListaDruzyn ldr = new ListaDruzyn();
        ListaSedziow lse = new ListaSedziow();
        TabelaWynikow tabw = new TabelaWynikow();
        int i = 1;

        ldr.zPliku();
        lse.zPliku();
        tabw.zPliku();
        ldr.pomoc();
        lse.pomoc();

        while(i == 1)
        {
            switch(input.next())
            {
                case "siatkowka" :
                {
                    Druzyna dr1 = new Druzyna(input.next());                 
                    Druzyna dr2 = new Druzyna(input.next());
                    Sedzia sedzia = new Sedzia(input.next());
                    Sedzia pom1 = new Sedzia(input.next());
                    Sedzia pom2 = new Sedzia(input.next());
                    String zwyciezca = input.next();
                    Siatkowka spotkanie = new Siatkowka(dr1, dr2, sedzia, pom1, pom2, "siatkowka", zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "siatkowka");
                    break;
                }
                case "dwaOgnie" :
                {
                    Druzyna dr1 = new Druzyna(input.next());                 
                    Druzyna dr2 = new Druzyna(input.next());
                    Sedzia sedzia = new Sedzia(input.next());
                    String zwyciezca = input.next();
                    DwaOgnie spotkanie = new DwaOgnie(dr1, dr2, "dwaOgnie", sedzia, zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "dwaOgnie");
                    break;
                }
                case "przeciaganieLiny" :
                {
                    Druzyna dr1 = new Druzyna(input.next());                 
                    Druzyna dr2 = new Druzyna(input.next());
                    Sedzia sedzia = new Sedzia(input.next());
                    String zwyciezca = input.next();
                    PrzeciaganieLiny spotkanie = new PrzeciaganieLiny(dr1, dr2, "przeciaganieLiny", sedzia, zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "przeciaganieLiny");
                    break;
                }
                case "dodajD" :
                {
                    ldr.dodajDruzyne(input.next());
                    ldr.pomoc();
                    ldr.doPliku();
                    break;
                }
                case "dodajS" :
                {
                    lse.dodajSedziego(input.next());
                    lse.pomoc();
                    lse.doPliku();
                    break;
                }
                case "usunD" :
                {
                    ldr.usunDruzyne(input.next());
                    ldr.pomoc();
                    ldr.doPliku();
                    break;
                }
                case "usunS" :
                {
                    lse.usunSedziego(input.next());
                    lse.pomoc();
                    lse.doPliku();
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
                    ldr.wyswietlWyniki(input.next());
                    break;
                }
                case "end" :
                {
                    tabw.doPliku();
                    ldr.doPliku();
                    lse.doPliku();
                    i = 0;
                }
           }
        }
        input.close();
    }
}
