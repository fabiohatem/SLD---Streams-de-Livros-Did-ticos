import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class Crawler {
    
    public static void main(String[] args) {
        String s = "https://www.clubeextra.com.br/busca?terms=trigo&p=1";
        String rawHTML = "";
        try{
            // create url with the string.
            URL url = new URL(s);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = in.readLine();

            // read every line of the HTML content in the URL
            // and concat each line to the rawHTML string until every line is read.
            while(inputLine  != null){
                rawHTML += inputLine;

                inputLine = in.readLine();
            }
            in.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        try (PrintWriter writer = new PrintWriter("local")) {
            writer.write(rawHTML);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(rawHTML);
    }

}
