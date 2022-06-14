import java.util.Scanner;
import javax.swing.JFrame;

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

        while(i!=0)
        {
            if(i==1)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("~~Plazowe Rozgrywki Kopakabana~~"
                +"\n\nDostepne opcje:"+"\n'teams' - Zarzadzanie Druzynami\n"
                +"'refs' - Zarzadzanie Sedziami\n"
                +"'matches' - Organizacja spotkan\n"
                +"'menu' - Graficzny Interfejs Uzytkownika (prototyp)\n"
                +"'end' - Wyjscie\n"
                +"> ");
            }
            if(i==2)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("--Wszystkie Druzyny--\n");
                ldr.wyswietl();
                System.out.print("\n'addteams' - Dodawanie druzyn\n"
                +"'delteams' - Usuwanie druzyn\n"
                +"'score' - Wyniki druzyn w zawodach\n"
                +"'back' - Powrot do wszystkich opcji\n"
                +"> ");
            }
            if(i==3)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("--Wszyscy Sedziowie--\n");
                lse.wyswietl();
                System.out.print("\n'addrefs' - Dodawanie sedziow\n"
                +"'delrefs' - Usuwanie sedziow\n"
                +"'back' - Powrot do wszystkich opcji\n"
                +"> ");
            }
            if(i==4)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("--Wszystkie Spotkania--\n");
                tabw.wyswietl();
                System.out.print("\n'ball' - Tworzenie nowego meczu siatkowki"
                +"\n'fire' - Tworzenie nowego meczu dwóch ogni"
                +"\n'line' - Tworzenie nowego meczu przeciagania liny"
                +"\n'sim' - Przeprowadzanie symulacji polfinalu i finalu dla aktualnego stanu listy druzyn"
                +"\n'back' - Powrot do wszystkich opcji"
                +"\n> ");
            }
            if(i==5)
            {
                System.out.print("> ");
            }
            switch(input.next())
            {
                case "menu" :
                {
                    MenuGlowne okno = new MenuGlowne();
                    okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    okno.setVisible(true);
                    break;
                }
                case "teams" :
                {
                    i=2;
                    break;
                }
                case "refs" :
                {
                    i=3;
                    break;
                }
                case "matches" :
                {
                    i=4;
                    break;
                }
                case "back" :
                { 
                    i=1;
                    break;
                }
                case "ball" :
                {
                    System.out.print("Prosze wpisac pierwsza druzyne spotkania"+"\n> ");
                    Druzyna dr1 = new Druzyna(input.next());
                    System.out.print("Prosze wpisac druga druzyne spotkania"+"\n> ");           
                    Druzyna dr2 = new Druzyna(input.next());
                    System.out.print("Prosze wpisac glownego sedziego spotkania"+"\n> ");
                    Sedzia sedzia = new Sedzia(input.next());
                    System.out.print("Prosze wpisac pierwszego sedziego pomocniczego spotkania"+"\n> ");
                    Sedzia pom1 = new Sedzia(input.next());
                    System.out.print("Prosze wpisac drugiego sedziego pomocniczego spotkania"+"\n> ");
                    Sedzia pom2 = new Sedzia(input.next());
                    System.out.print("Prosze wpisac zwycieska druzyne spotkania"+"\n> ");
                    String zwyciezca = input.next();
                    Siatkowka spotkanie = new Siatkowka(dr1, dr2, sedzia, pom1, pom2, "siatkowka", zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "siatkowka");
                    break;
                }
                case "fire" :
                {
                    System.out.print("Prosze wpisac pierwsza druzyne spotkania"+"\n> ");
                    Druzyna dr1 = new Druzyna(input.next());           
                    System.out.print("Prosze wpisac druga druzyne spotkania"+"\n> ");      
                    Druzyna dr2 = new Druzyna(input.next());
                    System.out.print("Prosze wpisac glownego sedziego spotkania"+"\n> ");
                    Sedzia sedzia = new Sedzia(input.next());
                    System.out.print("Prosze wpisac zwycieska druzyne spotkania"+"\n> ");
                    String zwyciezca = input.next();
                    DwaOgnie spotkanie = new DwaOgnie(dr1, dr2, "dwaOgnie", sedzia, zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "dwaOgnie");
                    break;
                }
                case "line" :
                {
                    System.out.print("Prosze wpisac pierwsza druzyne spotkania"+"\n> ");
                    Druzyna dr1 = new Druzyna(input.next()); 
                    System.out.print("Prosze wpisac druga druzyne spotkania"+"\n> ");                  
                    Druzyna dr2 = new Druzyna(input.next());
                    System.out.print("Prosze wpisac glownego sedziego spotkania"+"\n> ");
                    Sedzia sedzia = new Sedzia(input.next());
                    System.out.print("Prosze wpisac zwycieska druzyne spotkania"+"\n> ");
                    String zwyciezca = input.next();
                    PrzeciaganieLiny spotkanie = new PrzeciaganieLiny(dr1, dr2, "przeciaganieLiny", sedzia, zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "przeciaganieLiny");
                    break;
                }
                case "addteams" :
                {
                    System.out.print("Prosze podac nazwe druzyny do dodania"+"\n> ");
                    ldr.dodajDruzyne(input.next());
                    ldr.pomoc();
                    ldr.doPliku();
                    break;
                }
                case "addrefs" :
                {
                    System.out.print("Prosze podac imie sedziego do dodania"+"\n> ");
                    lse.dodajSedziego(input.next());
                    lse.pomoc();
                    lse.doPliku();
                    break;
                }
                case "delteams" :
                {
                    System.out.print("Prosze podac nazwe druzyny do usuniecia"+"\n> ");
                    ldr.usunDruzyne(input.next());
                    ldr.pomoc();
                    ldr.doPliku();
                    break;
                }
                case "delrefs" :
                {
                    System.out.print("Prosze podac imie sedziego do usuniecia"+"\n> ");
                    lse.usunSedziego(input.next());
                    lse.pomoc();
                    lse.doPliku();
                    break;
                }
                case "score" :
                {
                    i=5;
                    System.out.print("Prosze podac nazwe druzyny ktorej wyniki ma przedstawic system"+"\n> ");
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
