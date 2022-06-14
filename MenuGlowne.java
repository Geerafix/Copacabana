import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class MenuGlowne extends JFrame implements ActionListener
{
    JButton bSedziowie, bDruzyny, bOrganizacja, bWyniki, bWyjscie, bFinal;
    JLabel lTytul, lSciezka;
    public MenuGlowne()
    {
        setSize(500,500);
        setTitle("Menu Glowne");
        setLayout(null);

        lTytul = new JLabel("Plazowe Rozgrywki Kopakabana");
        lTytul.setBounds(84,0,400,200);
        lTytul.setForeground(Color.BLUE);
        lTytul.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lTytul);

        lSciezka = new JLabel("Menu Glowne");
        lSciezka.setBounds(185,30,400,200);
        lSciezka.setForeground(Color.RED);
        lSciezka.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lSciezka);

        bSedziowie = new JButton("Zarzadzanie sedziami");
        bSedziowie.setBounds(110,150,250,20);
        add(bSedziowie);
        bSedziowie.addActionListener(this);

        bDruzyny = new JButton("Zarzadzanie druzynami");
        bDruzyny.setBounds(110,185,250,20);
        add(bDruzyny);
        bDruzyny.addActionListener(this);

        bOrganizacja = new JButton("Organizacja spotkan");
        bOrganizacja.setBounds(110,220,250,20);
        add(bOrganizacja);
        bOrganizacja.addActionListener(this);

        bWyniki = new JButton("Wyniki rozgrywek");
        bWyniki.setBounds(110,255,250,20);
        add(bWyniki);
        bWyniki.addActionListener(this);

        bWyjscie = new JButton("Wyjscie");
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
        else if(zrodlo==bDruzyny)
        {
            dispose();
            MenuDruzyny frame = new MenuDruzyny();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        else if(zrodlo==bOrganizacja)
        {
            dispose();
            MenuOrganizacja okno = new MenuOrganizacja();
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setVisible(true);
        }
        else if(zrodlo==bWyjscie)
        {
            dispose();
        }
    }
}
