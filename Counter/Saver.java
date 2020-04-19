import java.io.*;

class Saver
{
    public String read(){
        try{
            FileReader fr = new FileReader("number.txt");
            BufferedReader br = new BufferedReader(fr);
            return br.readLine();     
        }
        catch(IOException e){
            return "";
        }
    }
    
    public String read1(){
        try{
            FileReader fr = new FileReader("score.txt");
            BufferedReader br = new BufferedReader(fr);  
            return br.readLine();     
        }
        catch(IOException e){
            return "";
        }
    }

    public void write(String text){
        try{
            FileWriter fw = new FileWriter("number.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        }
        catch(IOException e){}
    }
    
    public void write1(String text){
        try{
            FileWriter fw = new FileWriter("score.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        }
        catch(IOException e){}
    }
}