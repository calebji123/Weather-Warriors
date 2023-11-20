package interface_adaptor.end_turn;

public class EndTurnController {
    private EndTurnState state;
    private EndTurnPresenter presenter;

    public EndTurnController(EndTurnState state, EndTurnPresenter presenter) {
        this.state = state;
        this.presenter = presenter;
    }

    public void execute() {

    }
}
