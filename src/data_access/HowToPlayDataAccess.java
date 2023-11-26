package data_access;
import use_case.how_to_play.HowToPlayDataAccessInterface;

import java.io.*;

public class HowToPlayDataAccess implements HowToPlayDataAccessInterface {
    private final String outputText;
    public HowToPlayDataAccess() throws IOException{
        String filepath = "src/data_files/HowToPlay";
        File howToPlay = new File(filepath);
        try(BufferedReader reader = new BufferedReader(new FileReader(howToPlay))){
            StringBuilder output = new StringBuilder();
            String row;
            while ((row = reader.readLine()) != null){
                row = "\r\n" + row;
                output.append(row);
            }
            this.outputText = output.toString();
        }
    }

    public String getHowToPlay() {
        return outputText;
    }
}
