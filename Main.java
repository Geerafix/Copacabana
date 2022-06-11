import java.util.Scanner;
import javax.swing.JFrame;

public class Main 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        ListaDruzyn ldr = new ListaDruzyn();
        ListaSedziow lse = new ListaSedziow();
        TabelaWynikow tabw = new TabelaWynikow();

        ldr.zPliku();
        lse.zPliku();
        int i = 1;

        MenuGlowne okno = new MenuGlowne();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
        /*
        while(i == 1)
        {
            switch(sc.next())
            {
                case "siat" :
                {
                    Druzyna dr1 = new Druzyna(sc.next());                 
                    Druzyna dr2 = new Druzyna(sc.next());
                    String sport = sc.next();
                    Sedzia sedzia = new Sedzia(sc.next());
                    Sedzia pom1 = new Sedzia(sc.next());
                    Sedzia pom2 = new Sedzia(sc.next());
                    Spotkanie spotkanie = new Spotkanie(dr1, dr2, sedzia, pom1, pom2, sport);
                    tabw.dodajSpotkanie(spotkanie, "siatkowka");
                    break;
                }
                case "dOgnie" :
                {
                    Druzyna dr1 = new Druzyna(sc.next());                 
                    Druzyna dr2 = new Druzyna(sc.next());
                    String sport = sc.next();
                    Sedzia sedzia = new Sedzia(sc.next());
                    Spotkanie spotkanie = new Spotkanie(dr1, dr2, sport, sedzia);
                    tabw.dodajSpotkanie(spotkanie, "dwaOgnie");
                    break;
                }
                case "pLiny" :
                {
                    Druzyna dr1 = new Druzyna(sc.next());                 
                    Druzyna dr2 = new Druzyna(sc.next());
                    String sport = sc.next();
                    Sedzia sedzia = new Sedzia(sc.next());
                    Spotkanie spotkanie = new Spotkanie(dr1, dr2, sport, sedzia);
                    tabw.dodajSpotkanie(spotkanie, "przeciaganieLiny");
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
                case "end" :
                {
                    i = 0;
                }
           }
        }
        */
    }

}
