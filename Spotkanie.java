import java.io.Serializable;

public class Spotkanie implements Serializable
{
    private Druzyna druzyna1, druzyna2;
    private Sedzia sedzia1, sedzia2, sedzia3;
    private String sport;
    private String zwyciezca;
    //konstruktor rozgrywek "Dwa Ognie" oraz "Przeciaganie Liny"
    public Spotkanie(Druzyna druzyna1, Druzyna druzyna2, String sport, Sedzia sedzia1, String zwyciezca)
    {  
        this.druzyna1 = druzyna1;
        this.druzyna2 = druzyna2;
        this.sedzia1 = sedzia1;
        this.sport = sport;
        this.zwyciezca = zwyciezca;
    }
    //kosntruktor rozgrywki "Siatkowka"
    public Spotkanie(Druzyna druzyna1, Druzyna druzyna2, Sedzia sedzia1, Sedzia pomocniczy1, Sedzia pomocniczy2, String sport, String zwyciezca)
    {
        this.druzyna1 = druzyna1;
        this.druzyna2 = druzyna2;
        this.sedzia1 = sedzia1;
        sedzia2 = pomocniczy1;
        sedzia3 = pomocniczy2;
        this.sport = sport;
        this.zwyciezca = zwyciezca;
    }
    //zwrocenie obiektu druzyny 1
    public Druzyna getDruzyna1()
    {   
        return this.druzyna1;
    }
    //zwrocenie obiektu druzyny 2
    public Druzyna getDruzyna2()
    {   
        return this.druzyna2;
    }
    //zwrocenie obiektu sedzi 1
    public Sedzia getSedzia1()
    {   //zwrocenie obiektu sedzi
        return this.sedzia1;
    }
    //zwrocenie obiektu sedzi pomocniczego 1
    public Sedzia getSedzia2()
    {   
        return this.sedzia2;
    }
    //zwrocenie obiektu sedzi pomocniczego 2
    public Sedzia getSedzia3()
    {   
        return this.sedzia3;
    }
    //zwrocenie nazwy rozgrywki
    public String getSport()
    {   
        return sport;
    }
    //zwrocenie nazwy zwyciezcy
    public String getZwyciezca()
    {   
        return zwyciezca;
    }
    
}
