import java.util.ArrayList;
import java.util.Random;

public class Polfinal {
    public  Druzyna tablicaDruzynPolfinaluSiatkowki = new Druzyna [4];
    public  Druzyna tablicaDruzynPolfinaluDwochOgni = new Druzyna [4];
    public  Druzyna tablicaDruzynPolfinaluPrzeciaganiaLiny = new Druzyna [4];
    public TabelaWynikow spotkaniaPolfinalu = new TabelaWynikow ();

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

        zyciezca = symulacja.nextInt(2);
        symSedzia = symulacja.nextInt(listaSedziow.size()+1);
        sedzia = listaSedziow.getSedzia(symSedzia);

        spotkanie = new Spotkanie(tablicaDruzynPolfinaluDwochOgni[0], tablicaDruzynPolfinaluDwochOgni[3], sedzia, dwa_ognie);
        

        spotkaniaPolfinalu.dodajSpotkanie(spotkanie);
    }
}
