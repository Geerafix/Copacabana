import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class MenuOrganizacja extends JFrame implements ActionListener
{
    JLabel lSciezka, lWybierz, lSymuluj;
    JButton BSiatkowka, BDwaOgnie, bPrzeciaganie, bPowrot, bSymulacja; 
    public MenuOrganizacja()
    {
        setSize(500,500);
        setTitle("Menu Organizacja");
        setLayout(null);

        lSciezka = new JLabel("Organizacja Spotkan");
        lSciezka.setBounds(163,0,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lWybierz = new JLabel("Proszę wybrac dyscypline nowego spotkania");
        lWybierz.setBounds(88,120,350,20);
        lWybierz.setForeground(Color.BLACK);
        lWybierz.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lWybierz);

        BSiatkowka = new JButton("Siatkowka");
        BSiatkowka.setBounds(110,155,250,20);
        add(BSiatkowka);
        BSiatkowka.addActionListener(this);

        BDwaOgnie = new JButton("Dwa Ognie");
        BDwaOgnie.setBounds(110,190,250,20);
        add(BDwaOgnie);
        BDwaOgnie.addActionListener(this);

        bPrzeciaganie = new JButton("Przeciaganie Liny");
        bPrzeciaganie.setBounds(110,225,250,20);
        add(bPrzeciaganie);
        bPrzeciaganie.addActionListener(this);

        lSymuluj = new JLabel("Przeprowadzanie symulacji finalow dla obecnego stanu spotkan");
        lSymuluj.setBounds(35,260,450,20);
        lSymuluj.setForeground(Color.BLACK);
        lSymuluj.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lSymuluj);

        bSymulacja = new JButton("Symulacja");
        bSymulacja.setBounds(110,295,250,20);
        add(bSymulacja);
        bSymulacja.addActionListener(this);

        bPowrot = new JButton("Powrot do Menu Głównego");
        bPowrot.setBounds(110,330,250,20);
        add(bPowrot);
        bPowrot.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo = e.getSource();
        if(zrodlo==bPowrot)
        {
            dispose();
            MenuGlowne okno = new MenuGlowne();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==BSiatkowka)
        {
            dispose();
            MenuSiatkowka okno = new MenuSiatkowka();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==BDwaOgnie)
        {
            dispose();
            MenuDwaOgnie okno = new MenuDwaOgnie();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bPrzeciaganie)
        {
            dispose();
            MenuPrzeciaganie okno = new MenuPrzeciaganie();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
    }
}

class MenuSiatkowka extends JFrame implements ActionListener
{
    JLabel lSciezka, lDane, lDruzyna1, lDruzyna2, lSedzia1, lSedziaPom1, lSedziaPom2, lZwyciezca;
    JTextField tDruzyna1, tDruzyna2, tSedzia1, tSedziaPom1, tSedziaPom2, tZwyciezca;
    JButton bPowrot, bDodaj;

    public MenuSiatkowka()
    {
        setSize(500,600);
        setTitle("Menu Siatkowka");
        setLayout(null);

        lSciezka = new JLabel("Nowe spotkanie: Siatkowka");
        lSciezka.setBounds(140,0,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lDane = new JLabel("Proszę wpisac dane nowego spotkania");
        lDane.setBounds(110,120,350,20);
        lDane.setForeground(Color.BLACK);
        lDane.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDane);

        lDruzyna1 = new JLabel("Nazwa pierwszej druzyny");
        lDruzyna1.setBounds(155,145,350,20);
        lDruzyna1.setForeground(Color.BLACK);
        lDruzyna1.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDruzyna1);

        tDruzyna1 = new JTextField("");
        tDruzyna1.setBounds(173,170,130,20);
        add(tDruzyna1);

