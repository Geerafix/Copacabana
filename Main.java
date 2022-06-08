import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        // ListaDruzyn l1 = new ListaDruzyn();
        // ListaSedziow ls1 = new ListaSedziow();
        // TabelaWynikow t1 = new TabelaWynikow();
        // Druzyna d1 = new Druzyna("Bulls");
        // Druzyna d2 = new Druzyna("Tigers");
        // Sedzia s1 = new Sedzia("MaciejK");
        // l1.dodajDruzyne(d1);
        // l1.dodajDruzyne(d2);
        // ls1.dodajSedziego(s1);

        // Spotkanie sp1 = new Spotkanie(d1, d2, s1, "dwaognie");
        // t1.dodajSpotkanie(sp1);
        // t1.wyswietl();

        ListaDruzyn l1 = new ListaDruzyn();
        l1.zPliku();
        l1.wyswietl();
        String s = sc.nextLine();

        
        



        
        
    }

}
