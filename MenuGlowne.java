import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuGlowne extends JFrame implements ActionListener
{
    JButton bSedziowie, bDruzyny, bOrganizacja, bWyniki, bWyjscie;
    JLabel lTytul, lSciezka;
    public MenuGlowne()
    {
        setSize(500,500);
        setTitle("Menu Główne");
        setLayout(null);

        lTytul = new JLabel("Plażowe Rozgrywki Kopakabana");
        lTytul.setBounds(84,0,400,200);
        lTytul.setForeground(Color.BLUE);
        lTytul.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lTytul);

        lSciezka = new JLabel("Menu Główne");
        lSciezka.setBounds(185,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        bSedziowie = new JButton("Zarządzanie sędziami");
        bSedziowie.setBounds(110,150,250,20);
        add(bSedziowie);
        bSedziowie.addActionListener(this);

        bDruzyny = new JButton("Zarządzanie drużynami");
        bDruzyny.setBounds(110,185,250,20);
        add(bDruzyny);
        bDruzyny.addActionListener(this);

        bOrganizacja = new JButton("Organizacja rozgrywek");
        bOrganizacja.setBounds(110,220,250,20);
        add(bOrganizacja);
        bOrganizacja.addActionListener(this);

        bWyniki = new JButton("Wyniki rozgrywek");
        bWyniki.setBounds(110,255,250,20);
        add(bWyniki);
        bWyniki.addActionListener(this);

        bWyjscie = new JButton("Wyjście");
        bWyjscie.setBounds(110,290,250,20);
        add(bWyjscie);
        bWyjscie.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) //e - obiekt zdarzenia wysylany przez przycisk do sluchacza zdarzen
    {
        Object zrodlo = e.getSource(); //sprawdza ktory przycisk jest zrodlem zdarzenia
        if(zrodlo==bSedziowie)
        {
            dispose();
            MenuSedziowie frame = new MenuSedziowie();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        else if(zrodlo==bWyjscie)
        {
            dispose();
        }
        
    }
}