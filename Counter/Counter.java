/**
 *  Ez Counter MLG ohne Scheiß
 *  @author: Cien Biswas
 *  @version: 1.8
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.Scanner;

public class Counter extends JFrame implements MouseListener, ActionListener
 {
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JLabel score = new JLabel();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JMenuItem custom = new JMenuItem("Custom");
    static Saver g = new Saver();
    static Saver h = new Saver();
    JMenuBar menu = new JMenuBar();
    static int number=0;
    static int a=1;
    static int s=0;
     public Counter()
     {
        //Layout
        this.setTitle("Counter");
        this.setSize(375, 200);
        this.setResizable(false);
        panel.setLayout(null);
        button1.setText("+");
        button1.setBounds(70,40, 50, 50);
        ImageIcon image = new ImageIcon("LOL.png");
        button1.setIcon(image);
        button2.setText("Reset");
        button2.setBounds(220, 40, 50, 50);
        ImageIcon image1 = new ImageIcon("Trollface.jpg");
        button2.setIcon(image1);
        label.setText("" + number);
        label.setFont(label.getFont().deriveFont((float) 22));
        label.setBounds(160, 30, 70, 70);
        score.setText("" + s);
        setLocationRelativeTo(getParent());
        
        //Menu        
        menu = new JMenuBar();
        JMenu options = new JMenu("Options");
        menu.add(options);
        JMenu allTime = new JMenu("All-Time score");
        menu.add(allTime);
        allTime.add(score);
        JMenuItem reset = new JMenuItem("Reset");
        allTime.add(reset);
        reset.addActionListener(this);
        JMenu multi = new JMenu("Multiplier");
        options.add(multi);
        JMenuItem standard = new JMenuItem("+1");
        multi.add(standard);
        standard.addActionListener(new Listener(this, 1));
        JMenuItem two = new JMenuItem("+2");
        two.addActionListener(new Listener(this, 2));
        multi.add(two);
        JMenuItem five = new JMenuItem("+5");
        multi.add(five);
        five.addActionListener(new Listener(this, 5));
        JMenuItem ten = new JMenuItem("+10");
        multi.add(ten);
        ten.addActionListener(new Listener(this, 10));
        JMenuItem hundred = new JMenuItem("+100");
        multi.add(hundred);
        hundred.addActionListener(new Listener(this, 100));
        //multi.add(custom);
        //custom.addActionListener(new custom(this));
        setJMenuBar(menu);
                
        
        //Adden
        panel.add(button1);
        panel.add(button2);
        panel.add(label);
        this.add(panel);
        button1.addMouseListener(this);
        
        //Sonstiges
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void mousePressed(MouseEvent l) {
        if(l.getButton() == MouseEvent.BUTTON1)
            number += a;
        else if(l.getButton() == MouseEvent.BUTTON3)
            number -= a;
        s += a;
        label.setText("" + number);
        score.setText("" + s);
            
        g.write(number + "");
        h.write1(s + "");
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent r)
    {
        s = 0;
        score.setText("" + s);
    }
}  