        lDruzyna2 = new JLabel("Nazwa drugiej druzyny");
        lDruzyna2.setBounds(160,195,350,20);
        lDruzyna2.setForeground(Color.BLACK);
        lDruzyna2.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDruzyna2);

        tDruzyna1 = new JTextField("");
        tDruzyna1.setBounds(173,220,130,20);
        add(tDruzyna1);

        lSedzia1 = new JLabel("Imie glownego sedziego");
        lSedzia1.setBounds(160,245,350,20);
        lSedzia1.setForeground(Color.BLACK);
        lSedzia1.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lSedzia1);

        tSedzia1 = new JTextField("");
        tSedzia1.setBounds(173,270,130,20);
        add(tSedzia1);

        lSedziaPom1 = new JLabel("Imie pierwszego sedziego pomocniczego");
        lSedziaPom1.setBounds(110,295,350,20);
        lSedziaPom1.setForeground(Color.BLACK);
        lSedziaPom1.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lSedziaPom1);

        tSedziaPom1 = new JTextField("");
        tSedziaPom1.setBounds(173,320,130,20);
        add(tSedziaPom1);

        lSedziaPom2 = new JLabel("Imie drugiego sedziego pomocniczego");
        lSedziaPom2.setBounds(120,345,350,20);
        lSedziaPom2.setForeground(Color.BLACK);
        lSedziaPom2.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lSedziaPom2);

        tSedziaPom2 = new JTextField("");
        tSedziaPom2.setBounds(173,370,130,20);
        add(tSedziaPom2);

        lZwyciezca = new JLabel("Zwycieska druzyna spotkania");
        lZwyciezca.setBounds(140,395,350,20);
        lZwyciezca.setForeground(Color.BLACK);
        lZwyciezca.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lZwyciezca);

        tZwyciezca = new JTextField("");
        tZwyciezca.setBounds(173,420,130,20);
        add(tZwyciezca);

        bDodaj = new JButton("Dodaj spotkanie");
        bDodaj.setBounds(110,455,250,20);
        add(bDodaj);
        bDodaj.addActionListener(this);

        bPowrot = new JButton("Powrot");
        bPowrot.setBounds(110,490,250,20);
        add(bPowrot);
        bPowrot.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo = e.getSource();
        if(zrodlo==bPowrot)
        {
            dispose();
            MenuOrganizacja okno = new MenuOrganizacja();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
    }
}

class MenuDwaOgnie extends JFrame implements ActionListener
{
    JLabel lSciezka, lDane, lDruzyna1, lDruzyna2, lSedzia1, lSedziaPom1, lSedziaPom2, lZwyciezca;
    JTextField tDruzyna1, tDruzyna2, tSedzia1, tSedziaPom1, tSedziaPom2, tZwyciezca;
    JButton bPowrot, bDodaj;

    public MenuDwaOgnie()
    {
        setSize(500,500);
        setTitle("Menu Dwa Ognie");
        setLayout(null);

        lSciezka = new JLabel("Nowe spotkanie: Dwa Ognie");
        lSciezka.setBounds(140,0,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lDane = new JLabel("Prosze wpisac dane nowego spotkania");
        lDane.setBounds(110,120,350,20);
        lDane.setForeground(Color.BLACK);
        lDane.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDane);

        lDruzyna1 = new JLabel("Nazwa pierwszej druzyny");
        lDruzyna1.setBounds(155,145,350,20);
        lDruzyna1.setForeground(Color.BLACK);
        lDruzyna1.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDruzyna1);

        tDruzyna1 = new JTextField("");
        tDruzyna1.setBounds(173,170,130,20);
        add(tDruzyna1);

