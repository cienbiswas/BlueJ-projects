import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

enum Colour
{
    RED, GREEN, BLUE, YELLOW;
}


public class Game extends JFrame implements ActionListener
{
    JPanel gamePanel = new JPanel();
    
    //game panel
    JLabel r1 = new JLabel(); JLabel r2 = new JLabel(); JLabel r3 = new JLabel(); JLabel r4 = new JLabel(); JLabel sl1 = new JLabel(); JLabel sl2 = new JLabel(); JLabel sl3 = new JLabel(); JLabel sl4 = new JLabel(); JLabel prevSlot1 = new JLabel(); JLabel prevSlot2 = new JLabel(); JLabel prevSlot3 = new JLabel(); JLabel prevSlot4 = new JLabel(); JLabel prevRe1 = new JLabel(); JLabel prevRe2 = new JLabel(); JLabel prevRe3 = new JLabel(); JLabel prevRe4 = new JLabel(); JLabel attemptLabel = new JLabel();
    
    JButton redB = new JButton(); JButton greenB = new JButton(); JButton blueB = new JButton(); JButton yellowB = new JButton(); JButton submit = new JButton(); JButton delete = new JButton(); JButton next = new JButton();
    
    //Icons
    ImageIcon baseI = new ImageIcon("base.png");
    ImageIcon whiteI = new ImageIcon("white.png");
    ImageIcon blackI = new ImageIcon("black.png");
    ImageIcon redI = new ImageIcon("red.png");
    ImageIcon blueI = new ImageIcon("blue.png");
    ImageIcon greenI = new ImageIcon("green.png");
    ImageIcon yellowI = new ImageIcon("yellow.png");
    
    private int counterSlots=0;
    private int counterResults=0;
    
    public Colour[] colourSlot;
    public Colour[] result;
    public int[] resultTable;
    
    private boolean[] availableRe;
    private boolean[] availableGue;
    
    private int submitNot2x=0;
    private int nextNot2x=0;
    
    Random random = new Random();
    private boolean easy=false;
    
    private int attempts=15;
    private boolean win;
    
