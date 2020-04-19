import java.awt.event.*;

public class Listener implements ActionListener
{
    Clock c;
    int y;
    public Listener(Clock c, int delay)
    {
        this.c = c;
        y = delay;
    }
    public void actionPerformed(ActionEvent ae)
    {
        c.d = y;
    }
}