        lDruzyna2 = new JLabel("Nazwa drugiej druzyny");
        lDruzyna2.setBounds(160,195,350,20);
        lDruzyna2.setForeground(Color.BLACK);
        lDruzyna2.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDruzyna2);

        tDruzyna1 = new JTextField("");
        tDruzyna1.setBounds(173,220,130,20);
        add(tDruzyna1);

        lSedzia1 = new JLabel("Imie sedziego");
        lSedzia1.setBounds(180,245,350,20);
        lSedzia1.setForeground(Color.BLACK);
        lSedzia1.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lSedzia1);

        tSedzia1 = new JTextField("");
        tSedzia1.setBounds(173,270,130,20);
        add(tSedzia1);

        lZwyciezca = new JLabel("Zwycieska druzyna spotkania");
        lZwyciezca.setBounds(140,295,350,20);
        lZwyciezca.setForeground(Color.BLACK);
        lZwyciezca.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lZwyciezca);

        tZwyciezca = new JTextField("");
        tZwyciezca.setBounds(173,320,130,20);
        add(tZwyciezca);

        bDodaj = new JButton("Dodaj spotkanie");
        bDodaj.setBounds(110,355,250,20);
        add(bDodaj);
        bDodaj.addActionListener(this);

        bPowrot = new JButton("Powrot");
        bPowrot.setBounds(110,390,250,20);
        add(bPowrot);
        bPowrot.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo = e.getSource();
        if(zrodlo==bPowrot)
        {
            dispose();
            MenuOrganizacja okno = new MenuOrganizacja();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
    }
}

class MenuPrzeciaganie extends JFrame implements ActionListener
{
    JLabel lSciezka, lDane, lDruzyna1, lDruzyna2, lSedzia1, lSedziaPom1, lSedziaPom2, lZwyciezca;
    JTextField tDruzyna1, tDruzyna2, tSedzia1, tSedziaPom1, tSedziaPom2, tZwyciezca;
    JButton bPowrot, bDodaj;

    public MenuPrzeciaganie()
    {
        setSize(500,500);
        setTitle("Menu Przeciaganie");
        setLayout(null);

        lSciezka = new JLabel("Nowe spotkanie: Przeciaganie Liny");
        lSciezka.setBounds(120,0,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lDane = new JLabel("Prosze wpisac dane nowego spotkania");
        lDane.setBounds(110,120,350,20);
        lDane.setForeground(Color.BLACK);
        lDane.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDane);

        lDruzyna1 = new JLabel("Nazwa pierwszej druzyny");
        lDruzyna1.setBounds(155,145,350,20);
        lDruzyna1.setForeground(Color.BLACK);
        lDruzyna1.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDruzyna1);

        tDruzyna1 = new JTextField("");
        tDruzyna1.setBounds(173,170,130,20);
        add(tDruzyna1);

        lDruzyna2 = new JLabel("Nazwa drugiej druzyny");
        lDruzyna2.setBounds(160,195,350,20);
        lDruzyna2.setForeground(Color.BLACK);
        lDruzyna2.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lDruzyna2);

        tDruzyna1 = new JTextField("");
        tDruzyna1.setBounds(173,220,130,20);
        add(tDruzyna1);

        lSedzia1 = new JLabel("Imie sedziego");
        lSedzia1.setBounds(180,245,350,20);
        lSedzia1.setForeground(Color.BLACK);
        lSedzia1.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lSedzia1);

        tSedzia1 = new JTextField("");
        tSedzia1.setBounds(173,270,130,20);
        add(tSedzia1);

        lZwyciezca = new JLabel("Zwycieska druzyna spotkania");
        lZwyciezca.setBounds(140,295,350,20);
        lZwyciezca.setForeground(Color.BLACK);
        lZwyciezca.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lZwyciezca);

        tZwyciezca = new JTextField("");
        tZwyciezca.setBounds(173,320,130,20);
        add(tZwyciezca);

        bDodaj = new JButton("Dodaj spotkanie");
        bDodaj.setBounds(110,355,250,20);
        add(bDodaj);
        bDodaj.addActionListener(this);

        bPowrot = new JButton("Powrot");
        bPowrot.setBounds(110,390,250,20);
        add(bPowrot);
        bPowrot.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo = e.getSource();
        if(zrodlo==bPowrot)
        {
            dispose();
            MenuOrganizacja okno = new MenuOrganizacja();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
    }
}