    public Game()
    {
            /** Arrays */
        colourSlot = new Colour[4];
        result = new Colour[4];
        resultTable = new int[4];
        availableRe = new boolean[4];
        availableGue = new boolean[4];
        //Lösungs array createn
        for(int i = 0; i < result.length; i++)
        {
            result[i] = random2();
        }
        
            /** Layout */
        //Frame
        this.setTitle("MasterMind");
        this.setSize(700,450);
        this.setResizable(false);
        gamePanel.setLayout(null);
        
        //****Labels/Buttons
        //*game panel
        r1.setBounds(10, 70, 61, 55);
        r1.setIcon(baseI);
        r2.setBounds(80, 70, 61, 55);
        r2.setIcon(baseI);
        r3.setBounds(10, 134, 61, 55);
        r3.setIcon(baseI);
        r4.setBounds(80, 134, 61, 55);
        r4.setIcon(baseI);
        sl1.setBounds(191, 100, 61, 55);
        sl1.setIcon(whiteI);
        sl2.setBounds(261, 100, 61, 55);
        sl2.setIcon(whiteI);
        sl3.setBounds(331, 100, 61, 55);
        sl3.setIcon(whiteI);
        sl4.setBounds(401, 100, 61, 55);
        sl4.setIcon(whiteI);
        redB.setBounds(512, 70, 61, 55);
        redB.setIcon(redI);
        greenB.setBounds(582, 70, 61, 55);
        greenB.setIcon(greenI);
        blueB.setBounds(512, 134, 61, 55);
        blueB.setIcon(blueI);
        yellowB.setBounds(582, 134, 61, 55);
        yellowB.setIcon(yellowI);
        submit.setBounds(287, 200, 80, 30);
        submit.setText("Submit");
        delete.setBounds(537, 200, 80, 30);
        delete.setText("Delete");
        next.setBounds(287, 15, 80, 30);
        next.setText("Next >>");
        prevSlot1.setBounds(191, 300, 61, 55);
        prevSlot1.setIcon(whiteI);
        prevSlot2.setBounds(261, 300, 61, 55);
        prevSlot2.setIcon(whiteI);
        prevSlot3.setBounds(331, 300, 61, 55);
        prevSlot3.setIcon(whiteI);
        prevSlot4.setBounds(401, 300, 61, 55);
        prevSlot4.setIcon(whiteI);
        prevRe1.setBounds(10, 270, 61, 55);
        prevRe1.setIcon(baseI);
        prevRe2.setBounds(80, 270, 61, 55);
        prevRe2.setIcon(baseI);
        prevRe3.setBounds(10, 334, 61, 55);
        prevRe3.setIcon(baseI);
        prevRe4.setBounds(80, 334, 61, 55);
        prevRe4.setIcon(baseI);
        attemptLabel.setBounds(520, 280, 150, 60);
        setAttempts();
        
            /** add */
        redB.addActionListener(this);
        greenB.addActionListener(this);
        blueB.addActionListener(this);
        yellowB.addActionListener(this);
        submit.addActionListener(this);
        delete.addActionListener(this);
        next.addActionListener(this);
        gamePanel.add(r1); gamePanel.add(r2); gamePanel.add(r3); gamePanel.add(r4); gamePanel.add(sl1); gamePanel.add(sl2); gamePanel.add(sl3); gamePanel.add(sl4); gamePanel.add(redB);gamePanel.add(greenB); gamePanel.add(blueB); gamePanel.add(yellowB); gamePanel.add(submit); gamePanel.add(delete); gamePanel.add(next);  gamePanel.add(prevSlot1); gamePanel.add(prevSlot2); gamePanel.add(prevSlot3); gamePanel.add(prevSlot4); gamePanel.add(prevRe1); gamePanel.add(prevRe2); gamePanel.add(prevRe3); gamePanel.add(prevRe4); gamePanel.add(attemptLabel);
        this.add(gamePanel);
        
            /** Others */
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource() == redB)
        {
            countFillAssign(redI, Colour.RED);
        }
        else if(ev.getSource() == greenB)
        {
            countFillAssign(greenI, Colour.GREEN);
        }
        else if(ev.getSource() == blueB)
        {
            countFillAssign(blueI, Colour.BLUE);
        }
        else if(ev.getSource() == yellowB)
        {
            countFillAssign(yellowI, Colour.YELLOW);
        }
        else if(ev.getSource() == delete)
        {
            fillSlots(counterSlots, whiteI);
            if(counterSlots > 0 && counterSlots <= 5)
                counterSlots--;
        }
        else if(ev.getSource() == submit)
        {
            submit();
        }
        else if(ev.getSource() == next)
        {
            next();
        }
    }
    
    //counts where the slot is right now; fills the slot with the appropriate colour; assigns the colour value of the slot to the array colourSlot
    private void countFillAssign(ImageIcon icon, Colour col)
    {
        if(counterSlots >= 0 && counterSlots < 4)
        {
            fillSlots(counterSlots, icon);
            colourSlot[counterSlots] = col;
            counterSlots++;
        }
    }
    
    private void submit()
    {
        //check so submit can't be clicked twice in a row
        if(submitNot2x > 0)
            return;
        submitNot2x++;
        
        //checks if all slots have a colour
        if(counterSlots != 4)
            return;
        
        //fills results with base colour
        for(int i = 0; i < result.length; i++)
        {
            fillResults(i, baseI);
        }
        
        //fills the results with black colour
        for(int i = 0; i < result.length; i++)
        {
            if(result[i] == colourSlot[i])
            {
                availableRe[i] = true;
                availableGue[i] = true;
                fillResults(counterResults, blackI);
                resultTable[counterResults] = 2;
                counterResults++;
            }
        }
        //fills the result with white colour
        for(int u = 0; u < colourSlot.length; u++)
        {
            if(availableGue[u] == true)
                continue;
            for(int p = 0; p < result.length; p++)
            {
                if(availableRe[p] == true)
                        continue;
                if(colourSlot[u] == result[p])
                {
                    fillResults(counterResults, whiteI);
                    resultTable[counterResults] = 1;
                    eliminate(colourSlot[u]);
                    counterResults++;
                    break;
                }
            }
            if(u == 3)
                break;
            if(colourSlot[u] == colourSlot[u+1])
                u++;
        }
        nextNot2x = 0;
        attempts--;
        setAttempts();
    }
    
    private void next()
    {
        //check so next can't be clicked twice in a row
        if(nextNot2x > 0)
            return;
        nextNot2x++;
        
        //checks if all slots have a colour
        if(counterSlots != 4)
            return;
        
        counterResults = 0;
        counterSlots = 0;
        
        //fills previous results correctly
        for(int i = 0; i < colourSlot.length; i++)
        {
            if(colourSlot[i] == Colour.RED)
                fillPrevSlots(i, redI);
            else if(colourSlot[i] == Colour.GREEN)
                fillPrevSlots(i, greenI);
            else if(colourSlot[i] == Colour.BLUE)
                fillPrevSlots(i, blueI);
            else if(colourSlot[i] == Colour.YELLOW)
                fillPrevSlots(i, yellowI);
        }
        
        
        //fills slots white
        for(int i = 0; i < colourSlot.length; i++)
        {
            fillSlots(i, whiteI);
        }
        //fills results with base colour
        for(int i = 0; i < result.length; i++)
        {
            fillResults(i, baseI);
        }
        
        
        //removes previous results' colour --> fills it with base colour
        for(int i = 0; i < result.length; i++)
        {
            fillPrevResults(i, baseI);
        }
        //fills previous results correctly
        for(int i = 0; i < result.length; i++)
        {
            if(resultTable[i] == 1)
                fillPrevResults(i, whiteI);
            else if(resultTable[i] == 2)
                fillPrevResults(i, blackI);
        }
        
        
        //sets all array's values to false
        for(int i = 0; i < availableRe.length; i++)
        {
            availableRe[i] = false;
        }
        for(int i = 0; i < availableGue.length; i++)
        {
            availableGue[i] = false;
        }
        
        submitNot2x = 0;
    }
    
    private void fillSlots(int pos, ImageIcon icon)
    {
        if(pos == 0)
            sl1.setIcon(icon);
        else if(pos == 1)
            sl2.setIcon(icon);
        else if(pos == 2)
            sl3.setIcon(icon);
        else if(pos == 3)
            sl4.setIcon(icon);
    }
    
    private void fillResults(int pos, ImageIcon icon)
    {
        if(pos == 0)
            r1.setIcon(icon);
        else if(pos == 1)
            r2.setIcon(icon);
        else if(pos == 2)
            r3.setIcon(icon);
        else if(pos == 3)
            r4.setIcon(icon);
    }
    
    private void fillPrevSlots(int pos, ImageIcon icon)
    {
        if(pos == 0)
            prevSlot1.setIcon(icon);
        else if(pos == 1)
            prevSlot2.setIcon(icon);
        else if(pos == 2)
            prevSlot3.setIcon(icon);
        else if(pos == 3)
            prevSlot4.setIcon(icon);
    }
    
    private void fillPrevResults(int pos, ImageIcon icon)
    {
        if(pos == 0)
            prevRe1.setIcon(icon);
        else if(pos == 1)
            prevRe2.setIcon(icon);
        else if(pos == 2)
            prevRe3.setIcon(icon);
        else if(pos == 3)
            prevRe4.setIcon(icon);
    }
    
    private void setElement(Colour[] arr, int pos, Colour col)
    {
        arr[pos] = col;
    }
    
    public void test()
    {
        for(int i = 0; i < colourSlot.length; i++)
        {
            System.out.println(colourSlot[i]);
        }
        System.out.println();
        System.out.println();
        for(int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
        System.out.println();
        System.out.println();
        for(int i = 0; i < resultTable.length; i++)
        {
            System.out.println(resultTable[i]);
        }
    }

    private Colour random2()
    {
        return Colour.values()[new Random().nextInt(Colour.values().length)];
    }
    
    private void eliminate(Colour col)
    {
        int slotp = 0;
        int resultp = 0;
        boolean equalNumber = false;
        //checks if the number of occurences of the same colour in the guess's array are equal to the number of occurences of the same colour in the result's array
        for(int i = 0; i < colourSlot.length; i++)
        {
            if(colourSlot[i] == col)
                slotp++;
        }
        for(int i = 0; i < result.length; i++)
        {
            if(result[i] == col)
                resultp++;
        }
        if(slotp == resultp)
            equalNumber = true;
        
        //"blocks"/makes the certain colour unavailable
        for(int i = 0; i < colourSlot.length; i++)
        {
            if(colourSlot[i] == col)
            {
                 availableGue[i] = true;
                 if(equalNumber == true)
                    break;
            }
        }
        for(int i = 0; i < result.length; i++)
        {
            if(result[i] == col)
            {
                availableRe[i] = true;
                if(equalNumber == true)
                    break;
            }
        }
    }
    
    public void setAttempts()
    {
        attemptLabel.setFont(attemptLabel.getFont().deriveFont((float) 20));
        if(attempts < 10)
            attemptLabel.setText("Attempts:  " + attempts);
        else
            attemptLabel.setText("Attempts: " + attempts);
    }
}