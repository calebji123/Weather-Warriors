package app;

import interface_adaptor.how_to_play.HowToPlayController;
import interface_adaptor.how_to_play.HowToPlayPresenter;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import use_case.how_to_play.HowToPlayDataAccessInterface;
import use_case.how_to_play.HowToPlayInputBoundary;
import use_case.how_to_play.HowToPlayInteractor;
import use_case.how_to_play.HowToPlayOutputBoundary;

public class HowToPlayUseCaseFactory {
    private HowToPlayUseCaseFactory() {}

    public static HowToPlayController createHowToPlayUseCase(HowToPlayViewModel howToPlayViewModel, HowToPlayDataAccessInterface howToPlayDataAccessObject){
        HowToPlayOutputBoundary howToPlayOutputBoundary = new HowToPlayPresenter(howToPlayViewModel);
        HowToPlayInputBoundary howToPlayInteractor = new HowToPlayInteractor(howToPlayDataAccessObject, howToPlayOutputBoundary);
        return new HowToPlayController(howToPlayInteractor);
    }
}
