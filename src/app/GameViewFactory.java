package app;

import interface_adaptor.ViewManagerModel;
import interface_adaptor.attack.AttackController;
import interface_adaptor.attack.AttackViewModel;
import interface_adaptor.end_turn.EndTurnController;
import interface_adaptor.end_turn.EndTurnViewModel;
import interface_adaptor.exit.ExitController;
import interface_adaptor.exit.ExitViewModel;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.how_to_play.HowToPlayController;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import interface_adaptor.location.LocationController;
import interface_adaptor.location.LocationViewModel;
import interface_adaptor.swap.SwapController;
import interface_adaptor.swap.SwapViewModel;
import use_case.attack.AttackDataAccessInterface;
import use_case.end_turn.EndTurnDataAccessInterface;
import use_case.how_to_play.HowToPlayDataAccessInterface;
import use_case.location.LocationDataAccessInterface;
import use_case.swap.SwapDataAccessInterface;
import view.GameView;

public class GameViewFactory {
    public static GameView create(
                                  EndTurnDataAccessInterface endTurnDataAccessObject,
                                  HowToPlayViewModel howToPlayViewModel,
                                  HowToPlayDataAccessInterface howToPlayDataAccessObject,
                                  AttackDataAccessInterface attackDataAccessObject,
                                  SwapViewModel swapViewModel,
                                  SwapDataAccessInterface swapDataAccessObject,
                                  ExitViewModel exitViewModel,
                                  LocationDataAccessInterface locationDataAccessObject,
                                  ViewManagerModel viewManagerModel,
                                  GameViewModel gameViewModel) {
        EndTurnController endTurnController = EndTurnUseCaseFactory.createEndTurnUseCase( endTurnDataAccessObject, gameViewModel);
        HowToPlayController howToPlayController = HowToPlayUseCaseFactory.createHowToPlayUseCase(howToPlayViewModel, howToPlayDataAccessObject);
        AttackController attackController = AttackUseCaseFactory.createAttackUseCase(attackDataAccessObject, gameViewModel);
        SwapController swapController = SwapUseCaseFactory.createSwapUseCase(swapViewModel, swapDataAccessObject, gameViewModel);
        ExitController exitController = ExitUseCaseFactory.createExitUseCase(exitViewModel, viewManagerModel);
        LocationController locationController = LocationUseCaseFactory.createLocationUseCase(locationDataAccessObject, gameViewModel);
        return new GameView(endTurnController, howToPlayController, howToPlayViewModel, attackController, swapController, swapViewModel, exitController, exitViewModel, locationController, gameViewModel);
    }
}
