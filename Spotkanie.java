import java.io.Serializable;

public class Spotkanie implements Serializable
{
    private Druzyna druzyna1, druzyna2;
    private Sedzia sedzia1, sedzia2, sedzia3;
    private String sport;
    private String zwyciezca;

    public Spotkanie(Druzyna druzyna1, Druzyna druzyna2, String sport, Sedzia sedzia1, String zwyciezca)
    {   //konstruktor rozgrywek 'dwaOgnie' oraz 'przeciaganieLiny'
        this.druzyna1 = druzyna1;
        this.druzyna2 = druzyna2;
        this.sedzia1 = sedzia1;
        this.sport = sport;
        this.zwyciezca = zwyciezca;
    }

    public Spotkanie(Druzyna druzyna1, Druzyna druzyna2, Sedzia sedzia1, Sedzia pomocniczy1, Sedzia pomocniczy2, String sport, String zwyciezca)
    {   //kosntruktor rozgrywki 'siatkowka'
        this.druzyna1 = druzyna1;
        this.druzyna2 = druzyna2;
        this.sedzia1 = sedzia1;
        sedzia2 = pomocniczy1;
        sedzia3 = pomocniczy2;
        this.sport = sport;
        this.zwyciezca = zwyciezca;
    }
   
    public Druzyna getDruzyna1()
    {   //zwrocenie obiektu druzyny 1
        return this.druzyna1;
    }

    public Druzyna getDruzyna2()
    {   //zwrocenie obiektu druzyny 2
        return this.druzyna2;
    }

    public Sedzia getSedzia1()
    {   //zwrocenie obiektu sedzi
        return this.sedzia1;
    }

    public Sedzia getSedzia2()
    {   //zwrocenie obiektu sedzi pomocniczego 1
        return this.sedzia2;
    }

    public Sedzia getSedzia3()
    {   //zwrocenie obiektu sedzi pomocniczego 2
        return this.sedzia3;
    }

    public String getSport()
    {   //zwrocenie nazwy rozgrywki
        return sport;
    }

    public String getZwyciezca()
    {   //zwrocenie nazwy zwyciezcy
        return zwyciezca;
    }
    
}
