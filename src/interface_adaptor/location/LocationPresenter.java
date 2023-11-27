package interface_adaptor.location;

import interface_adaptor.game.GameState;
import interface_adaptor.game.GameViewModel;
import use_case.location.LocationOutputBoundary;
import use_case.location.LocationOutputData;

public class LocationPresenter implements LocationOutputBoundary {
    private final GameViewModel gameViewModel;

    public LocationPresenter(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }

    public void prepareView(LocationOutputData locationOutputData) {
        GameState gameState = gameViewModel.getState();
        gameState.setLocation(locationOutputData.getLocationName());
        gameState.setTemperature(locationOutputData.getTemperature());
        gameState.setNextLocation(locationOutputData.getNextLocationName());
        gameViewModel.setState(gameState);
        gameViewModel.firePropertyChanged();
    }
}
