import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;

public class Polfinal {
    protected Druzyna[] tablicaDruzynPolfinaluSiatkowki = new Druzyna [4];
    protected  Druzyna[] tablicaDruzynPolfinaluDwochOgni = new Druzyna [4];
    protected Druzyna[] tablicaDruzynPolfinaluPrzeciaganiaLiny = new Druzyna [4];

    private TabelaWynikow spotkaniaPolfinalu = new TabelaWynikow ();

    protected int[] wynikiPolfinaluSiatkowki = new int [4];
    protected int[] wynikiPolfinaluDwochOgni = new int [4];
    protected int[] wynikiPolfinaluPrzeciaganiaLiny = new int [4];

    //konstruktor, parametrem jest obiekt klasy ListaDruzyn
    Polfinal (ListaDruzyn listaDruzyn)
    {
        Druzyna pobranaDruzyna;

        int wynikDruzyny;
        int wyniki[] = new int[] {-1, -1, -1, -1};

        for (int i=0; i!=listaDruzyn.size(); i++)
        {
            pobranaDruzyna = listaDruzyn.getDruzyna(i);
            wynikDruzyny = pobranaDruzyna.wynikSiatkowka();

            for(int j=0; j<4; j++)
            {
                if (wynikDruzyny > wyniki[j])
                {
                    wyniki[j] = wynikDruzyny;
                    this.tablicaDruzynPolfinaluSiatkowki[j] = pobranaDruzyna;
                    break;
                }
            }
        }

        for(int i=0; i<4; i++)
        {
            wyniki[i] = -1;
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
                    this.tablicaDruzynPolfinaluPrzeciaganiaLiny[j] = pobranaDruzyna;
                    break;
                }
            }
        }
        for(int i=0; i<4; i++)
        {
            wyniki[i] = -1;
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
                    this.tablicaDruzynPolfinaluDwochOgni[j] = pobranaDruzyna;
                    break;
                }
            }
        }

    }
    //symulacja rozgrywek w polfinale jako parametr przyjmujaca obiekt klasy ListaSedziow
    void Symuluj (ListaSedziow listaSedziow) throws IOException {

        double symulacja = Math.random();
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
            zwyciezca = (int)symulacja*2;
            symSedzia = (int)symulacja*listaSedziow.size();
            sedzia = listaSedziow.getSedzia(symSedzia);

            if (zwyciezca == 0)
                {
                    wynikiPolfinaluDwochOgni[i]++;
                    spotkanie = new Spotkanie(this.tablicaDruzynPolfinaluDwochOgni[i],
                     this.tablicaDruzynPolfinaluDwochOgni[j],
                     "dwa_ognie",
                      sedzia,
                       this.tablicaDruzynPolfinaluDwochOgni[i].getDruzyna() );
                }
                else 
                {
                    wynikiPolfinaluDwochOgni[j]++;
                    spotkanie = new Spotkanie(this.tablicaDruzynPolfinaluDwochOgni[i],
                     this.tablicaDruzynPolfinaluDwochOgni[j],
                     "dwa_ognie",
                      sedzia,
                       this.tablicaDruzynPolfinaluDwochOgni[j].getDruzyna() );
                }

            spotkaniaPolfinalu.dodajSpotkanie(spotkanie);
            }
        }

        for (int i=0; i<3; i++)
        {
            for(int j=i+1; j<4; j++)
            {
                zwyciezca = (int)symulacja*2;
                symSedzia = (int)symulacja*listaSedziow.size();
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
                zwyciezca = (int)symulacja*2;
                symSedzia = (int)symulacja*listaSedziow.size();
                sedzia = listaSedziow.getSedzia(symSedzia);
                symSedzia = (int)symulacja*listaSedziow.size();
                sedziaPomocniczy1 = listaSedziow.getSedzia(symSedzia);
                symSedzia = (int)symulacja*listaSedziow.size();
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
    // get zwraca spotkania polfinalu typu TabelaWynikow
    public TabelaWynikow getspotkaniaPolfinalu ()
    {
        return this.spotkaniaPolfinalu;
    }
    // get zwraca tablice druzyn, ktore zakwalifikowaly sie do polfinalu siatkowki
    public Druzyna[] gettablicaDruzynPolfinaluSiatkowki ()
    {
        return this.tablicaDruzynPolfinaluSiatkowki;
    }
      // get zwraca tablice druzyn, ktore zakwalifikowaly sie do polfinalu dwoch ogni
    public Druzyna[] gettablicaDruzynPolfinaluDwochOgni ()
    {
        return this.tablicaDruzynPolfinaluDwochOgni;
    }
      // get zwraca tablice druzyn, ktore zakwalifikowaly sie do polfinalu przeciagania liny
    public Druzyna[] gettablicaDruzynPolfinaluPrzeciaganiaLiny ()
    {
        return this.tablicaDruzynPolfinaluPrzeciaganiaLiny;
    }
}