import java.util.ArrayList;
import java.util.Random;

public class Final extends Polfinal {

    public  Druzyna[] tablicaDruzynFinaluSiatkowki = new Druzyna [2];
    public  Druzyna[] tablicaDruzynFinaluDwochOgni = new Druzyna [2];
    public  Druzyna[] tablicaDruzynFinaluPrzeciaganiaLiny = new Druzyna [2];

    public TabelaWynikow spotkaniaFinalu = new TabelaWynikow ();

    public int[] wynikFinaluSiatkowki = new int [2];
    public int[] wynikFinaluDwochOgni = new int [2];
    public int[] wynikFinaluPrzeciaganiaLiny = new int [2];

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
                tablicaDruzynFinaluDwochOgni[miejsceTablicy] = tablicaDruzynPolfinaluDwochOgni [i];
                miejsceTablicy = 1;
            }
        }

        miejsceTablicy = 0;

        for (int i=0; i<4; i++)
        {
            if (wynikiPolfinaluSiatkowki[i] >= 2) 
            {
                tablicaDruzynFinaluSiatkowki[miejsceTablicy] = tablicaDruzynPolfinaluSiatkowki [i];
                miejsceTablicy = 1;
            }
        }
        
        miejsceTablicy = 0;

        for (int i=0; i<4; i++)
        {
            if (wynikiPolfinaluPrzeciaganiaLiny[i] >= 2)
            {
                tablicaDruzynFinaluPrzeciaganiaLiny[miejsceTablicy] = tablicaDruzynPolfinaluPrzeciaganiaLiny [i];
                miejsceTablicy = 1;
            }
        }
    }
    /*
    symulacja rozgrywek w finale jako parametr przyjmujaca obiekt klasy ListaSedziow
    ktora wykorzystuje do symulacji polfinalu (w klasie bazowej) oraz do symulacji finalu
    */

    void Symuluj (ListaSedziow listaSedziow) {
        super.Symuluj(listaSedziow);

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

        for (int i=0; i<1; i++)
        {
            for(int j=i+1; j<2; j++)
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
               

                spotkaniaFinalu.dodajSpotkanie(spotkanie);  
            }
            
        }
    }
}