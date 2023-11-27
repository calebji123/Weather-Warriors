package data_access;

import entity.Card;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class StartDataAccessObject {
    private final Card card;

    public StartDataAccessObject(String filename) throws IOException, ParseException {
        //read json
        // turn into variables
        // save variables??
        //at somepoint some of the input has to do something but idk when
        Object o = new JSONParser().parse(new FileReader(filename));
        JSONObject j = (JSONObject) o;
        Integer HP = Integer.parseInt((String) j.get("HP"));
        String CardName = (String) j.get("Name") ;
        int atk = Integer.parseInt((String) j.get("Attack"));
        int code = Integer.parseInt((String) j.get("Modifier code"));
        this.card = new Card(CardName, atk, code, HP);

    }
    public Card getCard(){return this.card;}

//    public static void main(String[] args) throws IOException, ParseException {
//        StartDataAccessObject o = new StartDataAccessObject("src/data_files/cards/Card1.json");
//        System.out.println(o.getCard().getCardName());
//    }
}
