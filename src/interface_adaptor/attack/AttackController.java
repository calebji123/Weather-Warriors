package interface_adaptor.attack;

import use_case.attack.AttackInputBoundary;
import use_case.attack.AttackInputData;

public class AttackController {
    final AttackInputBoundary attackUseCaseInteractor;

    public AttackController(AttackInputBoundary attackUseCaseInteractor) {
        this.attackUseCaseInteractor = attackUseCaseInteractor;
    }
    public void execute(Integer attackId) {
        AttackInputData attackInputData = new AttackInputData(attackId);

        attackUseCaseInteractor.execute(attackInputData);
    }
}
