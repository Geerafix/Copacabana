import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Final extends Polfinal {

    protected  Druzyna[] tablicaDruzynFinaluSiatkowki = new Druzyna [2];
    protected  Druzyna[] tablicaDruzynFinaluDwochOgni = new Druzyna [2];
    protected  Druzyna[] tablicaDruzynFinaluPrzeciaganiaLiny = new Druzyna [2];

    private TabelaWynikow spotkaniaFinalu = new TabelaWynikow ();

    protected int[] wynikFinaluSiatkowki = new int [2];
    protected int[] wynikFinaluDwochOgni = new int [2];
    protected int[] wynikFinaluPrzeciaganiaLiny = new int [2];

    //konstruktor, parametrem jest obiekt klasy ListaDruzyn, ktora wywoluje konstruktor klasy Polfinal
    Final (ListaDruzyn listaDruzyn)
    {
        super(listaDruzyn);
        int miejsceTablicy = 0;

        for (int i=0; i<4; i++)
        {
            // problem gdy wynik jest 0 2 2 2 dla druzyn, druga druzyna z 2 punktami zostanie pominieta
            if (wynikiPolfinaluDwochOgni[i] >= 2) 
            {
                this.tablicaDruzynFinaluDwochOgni[miejsceTablicy] = this.tablicaDruzynPolfinaluDwochOgni [i];
                miejsceTablicy = 1;
            }
        }

        miejsceTablicy = 0;

        for (int i=0; i<4; i++)
        {
            if (wynikiPolfinaluSiatkowki[i] >= 2) 
            {
                this.tablicaDruzynFinaluSiatkowki[miejsceTablicy] = this.tablicaDruzynPolfinaluSiatkowki [i];
                miejsceTablicy = 1;
            }
        }
        
        miejsceTablicy = 0;

        for (int i=0; i<4; i++)
        {
            if (wynikiPolfinaluPrzeciaganiaLiny[i] >= 2)
            {
                this.tablicaDruzynFinaluPrzeciaganiaLiny[miejsceTablicy] = this.tablicaDruzynPolfinaluPrzeciaganiaLiny [i];
                miejsceTablicy = 1;
            }
        }
    }
    /*
    symulacja rozgrywek w finale jako parametr przyjmujaca obiekt klasy ListaSedziow
    ktora jest wykorzystywana do symulacji polfinalu (w klasie bazowej) oraz do symulacji finalu
    */

    void Symuluj (ListaSedziow listaSedziow) throws IOException {
        super.Symuluj(listaSedziow);

        Random symulacja = new Random();
        int zwyciezca, symSedzia;
        Sedzia sedzia, sedziaPomocniczy1, sedziaPomocniczy2;
        Spotkanie spotkanie;

        for(int i=0; i<2; i++)
        {
            wynikFinaluDwochOgni[i] = 0;
        }
        for(int i=0; i<2; i++)
        {
            wynikFinaluSiatkowki[i] = 0;
        }
        for(int i=0; i<2; i++)
        {
            wynikFinaluPrzeciaganiaLiny[i] = 0;
        }

        for (int i=0; i<1; i++)
        {
            for(int j=i+1; j<2; j++)
            {
            zwyciezca = symulacja.nextInt(2);
            symSedzia = symulacja.nextInt(listaSedziow.size()+1);
            sedzia = listaSedziow.getSedzia(symSedzia);

            if (zwyciezca == 0)
                {
                    wynikiPolfinaluDwochOgni[i]++;
                    spotkanie = new Spotkanie(tablicaDruzynFinaluDwochOgni[i],
                     tablicaDruzynFinaluDwochOgni[j],
                     "dwa_ognie",
                      sedzia,
                       tablicaDruzynFinaluDwochOgni[i].getDruzyna() );
                }
                else 
                {
                    wynikiPolfinaluDwochOgni[j]++;
                    spotkanie = new Spotkanie(tablicaDruzynFinaluDwochOgni[i],
                     tablicaDruzynFinaluDwochOgni[j],
                     "dwa_ognie",
                      sedzia,
                       tablicaDruzynFinaluDwochOgni[j].getDruzyna() );
                }

            spotkaniaFinalu.dodajSpotkanie(spotkanie);
            }
        }

        for (int i=0; i<1; i++)
        {
            for(int j=i+1; j<2; j++)
            {
                zwyciezca = symulacja.nextInt(2);
                symSedzia = symulacja.nextInt(listaSedziow.size()+1);
                sedzia = listaSedziow.getSedzia(symSedzia);

                if (zwyciezca == 0)
                {
                    wynikFinaluPrzeciaganiaLiny[i]++;
                    spotkanie = new Spotkanie(tablicaDruzynFinaluPrzeciaganiaLiny[i],
                     tablicaDruzynFinaluPrzeciaganiaLiny[j],
                     "przeciaganie_liny",
                      sedzia,
                       tablicaDruzynFinaluPrzeciaganiaLiny[i].getDruzyna() );
                }
                else 
                {
                    wynikFinaluPrzeciaganiaLiny[j]++;
                    spotkanie = new Spotkanie(tablicaDruzynFinaluPrzeciaganiaLiny[i],
                     tablicaDruzynFinaluPrzeciaganiaLiny[j],
                     "przeciaganie_liny",
                      sedzia,
                       tablicaDruzynFinaluPrzeciaganiaLiny[j].getDruzyna() );
                }

                
                

                spotkaniaFinalu.dodajSpotkanie(spotkanie);
            }
        }

        for (int i=0; i<1; i++)
        {
            for(int j=i+1; j<2; j++)
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
                    spotkanie = new Spotkanie(tablicaDruzynFinaluSiatkowki[i],
                     tablicaDruzynFinaluSiatkowki[j],
                      sedzia,
                       sedziaPomocniczy1,
                        sedziaPomocniczy2,
                        "siatkowka",
                         tablicaDruzynFinaluSiatkowki[i].getDruzyna() );
                }
                else
                {
                    wynikiPolfinaluSiatkowki[j]++;
                    spotkanie = new Spotkanie(tablicaDruzynFinaluSiatkowki[i],
                     tablicaDruzynFinaluSiatkowki[j],
                      sedzia,
                       sedziaPomocniczy1,
                        sedziaPomocniczy2,
                        "siatkowka",
                         tablicaDruzynFinaluSiatkowki[j].getDruzyna() );
                }
               

                spotkaniaFinalu.dodajSpotkanie(spotkanie);  
            }
            
        }
    }
    // get zwraca spotkania finalu typu TabelaWynikow
    public TabelaWynikow getspotkaniaFinalu ()
    {
        return this.spotkaniaFinalu;
    }
      // get zwraca tablice druzyn, ktore zakwalifikowaly sie do finalu siatkowki
    public Druzyna[] gettablicaDruzynFinaluSiatkowki ()
    {
        return this.tablicaDruzynFinaluSiatkowki;
    }
      // get zwraca tablice druzyn, ktore zakwalifikowaly sie do finalu dwoch ogni
    public Druzyna[] gettablicaDruzynFinaluDwochOgni ()
    {
        return this.tablicaDruzynFinaluDwochOgni;
    }
      // get zwraca tablice druzyn, ktore zakwalifikowaly sie do finalu przeciagania liny
    public Druzyna[] gettablicaDruzynFinaluPrzeciaganiaLiny ()
    {
        return this.tablicaDruzynFinaluPrzeciaganiaLiny;
    }
}