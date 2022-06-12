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
                    break;
                }
                case "dodajD" :
                {
                    ldr.dodajDruzyne(sc.next());
                    break;
                }
                case "dodajS" :
                {
                    lse.dodajSedziego(sc.next());
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
                case "pokazD" :
                {
                    ldr.wyswietl();
                    break;
                }
                case "pokazS" :
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
                case "listaDoPliku" :
                {
                    ldr.listaDoPliku();
                    lse.listaDoPliku();
                    tabw.listaDoPliku();
                    break;
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
