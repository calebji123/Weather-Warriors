package use_case.attack;

public class AttackInteractor implements AttackInputBoundary{
    final AttackDataAccessObject userDataAccessObject;
    final AttackOutputBoundary attackPresenter;

    public AttackInteractor(AttackDataAccessObject userDataAccessObject, AttackOutputBoundary attackPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.attackPresenter = attackPresenter;
    }

    @Override
    public void execute(AttackInputData attackInputData) {
//        TODO
    }
}
