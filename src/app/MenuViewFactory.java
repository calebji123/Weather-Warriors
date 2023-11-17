package app;

import interface_adaptor.how_to_play.HowToPlayController;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import use_case.how_to_play.HowToPlayDataAccessInterface;
import view.MenuView;

import static app.HowToPlayUseCaseFactory.createHowToPlayUseCase;

public class MenuViewFactory {
    public static MenuView create(HowToPlayViewModel howToPlayViewModel, HowToPlayDataAccessInterface howToPlayDataAccessObject) {
        HowToPlayController howToPlayController = createHowToPlayUseCase(howToPlayViewModel, howToPlayDataAccessObject);
        return new MenuView(howToPlayController, howToPlayViewModel);
    }
}
