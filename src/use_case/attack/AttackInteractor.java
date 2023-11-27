package use_case.attack;

import entity.Attack;
import entity.Card;
import entity.Opponent;

public class AttackInteractor implements AttackInputBoundary{
    final AttackDataAccessInterface dataAccessObject;
    final AttackOutputBoundary attackPresenter;

    public AttackInteractor(AttackDataAccessInterface userDataAccessObject, AttackOutputBoundary attackPresenter) {
        this.dataAccessObject = userDataAccessObject;
        this.attackPresenter = attackPresenter;
    }

    @Override
    public void execute(AttackInputData attackInputData) {
        Integer attackId = attackInputData.getAttackIdentifier();
        Card card = dataAccessObject.getBoard().getDeck().getActive();
        Opponent opponent = dataAccessObject.getBoard().getOpponent();
        Attack attack;
        if (attackId == 0) {
            attack = card.getRegularAttack();
        } else {
            attack = card.getSpecialAttack();
        }
        Integer damage = attack.getDmg();
        opponent.changeHP(damage);

        String message = card.getCardName() + " attacked Boss! Boss took " + Integer.toString(damage)
                + " damage!";

        AttackOutputData attackOutputData = new AttackOutputData(message, opponent.getHP());
        if (opponent.getHP() <= 0) {
            String deathMessage = "Boss has been defeated!";
            attackOutputData.setMessage(message + "\r\n" + deathMessage);
            attackOutputData.setGameOver();
        }
        dataAccessObject.saveToLog(message);
        attackPresenter.prepareSuccessView(attackOutputData);
    }
}
