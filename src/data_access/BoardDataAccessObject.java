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
    private ArrayList<String> locations;
    private ArrayList<Double> latitudes;
    private ArrayList<Double> longitudes;
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
        locations = new ArrayList<>();
        latitudes = new ArrayList<>();
        longitudes = new ArrayList<>();
        String[] locationnames = {"Toronto", "Montreal", "Vancouver", "New York", "Los Angeles", "London", "Paris", "Tokyo", "Sydney", "Beijing"};
        Double[] latitudes = {43.6532, 45.5017, 49.2827, 40.7128, 34.0522, 51.5074, 48.8566, 35.6762, -33.8688, 39.9042};
        Double[] longitudes = {-79.3832, -73.5673, -123.1207, -74.0060, -118.2437, -0.1278, 2.3522, 139.6503, 151.2093, 116.4074};

        for (int i = 0; i < locationnames.length; i++) {
            this.locations.add(locationnames[i]);
            this.latitudes.add(latitudes[i]);
            this.longitudes.add(longitudes[i]);
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
            cards.add(cardList.remove(rand.nextInt(i)).cloneCard());
        }
        Deck deck = new Deck(cards);
        Opponent enemy = new TimeTravelingPoacher();
        int index = randomLocation("");
        WeatherResponse response = WeatherAPI.getWeather(latitudes.get(index), longitudes.get(index));
        int nextIndex = randomLocation(locations.get(index));
        Location place = new Location(locations.get(index), latitudes.get(index), longitudes.get(index), ((Double) (response.getMain().getTemp() - 273)).intValue(), response.getMain().getHumidity(), locations.get(nextIndex), latitudes.get(nextIndex), longitudes.get(nextIndex) );
        board = new Board(deck, enemy, place);
    }

    private int randomLocation(String currentLocation) {
        Random rand = new Random();
        int index = rand.nextInt(locations.size());
        while (locations.get(index).equals(currentLocation)) {
            index = rand.nextInt(locations.size());
        }
        return index;
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

    @Override
    public void nextLocation() {
        Double[] nextLocation = this.board.getLocation().getNextCoordinates();
        WeatherResponse response = WeatherAPI.getWeather(nextLocation[0], nextLocation[1]);
        int nextIndex = randomLocation(this.board.getLocation().getLocationName());
        Location place = new Location(this.board.getLocation().getNextLocationName(), nextLocation[0], nextLocation[1], ((Double) (response.getMain().getTemp()-273)).intValue(), response.getMain().getHumidity(), locations.get(nextIndex), latitudes.get(nextIndex), longitudes.get(nextIndex) );
        this.board.setLocation(place);
    }

    @Override
    public void addTurn() {
        this.board.setTurn(this.board.getTurn() + 1);
    }

    @Override
    public Integer getTurn() {
        return this.board.getTurn();
    }
}
