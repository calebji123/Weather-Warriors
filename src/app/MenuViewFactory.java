package app;

import interface_adaptor.ViewManagerModel;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.how_to_play.HowToPlayController;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import interface_adaptor.start.StartController;
import use_case.how_to_play.HowToPlayDataAccessInterface;
import use_case.start.StartDataAccessInterface;
import view.MenuView;

import static app.HowToPlayUseCaseFactory.createHowToPlayUseCase;

public class MenuViewFactory {
    public static MenuView create(HowToPlayViewModel howToPlayViewModel,
                                  HowToPlayDataAccessInterface howToPlayDataAccessObject,
                                  StartDataAccessInterface startDataAccessObject,
                                  ViewManagerModel viewManagerModel, GameViewModel gameViewModel) {
        HowToPlayController howToPlayController = createHowToPlayUseCase(howToPlayViewModel, howToPlayDataAccessObject);
        StartController startController = StartUseCaseFactory.createStartUseCase(startDataAccessObject, viewManagerModel, gameViewModel);
        return new MenuView(howToPlayController, howToPlayViewModel, startController);
    }
}
