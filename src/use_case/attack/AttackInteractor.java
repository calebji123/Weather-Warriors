package use_case.attack;

import entity.Attack;
import entity.Card;

public class AttackInteractor implements AttackInputBoundary{
    final AttackDataAccessObject dataAccessObject;
    final AttackOutputBoundary attackPresenter;

    public AttackInteractor(AttackDataAccessObject dataAccessObject, AttackOutputBoundary attackPresenter) {
        this.dataAccessObject = dataAccessObject;
        this.attackPresenter = attackPresenter;
    }

    @Override
    public void execute(AttackInputData attackInputData) {
        Integer attackId = attackInputData.getAttackIdentifier();
        String cardName = attackInputData.getCardName();
        Card card = dataAccessObject.getCard(cardName);
        Card opponent = dataAccessObject.getCard("Boss");

        if (attackId == 0) {
            Attack attack = card.getRegularAttack();
        } else {
            Attack attack = card.getSpecialAttack();
        }
        Integer damage = attack.getDmg;
        opponent.setHP(opponent.getHP() - damage);

        String message = card.getCardName() + "attacked Boss! Boss took " + Integer.toString(attack.getDmg())
                + "damage!";
        dataAccessObject.saveToLog(message);

        AttackOutputData attackOutputData = new AttackOutputData(message, damage, card.getHP(), opponent.getHP(),
                false);
        if (opponent.getHP() <= 0) {
            String deathMessage = "Boss has been defeated!";
            opponent.die();
            attackOutputData.setMessage(message + "\n" + deathMessage);
            attackOutputData.gameOver();

        }
    }
}
