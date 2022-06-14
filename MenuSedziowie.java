import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class MenuSedziowie extends JFrame implements ActionListener
{
    JLabel lSciezka;
    JButton bDodawanie, bUsuwanie, bPrzeglad, bPowrot;
    public MenuSedziowie()
    {
        setSize(500,500);
        setTitle("Menu Sedziowie");
        setLayout(null);

        lSciezka = new JLabel("Zarzadzanie Sedziami");
        lSciezka.setBounds(161,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        bDodawanie = new JButton("Dodawanie sedziow");
        bDodawanie.setBounds(110,150,250,20);
        add(bDodawanie);
        bDodawanie.addActionListener(this);

        bUsuwanie = new JButton("Usuwanie sedziow");
        bUsuwanie.setBounds(110,185,250,20);
        add(bUsuwanie);
        bUsuwanie.addActionListener(this);

        bPrzeglad = new JButton("Przeglad sedziow");
        bPrzeglad.setBounds(110,220,250,20);
        add(bPrzeglad);
        bPrzeglad.addActionListener(this);

        bPowrot = new JButton("Powrot do Menu Glownego");
        bPowrot.setBounds(110,255,250,20);
        add(bPowrot);
        bPowrot.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) //e - obiekt zdarzenia wysylany przez przycisk do sluchacza zdarzen
    {
        Object zrodlo = e.getSource(); //sprawdza ktory przycisk jest zrodlem zdarzenia
        if(zrodlo==bPowrot)
        {
            dispose();
            MenuGlowne okno = new MenuGlowne();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bDodawanie)
        {
            dispose();
            MenuDodawanieS okno = new MenuDodawanieS();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bUsuwanie)
        {
            dispose();
            MenuUsuwanieS okno = new MenuUsuwanieS();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bPrzeglad)
        {
            dispose();
            MenuPrzegladS okno = new MenuPrzegladS();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
    }
}

class MenuDodawanieS extends JFrame implements ActionListener
{
    JLabel lSciezka, lWpiszSedziego;
    JButton bDodaj, bPowrot;
    JTextField tSedzia;
    String NowySedzia;

    public MenuDodawanieS()
    {
        setSize(500,500);
        setTitle("Dodawanie Sedziow");
        setLayout(null);

        lSciezka = new JLabel("Dodawanie Sedziow");
        lSciezka.setBounds(167,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lWpiszSedziego = new JLabel("Prosze wpisac nowego sedziego do listy sedziow");
        lWpiszSedziego.setBounds(80,150,350,20);
        lWpiszSedziego.setForeground(Color.BLACK);
        lWpiszSedziego.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lWpiszSedziego);

        tSedzia = new JTextField("");
        tSedzia.setBounds(173,180,130,20);
        add(tSedzia);

        bDodaj = new JButton("Dodaj sedziego");
        bDodaj.setBounds(110,220,250,20);
        add(bDodaj);
        bDodaj.addActionListener(this);

        bPowrot = new JButton("Powrot");
        bPowrot.setBounds(110,255,250,20);
        add(bPowrot);
        bPowrot.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo = e.getSource();
        if(zrodlo==bDodaj)
        {
            dispose();
            MenuSedziowie okno = new MenuSedziowie();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bPowrot)
        {
            dispose();
            MenuSedziowie okno = new MenuSedziowie();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
    }
}

class MenuUsuwanieS extends JFrame implements ActionListener
{
    JLabel lSciezka, lWpiszSedziego;
    JButton bUsun, bPowrot;
    JTextField tSedzia;
    String NowySedzia;

    public MenuUsuwanieS()
    {
        setSize(500,500);
        setTitle("Usuwanie Sedziow");
        setLayout(null);

        lSciezka = new JLabel("Usuwanie Sedziow");
        lSciezka.setBounds(170,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lWpiszSedziego = new JLabel("Prosze wpisac sedziego do usuniecia z listy sedziow");
        lWpiszSedziego.setBounds(80,150,350,20);
        lWpiszSedziego.setForeground(Color.BLACK);
        lWpiszSedziego.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lWpiszSedziego);

        tSedzia = new JTextField("");
        tSedzia.setBounds(173,180,130,20);
        add(tSedzia);

        bUsun = new JButton("Usun sedziego");
        bUsun.setBounds(110,220,250,20);
        add(bUsun);
        bUsun.addActionListener(this);

        bPowrot = new JButton("Powrot");
        bPowrot.setBounds(110,255,250,20);
        add(bPowrot);
        bPowrot.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo = e.getSource();
        if(zrodlo==bUsun)
        {
            dispose();
            MenuSedziowie okno = new MenuSedziowie();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bPowrot)
        {
            dispose();
            MenuSedziowie okno = new MenuSedziowie();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
    }
}

class MenuPrzegladS extends JFrame implements ActionListener 
{
    JLabel lSciezka;
    JButton bPowrot;

    public MenuPrzegladS()
    {
        setSize(500,500);
        setTitle("Przeglad Sedziow");
        setLayout(null);

        lSciezka = new JLabel("Przeglad Sedziow");
        lSciezka.setBounds(172,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        bPowrot = new JButton("Powrot");
        bPowrot.setBounds(110,255,250,20);
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
            MenuSedziowie frame = new MenuSedziowie();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}


