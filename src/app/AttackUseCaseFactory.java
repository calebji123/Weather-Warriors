package app;

import interface_adaptor.attack.AttackController;
import interface_adaptor.attack.AttackPresenter;
import interface_adaptor.game.GameViewModel;
import use_case.attack.AttackDataAccessInterface;
import use_case.attack.AttackInputBoundary;
import use_case.attack.AttackInteractor;
import use_case.attack.AttackOutputBoundary;

public class AttackUseCaseFactory {

    public static AttackController createAttackUseCase(AttackDataAccessInterface attackDataAccessObject, GameViewModel gameViewModel){
        AttackOutputBoundary attackOutputBoundary = new AttackPresenter(gameViewModel);
        AttackInputBoundary attackInteractor = new AttackInteractor(attackDataAccessObject, attackOutputBoundary);
        return new AttackController(attackInteractor);
    }
}
