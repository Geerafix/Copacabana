import java.util.ArrayList;
import java.util.Random;

public class Polfinal {
    public  Druzyna tablicaDruzynPolfinaluSiatkowki = new Druzyna [4];
    public  Druzyna tablicaDruzynPolfinaluDwochOgni = new Druzyna [4];
    public  Druzyna tablicaDruzynPolfinaluPrzeciaganiaLiny = new Druzyna [4];

    public TabelaWynikow spotkaniaPolfinalu = new TabelaWynikow ();

    public int[] wynikiPolfinaluSiatkowki = new int [4];
    public int[] wynikiPolfinaluDwochOgni = new int [4];
    public int[] wynikiPolfinaluPrzeciaganiaLiny = new int [4];

    Polfinal (ListaDruzyn listaDruzyn)
    {
        Druzyna pobranaDruzyna;

        int wynikDruzyny;
        int wyniki[] = new int[] {0,0,0,0};

        for (int i=0; i!=listaDruzyn.size(); i++)
        {
            pobranaDruzyna = listaDruzyn.getDruzyna(i);
            wynikDruzyny = pobranaDruzyna.getWynikSiatkowka();

            for(int j=0; j<4; j++)
            {
                if (wynikDruzyny > wyniki[j])
                {
                    wyniki[j] = wynikDruzyny;
                    tablicaDruzynPolfinaluSiatkowki[j] = pobranaDruzyna;
                    break;
                }
            }
        }

        for(int i=0; i<4; i++)
        {
            wyniki[i] = 0;
        }

        for (int i=0; i!=listaDruzyn.size(); i++)
        {
            pobranaDruzyna = listaDruzyn.getDruzyna(i);
            wynikDruzyny = pobranaDruzyna.getWynikPrzeciaganieLiny();

            for(int j=0; j<4; j++)
            {
                if (wynikDruzyny > wyniki[j])
                {
                    wyniki[j] = wynikDruzyny;
                    tablicaDruzynPolfinaluPrzeciaganiaLiny[j] = pobranaDruzyna;
                    break;
                }
            }
        }
        for(int i=0; i<4; i++)
        {
            wyniki[i] = 0;
        }

        for (int i=0; i!=listaDruzyn.size(); i++)
        {
            pobranaDruzyna = listaDruzyn.getDruzyna(i);
            wynikDruzyny = pobranaDruzyna.getWynikDwochOgni();

            for(int j=0; j<4; j++)
            {
                if (wynikDruzyny > wyniki[j])
                {
                    wyniki[j] = wynikDruzyny;
                    tablicaDruzynPolfinaluDwochOgni[j] = pobranaDruzyna;
                    break;
                }
            }
        }

    }

    void Symuluj (ListaSedziow listaSedziow) {

        Random symulacja = new Random();
        int zwyciezca, symSedzia;
        Sedzia sedzia;
        Spotkanie spotkanie;

        for(int i=0; i<4; i++)
        {
            wynikiPolfinaluDwochOgni[i] = 0;
        }
        for(int i=0; i<4; i++)
        {
            wynikiPolfinaluSiatkowki[i] = 0;
        }
        for(int i=0; i<4; i++)
        {
            wynikiPolfinaluPrzeciaganiaLiny[i] = 0;
        }

        for (int i=0; i<3; i++)
        {
            for(int j=i+1; j<4 j++)
            {
            zwyciezca = symulacja.nextInt(2);
            symSedzia = symulacja.nextInt(listaSedziow.size()+1);
            sedzia = listaSedziow.getSedzia(symSedzia);

            wynikiPolfinaluDwochOgni[zwyciezca]++;

            spotkanie = new Spotkanie(tablicaDruzynPolfinaluDwochOgni[i], tablicaDruzynPolfinaluDwochOgni[j], sedzia, "dwa_ognie");
            

            spotkaniaPolfinalu.dodajSpotkanie(spotkanie);
            }
        }

        for (int i=0; i<3; i++)
        {
            for(int j=i+1; j<4 j++)
            {
                zwyciezca = symulacja.nextInt(2);
                symSedzia = symulacja.nextInt(listaSedziow.size()+1);
                sedzia = listaSedziow.getSedzia(symSedzia);

                wynikiPolfinaluPrzeciaganiaLiny[zwyciezca]++;

                spotkanie = new Spotkanie(tablicaDruzynPolfinaluPrzeciaganiaLiny[i], tablicaDruzynPolfinaluPrzeciaganiaLiny[j], sedzia, "przeciaganie_liny");
                

                spotkaniaPolfinalu.dodajSpotkanie(spotkanie);
            }
        }

        for (int i=0; i<3; i++)
        {
            for(int j=i+1; j<4 j++)
            {
              zwyciezca = symulacja.nextInt(2);
                symSedzia = symulacja.nextInt(listaSedziow.size()+1);
                sedzia = listaSedziow.getSedzia(symSedzia);

                wynikiPolfinaluSiatkowki[zwyciezca]++;

                spotkanie = new Spotkanie(tablicaDruzynPolfinaluSiatkowki[i], tablicaDruzynPolfinaluSiatkowki[j], sedzia, "siatkowka");

                spotkaniaPolfinalu.dodajSpotkanie(spotkanie);  
            }
            
        }
    }
}