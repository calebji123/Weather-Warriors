package use_case.start;
import entity.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class StartInteractor implements StartInputBoundary {
    //call data access objects for relevant info
    //Make sure the right things are initialized like attack and everything
    //Build deck
    //Set environment
    //Choose opponent
    private final int deckSize = 5;
    final StartDataAccessInterface cardDataAccesObject;
    public StartInteractor(StartDataAccessInterface startDataAccessInterface){
        this.cardDataAccesObject = startDataAccessInterface;
    }
    public void execute(){
        ArrayList<String> files = chooseCards();
        ArrayList<Card> cardList = new ArrayList<>();
        for (String card : files){

        }
    }
    private ArrayList<String> chooseCards(){
        String source = "src/data_files/cards/";
        String[] cardnames = {source + "card1.json", source + "card2.json",
                source + "card3.json", source + "card4.json",source + "card5.json",
                source + "card6.json", source + "card7.json", source + "card8.json",
                source + "card9.json", source + "card10.json"};
        ArrayList<String> output = new ArrayList<>();
        Random rand = new Random();
        for (int i = 9; i > 4; i--){
            output.add(cardnames[rand.nextInt(i)]);
        }
        return output;
    }
}
