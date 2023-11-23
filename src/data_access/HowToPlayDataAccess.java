package data_access;
import java.io.*;

public class HowToPlayDataAccess {
    private final String outputText;
    public HowToPlayDataAccess() throws IOException{
        String filepath = "src/data_files/HowToPlay";
        File howToPlay = new File(filepath);
        try(BufferedReader reader = new BufferedReader(new FileReader(howToPlay))){
            StringBuilder output = new StringBuilder();
            String row;
            while ((row = reader.readLine()) != null){
                output.append(row);
            }
            this.outputText = output.toString();
        }
    }

    public String getOutputText() {
        return outputText;
    }
}
