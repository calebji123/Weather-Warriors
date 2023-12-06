package use_case.location;

import entity.*;
import entity.enemies.TimeTravelingPoacher;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.location.LocationController;
import interface_adaptor.location.LocationPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationUseCaseInteractorTest {
    private LocationInteractor locationInteractor;
    private LocationController locationController;
    private LocationPresenter locationPresenter;
    private GameViewModel viewModel;
    private Board board;
    private Deck deck;
    private Card card;
    private Opponent opponent;

    @BeforeEach
    void setup() {
        opponent = new TimeTravelingPoacher();
        card = new Card("Derk", 1, 2, 100);
        List<Card> list = new ArrayList<>();
        list.add(card);
        deck = new Deck(list);
        board = new Board(deck, opponent, new Location("Uoft",0.0,0.0,0,0,
                "UTM", 0.0, 0.0));

        class MockDataAccess implements LocationDataAccessInterface {
            @Override
            public Location getLocation() {
                return board.getLocation();
            }

            @Override
            public void nextLocation() {
                board.setLocation(new Location("UTM", 0.0, 0.0, 5, 10,
                        "UTSC", 0.0, 0.0));
            }

            @Override
            public Integer getTurn() {
                return board.getTurn();
            }
        }
        viewModel = new GameViewModel();
        locationPresenter = new LocationPresenter(viewModel);
        MockDataAccess dataAccess = new MockDataAccess();
        locationInteractor = new LocationInteractor(dataAccess, locationPresenter);
        locationController = new LocationController(locationInteractor);
    }

    @Test
    void executeLocation() {
        locationController.execute();
        assertEquals("UTM", viewModel.getState().getLocation());
        assertEquals(5, viewModel.getState().getTemperature());
        assertEquals(10, viewModel.getState().getHumidity());
        assertEquals("UTSC", viewModel.getState().getNextLocation());
        assert(!viewModel.getState().getLog().isEmpty());
    }
}