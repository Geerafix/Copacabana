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
        Final fin = new Final(ldr);
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
                +"\n\nDostepne opcje:"
                +"\n'teams' - Zarzadzanie druzynami\n"
                +"'refs' - Zarzadzanie sedziami\n"
                +"'matches' - Organizacja spotkan\n"
                +"'sim' - Symulacja polfinalu i finalu dla aktualnego stanu listy druzyn\n"
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
                +"'clear' - Zerowanie wszystkich wynikow wszystkich druzyn\n"
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
                +"\n'fire' - Tworzenie nowego meczu dwoch ogni"
                +"\n'line' - Tworzenie nowego meczu przeciagania liny"
                +"\n'delmatches' - Usuwanie spotkania o podanym indeksie"
                +"\n'back' - Powrot do wszystkich opcji"
                +"\n> ");
            }
            if(i==5)
            {
                System.out.print("> ");
            }
            if(i==6)
            {
                System.out.print("--Symulacja finalow--"+"\nPo wybraniu odpowiedniej opcji, system przenalizuje dotychczasowe wyniki druzyn "
                +"\nw danej konkurencji i wybierze cztery druzyny z najwieksza punktacja, ktore przejda do polfinalu,"
                +"\ngdzie zostana wylonione dwie, ktore przejda do finalu."
                +"\n\n'simball' - Symulacja finalow siatkowki"
                +"\n'simfire' - Symulacja finalow dwoch ogni"
                +"\n'simline' - Symulacja finalow przeciagania liny"
                +"\n'back' - Powrot do wszystkich opcji");
                System.out.print("\n> ");
                i=5;
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
                case "sim" :
                {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    i=6;
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
                    String dru1 = input.next();
                    ldr.czyZawiera(dru1);
                    Druzyna dr1 = new Druzyna(dru1);
                    System.out.print("Prosze wpisac druga druzyne spotkania"+"\n> ");
                    String dru2 = input.next();
                    ldr.czyZawiera(dru2);           
                    Druzyna dr2 = new Druzyna(dru2);
                    System.out.print("Prosze wpisac glownego sedziego spotkania"+"\n> ");
                    String se1 = input.next();
                    lse.czyZawiera(se1);
                    Sedzia sedzia = new Sedzia(se1);
                    System.out.print("Prosze wpisac pierwszego sedziego pomocniczego spotkania"+"\n> ");
                    String se2 = input.next();
                    lse.czyZawiera(se2);
                    Sedzia pom1 = new Sedzia(se2);
                    System.out.print("Prosze wpisac drugiego sedziego pomocniczego spotkania"+"\n> ");
                    String se3 = input.next();
                    lse.czyZawiera(se3);
                    Sedzia pom2 = new Sedzia(se3);
                    System.out.print("Prosze wpisac zwycieska druzyne spotkania"+"\n> ");
                    String win = input.next();
                    ldr.czyZawiera(win);
                    String zwyciezca = win;
                    Siatkowka spotkanie = new Siatkowka(dr1, dr2, sedzia, pom1, pom2, "Siatkowka", zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "siatkowka");
                    tabw.doPliku();
                    ldr.doPliku();
                    break;
                }
                case "fire" :
                {
                    System.out.print("Prosze wpisac pierwsza druzyne spotkania"+"\n> ");
                    String dru1 = input.next();
                    ldr.czyZawiera(dru1);
                    Druzyna dr1 = new Druzyna(dru1);
                    System.out.print("Prosze wpisac druga druzyne spotkania"+"\n> ");   
                    String dru2 = input.next();
                    ldr.czyZawiera(dru2);   
                    Druzyna dr2 = new Druzyna(dru2);
                    System.out.print("Prosze wpisac glownego sedziego spotkania"+"\n> ");
                    String se1 = input.next();
                    lse.czyZawiera(se1);
                    Sedzia sedzia = new Sedzia(se1);
                    System.out.print("Prosze wpisac zwycieska druzyne spotkania"+"\n> ");
                    String win = input.next();
                    ldr.czyZawiera(win);
                    String zwyciezca = win;
                    DwaOgnie spotkanie = new DwaOgnie(dr1, dr2, "Dwa ognie", sedzia, zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "dwaOgnie");
                    tabw.doPliku();
                    ldr.doPliku();
                    break;
                }
                case "line" :
                {
                    System.out.print("Prosze wpisac pierwsza druzyne spotkania"+"\n> ");
                    String dru1 = input.next();
                    ldr.czyZawiera(dru1);
                    Druzyna dr1 = new Druzyna(dru1);
                    System.out.print("Prosze wpisac druga druzyne spotkania"+"\n> ");   
                    String dru2 = input.next();
                    ldr.czyZawiera(dru2);                
                    Druzyna dr2 = new Druzyna(dru2);
                    System.out.print("Prosze wpisac glownego sedziego spotkania"+"\n> ");
                    String se1 = input.next();
                    lse.czyZawiera(se1);
                    Sedzia sedzia = new Sedzia(se1);
                    System.out.print("Prosze wpisac zwycieska druzyne spotkania"+"\n> ");
                    String win = input.next();
                    ldr.czyZawiera(win);
                    String zwyciezca = win;
                    PrzeciaganieLiny spotkanie = new PrzeciaganieLiny(dr1, dr2, "Przeciaganie liny", sedzia, zwyciezca);
                    tabw.dodajSpotkanie(spotkanie);
                    ldr.dodajWynik(zwyciezca, "przeciaganieLiny");
                    tabw.doPliku();
                    ldr.doPliku();
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
                case "delmatches" :
                {
                    if(tabw.czyPusta() == true)
                    {
                        i=5;
                        System.out.println("Lista spotkan jest pusta");
                    }
                    else
                    {
                        System.out.print("Prosze podac indeks spotkania do usuniecia"+"\n> ");
                        tabw.usunSpotkanie(input.nextInt());
                        tabw.doPliku();
                        ldr.pomoc();
                        ldr.doPliku();
                    }
                    break;
                }
                case "score" :
                {
                    i=5;
                    System.out.print("Prosze podac nazwe druzyny ktorej wyniki ma przedstawic system"+"\n> ");
                    ldr.wyswietlWyniki(input.next());
                    break;
                }
                case "clear" :
                {
                    ldr.zeruj();
                    ldr.pomoc();
                    ldr.doPliku();
                    break;
                }
                case "simball" :
                {
                    i=5;
                    fin.Symuluj(lse);
                    System.out.println("Druzyny polfinalu siatkowki: ");
                    fin.tablicaDruzynPolfinaluSiatkowki();
                    System.out.println("Druzyny finalu siatkowki: ");
                    fin.tablicaDruzynFinaluSiatkowki();
                    break;
                }
                case "simfire" :
                {
                    i=5;
                    fin.Symuluj(lse);
                    System.out.println("Druzyny polfinalu dwoch ogni: ");
                    fin.tablicaDruzynPolfinaluDwochOgni();
                    System.out.println("Druzyny finalu dwoch ogni: ");
                    fin.tablicaDruzynFinaluDwochOgni();
                    break;
                }
                case "simline" :
                {
                    i=5;
                    fin.Symuluj(lse);
                    System.out.println("Druzyny polfinalu przeciagania liny: ");
                    fin.tablicaDruzynPolfinaluPrzeciaganiaLiny();
                    System.out.println("Druzyny finalu przeciagania liny: ");
                    fin.tablicaDruzynFinaluPrzeciaganiaLiny();
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