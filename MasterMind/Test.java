public class Test
{
    private Game g;

    enum Colour
    {
        RED, GREEN, BLUE, YELLOW;
    }
    public void test()
    {
        g = new Game();
        for(int i = 0; i < g.colourSlot.length; i++)
        {
            System.out.println(g.colourSlot[i]);
        }
        System.out.println();
        for(int i = 0; i < g.result.length; i++)
        {
            System.out.println(g.result[i]);
        }
    }
}