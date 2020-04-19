import java.awt.event.*;

public class Listener implements ActionListener
{
    Counter c;
    int m;
    public Listener(Counter c, int multi){
        this.c = c;
        m = multi;
        c.button2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {   
        c.a = m;
        if(ae.getSource() == c.button2)
            c.number = 0;
        c.label.setText("" + c.number);
        if(c.number > 10)
            c.label.setBounds(158, 30, 70, 70);
        else if(c.number > 100)
            c.label.setBounds(155, 30, 70, 70);
            
        c.g.write(c.number + "");
    }
    
}