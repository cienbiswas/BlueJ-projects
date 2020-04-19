public class Start
{
    static Counter c;
    
    public static void main()
    {
        c.number = Integer.valueOf(c.g.read());
        c.s = Integer.valueOf(c.h.read1());
        Counter c = new Counter();
        
        c.setVisible(true);
    }

}