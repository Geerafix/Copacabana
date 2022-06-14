import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

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

        int wyniki[] = new int[] {0, 0};

        wyniki[0] = -1;
        wyniki[1] = -1;
        
        for (int i=0; i<4; i++)
        {
            for(int j=0; j<2; j++)
            {
                if (wynikiPolfinaluDwochOgni[i] > wyniki[j])
                {
                    wyniki[j] = wynikiPolfinaluDwochOgni[i];
                    this.tablicaDruzynFinaluDwochOgni[j] = this.tablicaDruzynPolfinaluDwochOgni[i];
                    break;
                }
            }
        }

        wyniki[0] = -1;
        wyniki[1] = -1;

        for (int i=0; i<4; i++)
        {
            for(int j=0; j<2; j++)
            {
                if (wynikiPolfinaluSiatkowki[i] > wyniki[j])
                {
                    wyniki[j] = wynikiPolfinaluSiatkowki[i];
                    this.tablicaDruzynFinaluSiatkowki[j] = this.tablicaDruzynPolfinaluSiatkowki[i];
                    break;
                }
            }
        }

        wyniki[0] = -1;
        wyniki[1] = -1;

        for (int i=0; i<4; i++)
        {
            for(int j=0; j<2; j++)
            {
                if (wynikiPolfinaluPrzeciaganiaLiny[i] > wyniki[j])
                {
                    wyniki[j] = wynikiPolfinaluPrzeciaganiaLiny[i];
                    this.tablicaDruzynFinaluPrzeciaganiaLiny[j] = this.tablicaDruzynPolfinaluPrzeciaganiaLiny[i];
                    break;
                }
            }
        }
    }
    /*
    symulacja rozgrywek w finale jako parametr przyjmujaca obiekt klasy ListaSedziow
    ktora jest wykorzystywana do symulacji polfinalu (w klasie bazowej) oraz do symulacji finalu
    */

    void Symuluj (ListaSedziow listaSedziow) throws IOException {
        super.Symuluj(listaSedziow);

        ThreadLocalRandom symulacja = ThreadLocalRandom.current();
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
            symSedzia = symulacja.nextInt(listaSedziow.size());
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
                symSedzia = symulacja.nextInt(listaSedziow.size());
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
                symSedzia = symulacja.nextInt(listaSedziow.size());
                sedzia = listaSedziow.getSedzia(symSedzia);
                symSedzia = symulacja.nextInt(listaSedziow.size());
                sedziaPomocniczy1 = listaSedziow.getSedzia(symSedzia);
                symSedzia = symulacja.nextInt(listaSedziow.size());
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

    public void tablicaDruzynFinaluSiatkowki()
    {
        for(int i = 0; i < tablicaDruzynFinaluSiatkowki.length; i++) {
            System.out.println(tablicaDruzynFinaluSiatkowki[i].getDruzyna()); 
        }
    }
    public void tablicaDruzynFinaluDwochOgni()
    {
        for(int i = 0; i < tablicaDruzynFinaluDwochOgni.length; i++) {
            System.out.println(tablicaDruzynFinaluDwochOgni[i].getDruzyna()); 
        }
    }
    public void tablicaDruzynFinaluPrzeciaganiaLiny()
    {
        for(int i = 0; i < tablicaDruzynFinaluPrzeciaganiaLiny.length; i++) {
            System.out.println(tablicaDruzynFinaluPrzeciaganiaLiny[i].getDruzyna()); 
        }
    }
}