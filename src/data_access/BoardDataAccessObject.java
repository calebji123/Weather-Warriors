package data_access;

import api.WeatherAPI;
import entity.*;
import entity.enemies.TimeTravelingPoacher;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import use_case.attack.AttackDataAccessInterface;
import use_case.end_turn.EndTurnDataAccessInterface;
import use_case.location.LocationDataAccessInterface;
import use_case.start.StartDataAccessInterface;
import use_case.swap.SwapDataAccessInterface;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BoardDataAccessObject implements EndTurnDataAccessInterface, AttackDataAccessInterface, SwapDataAccessInterface, LocationDataAccessInterface, StartDataAccessInterface {
    private ArrayList<Card> cardList;
    private Board board;
    private String log;

    public BoardDataAccessObject() throws IOException, ParseException {
        String source = "src/data_files/cards/";
        String[] cardnames = {source + "card1.json", source + "card2.json",
                source + "card3.json", source + "card4.json", source + "card5.json",
                source + "card6.json", source + "card7.json", source + "card8.json",
                source + "card9.json", source + "card10.json"};
        cardList = new ArrayList<>();
        for (String card : cardnames) {
            cardList.add(readCard(card));
        }
    }

    private Card readCard(String filename) throws IOException, ParseException {
        Object o = new JSONParser().parse(new FileReader(filename));
        JSONObject j = (JSONObject) o;
        Integer HP = Integer.parseInt((String) j.get("HP"));
        String CardName = (String) j.get("Name") ;
        int atk = Integer.parseInt((String) j.get("Attack"));
        int code = Integer.parseInt((String) j.get("Modifier code"));
        return new Card(CardName, atk, code, HP);
    }

    @Override
    public void initializeBoard() {
        Random rand = new Random();
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 9; i >=5; i--){
            cards.add(cardList.get(rand.nextInt(i)));
        }
        Deck deck = new Deck(cards);
        Opponent enemy = new TimeTravelingPoacher();
        Location place = new Location("Toronto", 0.0, 0.0, 5, 30, "Montreal");
        WeatherResponse weather = WeatherAPI.getWeather(place.getLatitude(), place.getLongitude());
        place.setTemperature(new Double(weather.getMain().getTemp()).intValue());
        board = new Board(deck, enemy, place);
    }

    @Override
    public Deck getDeck() {
        return board.getDeck();
    }

    @Override
    public Card getNextCard() {
        return board.getDeck().getNext();
    }

    @Override
    public Boolean nextCardExists() {
        return board.getDeck().hasNext();
    }

    @Override
    public Card getActiveCard() {
        return board.getDeck().getActive();
    }

    public Board getBoard() {
        return this.board;
    }

    @Override
    public void saveToLog(String message) {
        this.log += message;
    }

    @Override
    public Location getLocation() {
        return this.board.getLocation();
    }
}
