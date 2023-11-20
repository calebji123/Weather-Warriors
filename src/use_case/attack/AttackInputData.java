package use_case.attack;

public class AttackInputData {
    final private Integer attackIdentifier;
    final private String cardName;


    public AttackInputData(Integer attack, String cardName) {
        this.attackIdentifier = attack;
        this.cardName = cardName;
    }
    public Integer getAttackIdentifier() {return this.attackIdentifier;}
    public String getCardName() {return this.cardName;}
}
