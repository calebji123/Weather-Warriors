package use_case.attack;

import entity.Attack;
import entity.Card;

public class AttackInteractor implements AttackInputBoundary{
    final AttackDataAccessObject dataAccessObject;
    final AttackOutputBoundary attackPresenter;

    public AttackInteractor(AttackDataAccessObject userDataAccessObject, AttackOutputBoundary attackPresenter) {
        this.dataAccessObject = userDataAccessObject;
        this.attackPresenter = attackPresenter;
    }

    @Override
    public void execute(AttackInputData attackInputData) {
        Integer attackId = attackInputData.getAttackIdentifier();
        String cardName = attackInputData.getCardName();
        Card card = dataAccessObject.getCard(cardName);
        Card opponent = dataAccessObject.getCard("Boss");
        Attack attack;
        if (attackId == 0) {
            attack = card.getRegularAttack();
        } else {
            attack = card.getSpecialAttack();
        }
        Integer damage = attack.getDmg();
        opponent.setHP(opponent.getHP() - damage);

        String message = card.getCardName() + "attacked Boss! Boss took " + Integer.toString(damage)
                + "damage!";
        dataAccessObject.saveToLog(message);

        AttackOutputData attackOutputData = new AttackOutputData(message, damage, card.getHP(), opponent.getHP());
        if (opponent.getHP() <= 0) {
            String deathMessage = "Boss has been defeated!";
            opponent.die();
            attackOutputData.setMessage(message + "\n" + deathMessage);
            attackOutputData.setGameOver();
        }


    }
}
