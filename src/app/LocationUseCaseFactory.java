package app;

import interface_adaptor.game.GameViewModel;
import interface_adaptor.location.LocationController;
import interface_adaptor.location.LocationPresenter;
import use_case.location.LocationDataAccessInterface;
import use_case.location.LocationInputBoundary;
import use_case.location.LocationInteractor;
import use_case.location.LocationOutputBoundary;

public class LocationUseCaseFactory {

        public static LocationController createLocationUseCase(LocationDataAccessInterface locationDataAccessObject, GameViewModel gameViewModel){
            LocationOutputBoundary locationOutputBoundary = new LocationPresenter(gameViewModel);
            LocationInputBoundary locationInteractor = new LocationInteractor(locationDataAccessObject, locationOutputBoundary);
            return new LocationController(locationInteractor);
        }
}
