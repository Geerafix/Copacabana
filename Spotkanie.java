public class Spotkanie 
{
    private Druzyna druzyna1, druzyna2;
    private Sedzia sedzia1, sedzia2, sedzia3;
    private String sport;
    private String zwyciezca;

    public Spotkanie(Druzyna druzyna1, Druzyna druzyna2, String sport, Sedzia sedzia1, String zwyciezca)
    {
        this.druzyna1 = druzyna1;
        this.druzyna2 = druzyna2;
        this.sedzia1 = sedzia1;
        this.sport = sport;
        this.zwyciezca = zwyciezca;
    }

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
   
    public Druzyna getDruzyna1()
    {
        return this.druzyna1;
    }

    public Druzyna getDruzyna2()
    {
        return this.druzyna2;
    }

    public Sedzia getSedzia1()
    {
        return this.sedzia1;
    }

    public Sedzia getSedzia2()
    {
        return this.sedzia2;
    }

    public Sedzia getSedzia3()
    {
        return this.sedzia3;
    }

    public String getSport()
    {
        return sport;
    }

    public String getZwyciezca()
    {
        return zwyciezca;
    }
}
