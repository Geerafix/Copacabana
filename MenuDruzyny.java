import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class MenuDruzyny extends JFrame implements ActionListener
{
    JLabel lSciezka;
    JButton bDodawanie, bUsuwanie, bPrzeglad, bPowrot;
    public MenuDruzyny()
    {
        setSize(500,500);
        setTitle("Menu Druzyny");
        setLayout(null);

        lSciezka = new JLabel("Zarządzanie Drużynami");
        lSciezka.setBounds(155,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        bDodawanie = new JButton("Dodawanie drużyn");
        bDodawanie.setBounds(110,150,250,20);
        add(bDodawanie);
        bDodawanie.addActionListener(this);

        bUsuwanie = new JButton("Usuwanie drużyn");
        bUsuwanie.setBounds(110,185,250,20);
        add(bUsuwanie);
        bUsuwanie.addActionListener(this);

        bPrzeglad = new JButton("Przegląd drużyn");
        bPrzeglad.setBounds(110,220,250,20);
        add(bPrzeglad);
        bPrzeglad.addActionListener(this);

        bPowrot = new JButton("Powrót do Menu Głównego");
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
            MenuGlowne okno = new MenuGlowne();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bDodawanie)
        {
            dispose();
            MenuDodawanieD okno = new MenuDodawanieD();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bUsuwanie)
        {
            dispose();
            MenuUsuwanieD okno = new MenuUsuwanieD();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bPrzeglad)
        {
            dispose();
            MenuPrzegladD okno = new MenuPrzegladD();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
    }
}

class MenuDodawanieD extends JFrame implements ActionListener
{
    JLabel lSciezka, lWpiszSedziego;
    JButton bDodaj, bPowrot;
    JTextField tSedzia;
    String NowySedzia;

    public MenuDodawanieD()
    {
        setSize(500,500);
        setTitle("Dodawanie Drużyn");
        setLayout(null);

        lSciezka = new JLabel("Dodawanie Drużyn");
        lSciezka.setBounds(172,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lWpiszSedziego = new JLabel("Proszę wpisać nową drużynę do listy drużyn");
        lWpiszSedziego.setBounds(98,150,350,20);
        lWpiszSedziego.setForeground(Color.BLACK);
        lWpiszSedziego.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lWpiszSedziego);

        tSedzia = new JTextField("");
        tSedzia.setBounds(173,180,130,20);
        add(tSedzia);

        bDodaj = new JButton("Dodaj drużynę");
        bDodaj.setBounds(110,220,250,20);
        add(bDodaj);
        bDodaj.addActionListener(this);

        bPowrot = new JButton("Powrót");
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
            NowySedzia = tSedzia.getText();
            ListaSedziow lse = new ListaSedziow();
            try {lse.zPliku();} catch (ClassNotFoundException | IOException e1) {e1.printStackTrace();}
            try {lse.dodajSedziego(NowySedzia);} catch (IOException e1) {e1.printStackTrace();}
            dispose();
            MenuSedziowie okno = new MenuSedziowie();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bPowrot)
        {
            dispose();
            MenuDruzyny frame = new MenuDruzyny();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}

class MenuUsuwanieD extends JFrame implements ActionListener
{
    JLabel lSciezka, lWpiszDruzyne;
    JButton bUsun, bPowrot;
    JTextField tDruzyna;

    public MenuUsuwanieD()
    {
        setSize(500,500);
        setTitle("Usuwanie Drużyn");
        setLayout(null);

        lSciezka = new JLabel("Usuwanie Drużyn");
        lSciezka.setBounds(175,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lWpiszDruzyne = new JLabel("Proszę wpisać drużynę do usunięcia z listy drużyn");
        lWpiszDruzyne.setBounds(80,150,350,20);
        lWpiszDruzyne.setForeground(Color.BLACK);
        lWpiszDruzyne.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lWpiszDruzyne);

        tDruzyna = new JTextField("");
        tDruzyna.setBounds(173,180,130,20);
        add(tDruzyna);

        bUsun = new JButton("Usuń drużynę");
        bUsun.setBounds(110,220,250,20);
        add(bUsun);
        bUsun.addActionListener(this);

        bPowrot = new JButton("Powrót");
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
            MenuDruzyny frame = new MenuDruzyny();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}

class MenuPrzegladD extends JFrame implements ActionListener 
{
    JLabel lSciezka;
    JButton bPowrot;

    public MenuPrzegladD()
    {
        setSize(500,500);
        setTitle("Przegląd Drużyn");
        setLayout(null);

        lSciezka = new JLabel("Przegląd Drużyn");
        lSciezka.setBounds(175,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        bPowrot = new JButton("Powrót");
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
            MenuDruzyny frame = new MenuDruzyny();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}