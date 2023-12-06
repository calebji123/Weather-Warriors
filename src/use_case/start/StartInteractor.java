package use_case.start;
import data_access.StartDataAccessObject;
import entity.*;
import entity.enemies.TimeTravelingPoacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class StartInteractor implements StartInputBoundary {
    //call data access objects for relevant info
    //Make sure the right things are initialized like attack and everything
    //Build deck
    //Set environment
    //Choose opponent
    private final int deckSize = 5;
    final StartDataAccessInterface dataAccessObject;
    final StartOutputBoundary presenter;
    public StartInteractor(StartDataAccessInterface startDataAccessInterface, StartOutputBoundary presenter){
        this.dataAccessObject = startDataAccessInterface;
        this.presenter = presenter;
    }
    public void execute() {
        dataAccessObject.initializeBoard();
        Board board = dataAccessObject.getBoard();
        Deck deck = board.getDeck();
        Card active = deck.getActive();
        Location location = board.getLocation();
        StartOutputData startOutputData = new StartOutputData(active.getCardName(), active.getHP(), board.getOpponent().getHP(), deck.getNext().getCardName(), location.getLocationName(), location.getTemperature(), location.getNextLocationName());
        presenter.prepareSuccessView(startOutputData);
    }
}
