import javax.swing.*;
import java.awt.event.*;

public class Clock extends JFrame implements ActionListener
{
    private JPanel p = new JPanel();
    private JLabel l = new JLabel();
    JMenuBar menu = new JMenuBar();
    int d=1000;
        
        public void Clock(int hours, int minutes)
        {
        if(hours < 0 || hours > 23)
            System.out.println("The hours have to be in a range of 0 - 23!");
        if(minutes < 0 || minutes > 60)
            System.out.println("The minutes have to be in a range of 0 - 59!");
        
        this.setSize(500, 300);
        this.setVisible(true);
        p.setLayout(null);
        l.setBounds(110, 40, 400, 150);
        l.setFont(l.getFont().deriveFont((float) 60));
        
        //menu
        JMenu delay = new JMenu("Delay");
        menu.add(delay);
        JMenuItem viertel = new JMenuItem("0,25s");
        viertel.addActionListener(new Listener(this, 250));
        delay.add(viertel);
        JMenuItem half = new JMenuItem("0,5s");
        half.addActionListener(new Listener(this, 500));
        delay.add(half);
        JMenuItem dreiviertel = new JMenuItem("0,75s");
        dreiviertel.addActionListener(new Listener(this, 750));
        delay.add(dreiviertel);
        JMenuItem standard = new JMenuItem("Standard");
        standard.addActionListener(new Listener(this, 1000));
        delay.add(standard);
        setJMenuBar(menu);
        
        //adden
        p.add(l);
        this.add(p);
        
        //Sonstiges
        setLocationRelativeTo(getParent());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Loops
        int seconds = 0;
        final boolean a = true;
        
        while(a)
        {
            while(hours >= 0 && hours < 24)
            {
                while(minutes >= 0 && minutes < 60)
                {
                    while(seconds >= 0 && seconds < 60)
                    {
                        //the 0s in front of the numbers
                        if(hours < 10 && minutes > 9 && seconds > 9)
                            l.setText("0" + hours + ":" + minutes + ":" + seconds);
                        else if(minutes < 10 && hours > 9 && seconds > 9)
                            l.setText(hours + ":0" + minutes + ":" + seconds);
                        else if(seconds < 10 && hours > 9 && minutes > 9)
                            l.setText(hours + ":" + minutes + ":0" + seconds);
                        else if(hours < 10 && minutes < 10 && seconds > 9)
                            l.setText("0" + hours + ":0" + minutes + ":" + seconds);
                        else if(minutes < 10 && seconds < 10 && hours > 9)
                            l.setText(hours + ":0" + minutes + ":0" + seconds);
                        else if(hours < 10 && seconds < 10 && minutes > 9)
                            l.setText("0" + hours + ":" + minutes + ":0" + seconds);
                        else if(hours < 10 && minutes < 10 && seconds < 10)
                            l.setText("0" + hours + ":0" + minutes + ":0" + seconds);
                        else
                            l.setText(hours + ":" + minutes + ":" + seconds);
                        seconds++;
                        try
                        {
                            Thread.sleep(d); //d is the delay; standard: 1second(1000ms)
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    seconds = 0;
                    minutes++;
                }
                minutes = 0;
                hours++;
            }
            hours = 0;
        }
    }
    public void actionPerformed(ActionEvent ae){}
}