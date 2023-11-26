package interface_adaptor.attack;

import use_case.attack.AttackOutputData;

public class AttackPresenter {
    private final AttackViewModel viewModel;

    public AttackPresenter(AttackViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void prepareSuccessView(AttackOutputData outputData) {
        AttackState state = new AttackState();
        state.setMessage(outputData.getMessage());
        state.setActiveCardName(outputData.getActiveCardName());
        state.setActiveCardHealth(outputData.getActiveCardHealth());
        state.setBossHealth(outputData.getBossHealth());
        state.setGameOver(outputData.getGameOver());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }
}
