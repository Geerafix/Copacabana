import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MenuSedziowie extends JFrame implements ActionListener
{
    JLabel lSciezka;
    JButton bDodawanie, bUsuwanie, bPrzeglad, bPowrot;
    public MenuSedziowie()
    {
        setSize(500,500);
        setTitle("Menu Sedziowie");
        setLayout(null);

        lSciezka = new JLabel("Zarządzanie Sędziami");
        lSciezka.setBounds(163,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        bDodawanie = new JButton("Dodawanie sędziów");
        bDodawanie.setBounds(110,150,250,20);
        add(bDodawanie);
        bDodawanie.addActionListener(this);

        bUsuwanie = new JButton("Usuwanie sędziów");
        bUsuwanie.setBounds(110,185,250,20);
        add(bUsuwanie);
        bUsuwanie.addActionListener(this);

        bPrzeglad = new JButton("Przegląd sędziów");
        bPrzeglad.setBounds(110,220,250,20);
        add(bPrzeglad);
        bPrzeglad.addActionListener(this);

        bPowrot = new JButton("Powrót do Menu Głównego");
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
        setTitle("Dodawanie Sędziów");
        setLayout(null);

        lSciezka = new JLabel("Dodawanie Sędziów");
        lSciezka.setBounds(163,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lWpiszSedziego = new JLabel("Proszę wpisać nowego sędziego do listy sędziów");
        lWpiszSedziego.setBounds(80,150,350,20);
        lWpiszSedziego.setForeground(Color.BLACK);
        lWpiszSedziego.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lWpiszSedziego);

        tSedzia = new JTextField("");
        tSedzia.setBounds(168,180,130,20);
        add(tSedzia);

        bDodaj = new JButton("Dodaj sędziego");
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
                try {
                    lse.zPliku();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    lse.dodajSedziego(NowySedzia);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
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
        setTitle("Usuwanie Sędziów");
        setLayout(null);

        lSciezka = new JLabel("Usuwanie Sędziów");
        lSciezka.setBounds(166,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        lWpiszSedziego = new JLabel("Proszę wpisać sędziego do usunięcia z listy sędziów");
        lWpiszSedziego.setBounds(80,150,350,20);
        lWpiszSedziego.setForeground(Color.BLACK);
        lWpiszSedziego.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lWpiszSedziego);

        tSedzia = new JTextField("");
        tSedzia.setBounds(168,180,130,20);
        add(tSedzia);

        bUsun = new JButton("Usuń sędziego");
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
        if(zrodlo==bUsun)
        {
            NowySedzia = tSedzia.getText();
            ListaSedziow lse = new ListaSedziow();
                try {
                    lse.zPliku();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    lse.usunSedziego(NowySedzia);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
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
    JList liSedziowie;
    ListaSedziow lse = new ListaSedziow();

    public MenuPrzegladS()
    {
        try {
            lse.zPliku();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setSize(500,500);
        setTitle("Przegląd Sędziów");
        setLayout(null);

        lSciezka = new JLabel("Przegląd Sędziów");
        lSciezka.setBounds(166,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo = e.getSource();
        
    }
}


