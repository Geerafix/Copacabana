import java.util.ArrayList;
import java.util.Random;

public class Polfinal {
    public  Druzyna[] tablicaDruzynPolfinaluSiatkowki = new Druzyna [4];
    public  Druzyna[] tablicaDruzynPolfinaluDwochOgni = new Druzyna [4];
    public  Druzyna[] tablicaDruzynPolfinaluPrzeciaganiaLiny = new Druzyna [4];

    public TabelaWynikow spotkaniaPolfinalu = new TabelaWynikow ();

    public int[] wynikiPolfinaluSiatkowki = new int [4];
    public int[] wynikiPolfinaluDwochOgni = new int [4];
    public int[] wynikiPolfinaluPrzeciaganiaLiny = new int [4];

    //konstruktor, parametrem jest obiekt klasy ListaDruzyn
    Polfinal (ListaDruzyn listaDruzyn)
    {
        Druzyna pobranaDruzyna;

        int wynikDruzyny;
        int wyniki[] = new int[] {0,0,0,0};

        for (int i=0; i!=listaDruzyn.size(); i++)
        {
            pobranaDruzyna = listaDruzyn.getDruzyna(i);
            wynikDruzyny = pobranaDruzyna.wynikSiatkowka();

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
            wynikDruzyny = pobranaDruzyna.wynikPrzeciaganieLiny();

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
            wynikDruzyny = pobranaDruzyna.wynikDwaOgnie();

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
    //symulacja rozgrywek w polfinale jako parametr przyjmujaca obiekt klasy ListaSedziow
    void Symuluj (ListaSedziow listaSedziow) {

        Random symulacja = new Random();
        int zwyciezca, symSedzia;
        Sedzia sedzia, sedziaPomocniczy1, sedziaPomocniczy2;
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
            for(int j=i+1; j<4; j++)
            {
            zwyciezca = symulacja.nextInt(2);
            symSedzia = symulacja.nextInt(listaSedziow.size()+1);
            sedzia = listaSedziow.getSedzia(symSedzia);

            if (zwyciezca == 0)
                {
                    wynikiPolfinaluDwochOgni[i]++;
                    spotkanie = new Spotkanie(tablicaDruzynPolfinaluDwochOgni[i],
                     tablicaDruzynPolfinaluDwochOgni[j],
                     "przeciaganie_liny",
                      sedzia,
                       tablicaDruzynPolfinaluDwochOgni[i].getDruzyna() );
                }
                else 
                {
                    wynikiPolfinaluDwochOgni[j]++;
                    spotkanie = new Spotkanie(tablicaDruzynPolfinaluDwochOgni[i],
                     tablicaDruzynPolfinaluDwochOgni[j],
                     "przeciaganie_liny",
                      sedzia,
                       tablicaDruzynPolfinaluDwochOgni[j].getDruzyna() );
                }

            spotkaniaPolfinalu.dodajSpotkanie(spotkanie);
            }
        }

        for (int i=0; i<3; i++)
        {
            for(int j=i+1; j<4; j++)
            {
                zwyciezca = symulacja.nextInt(2);
                symSedzia = symulacja.nextInt(listaSedziow.size()+1);
                sedzia = listaSedziow.getSedzia(symSedzia);

                if (zwyciezca == 0)
                {
                    wynikiPolfinaluPrzeciaganiaLiny[i]++;
                    spotkanie = new Spotkanie(tablicaDruzynPolfinaluPrzeciaganiaLiny[i],
                     tablicaDruzynPolfinaluPrzeciaganiaLiny[j],
                     "przeciaganie_liny",
                      sedzia,
                       tablicaDruzynPolfinaluPrzeciaganiaLiny[i].getDruzyna() );
                }
                else 
                {
                    wynikiPolfinaluPrzeciaganiaLiny[j]++;
                    spotkanie = new Spotkanie(tablicaDruzynPolfinaluPrzeciaganiaLiny[i],
                     tablicaDruzynPolfinaluPrzeciaganiaLiny[j],
                     "przeciaganie_liny",
                      sedzia,
                       tablicaDruzynPolfinaluPrzeciaganiaLiny[j].getDruzyna() );
                }

                
                

                spotkaniaPolfinalu.dodajSpotkanie(spotkanie);
            }
        }

        for (int i=0; i<3; i++)
        {
            for(int j=i+1; j<4; j++)
            {
              zwyciezca = symulacja.nextInt(2);
                symSedzia = symulacja.nextInt(listaSedziow.size()+1);
                sedzia = listaSedziow.getSedzia(symSedzia);
                symSedzia = symulacja.nextInt(listaSedziow.size()+1);
                sedziaPomocniczy1 = listaSedziow.getSedzia(symSedzia);
                symSedzia = symulacja.nextInt(listaSedziow.size()+1);
                sedziaPomocniczy2 = listaSedziow.getSedzia(symSedzia);


                if(zwyciezca == 0)
                {
                    wynikiPolfinaluSiatkowki[i]++;
                    spotkanie = new Spotkanie(tablicaDruzynPolfinaluSiatkowki[i],
                     tablicaDruzynPolfinaluSiatkowki[j],
                      sedzia,
                       sedziaPomocniczy1,
                        sedziaPomocniczy2,
                        "siatkowka",
                         tablicaDruzynPolfinaluSiatkowki[i].getDruzyna() );
                }
                else
                {
                    wynikiPolfinaluSiatkowki[j]++;
                    spotkanie = new Spotkanie(tablicaDruzynPolfinaluSiatkowki[i],
                     tablicaDruzynPolfinaluSiatkowki[j],
                      sedzia,
                       sedziaPomocniczy1,
                        sedziaPomocniczy2,
                        "siatkowka",
                         tablicaDruzynPolfinaluSiatkowki[j].getDruzyna() );
                }
               

                spotkaniaPolfinalu.dodajSpotkanie(spotkanie);  
            }
            
        }
    }
}
