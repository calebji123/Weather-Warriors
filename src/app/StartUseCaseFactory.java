package app;

import interface_adaptor.ViewManagerModel;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.start.StartController;
import interface_adaptor.start.StartPresenter;
import interface_adaptor.start.StartViewModel;
import use_case.start.StartDataAccessInterface;
import use_case.start.StartInputBoundary;
import use_case.start.StartInteractor;
import use_case.start.StartOutputBoundary;

public class StartUseCaseFactory {

    public static StartController createStartUseCase(StartDataAccessInterface startDataAccessObject, ViewManagerModel viewManagerModel, GameViewModel gameViewModel) {
        StartOutputBoundary startOutputBoundary = new StartPresenter(gameViewModel, viewManagerModel);
        StartInputBoundary startInteractor = new StartInteractor(startDataAccessObject, startOutputBoundary);
        return new StartController(startInteractor);
    }
}
