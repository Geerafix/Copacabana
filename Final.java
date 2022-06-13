import java.util.ArrayList;
import java.util.Random;

public class Final extends Polfinal {

    public  Druzyna tablicaDruzynFinaluSiatkowki = new Druzyna [2];
    public  Druzyna tablicaDruzynFinaluDwochOgni = new Druzyna [2];
    public  Druzyna tablicaDruzynFinaluPrzeciaganiaLiny = new Druzyna [2];

    public TabelaWynikow spotkaniaFinalu = new TabelaWynikow ();

    public int[] wynikFinaluSiatkowki = new int [2];
    public int[] wynikFinaluDwochOgni = new int [2];
    public int[] wynikFinaluPrzeciaganiaLiny = new int [2];

    Final (ListaDruzyn listaDruzyn)
    {
        int miejsceTablicy = 0;
        super(listaDruzyn);
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

    void Symuluj (ListaSedziow listaSedziow) {

        Random symulacja = new Random();
        int zwyciezca, symSedzia;
        Sedzia sedzia;

        for(int i=0; i<2; i++)
        {
            wynikFinaluDwochOgni[i] = 0;
        }
        for(int i=0; i<2; i++)
        {
            wynikiFinaluSiatkowki[i] = 0;
        }
        for(int i=0; i<2; i++)
        {
            wynikFinaluPrzeciaganiaLiny[i] = 0;
        }

        zyciezca = symulacja.nextInt(2);
        symSedzia = symulacja.nextInt(listaSedziow.size()+1);
        sedzia = listaSedziow.getSedzia(symSedzia);

        wynikFinaluDwochOgni[zwyciezca] = 1;

        spotkanie = new Spotkanie(tablicaDruzynFinaluDwochOgni[0], tablicaDruzynFinaluDwochOgni[1], sedzia, "dwa_ognie");
               
        spotkaniaFinalu.dodajSpotkanie(spotkanie);

        zyciezca = symulacja.nextInt(2);
        symSedzia = symulacja.nextInt(listaSedziow.size()+1);
        sedzia = listaSedziow.getSedzia(symSedzia);

        wynikFinaluPrzeciaganiaLiny[zwyciezca] = 1;

        spotkanie = new Spotkanie(tablicaDruzynFinaluPrzeciaganiaLiny[0], tablicaDruzynFinaluPrzeciaganiaLiny[1], sedzia, "przeciaganie_liny");
                
        spotkaniaFinalu.dodajSpotkanie(spotkanie);

        zyciezca = symulacja.nextInt(2);
        symSedzia = symulacja.nextInt(listaSedziow.size()+1);
        sedzia = listaSedziow.getSedzia(symSedzia);

        wynikFinaluSiatkowki[zwyciezca] = 1;

        spotkanie = new Spotkanie(tablicaDruzynFinaluSiatkowki[0], tablicaDruzynFinaluSiatkowki[1], sedzia, "siatkowka");
                
        spotkaniaFinalu.dodajSpotkanie(spotkanie);
    }
}