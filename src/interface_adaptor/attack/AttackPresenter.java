package interface_adaptor.attack;

import interface_adaptor.ViewManagerModel;
import use_case.attack.AttackOutputBoundary;
import use_case.attack.AttackOutputData;

public class AttackPresenter implements AttackOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AttackViewModel attackViewModel;
    public AttackPresenter(ViewManagerModel viewManagerModel, AttackViewModel attackViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.attackViewModel = attackViewModel;
    }
    @Override
    public void prepareSuccessView(AttackOutputData attackOutputData) {
        AttackState attackState = attackViewModel.getState();
        attackState.setMessage(attackOutputData.getMessage());
        attackState.setDamage(attackOutputData.getDamage());
        attackState.setActiveCardHealth(attackOutputData.getActiveCardHealth());
        attackState.setBossHealth(attackOutputData.getBossHealth());

        if (attackOutputData.gameOver()) {
            attackState.setGameOver();
        }

        attackViewModel.firePropertyChanged();
    }
}
