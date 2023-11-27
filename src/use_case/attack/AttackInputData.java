package use_case.attack;

public class AttackInputData {
    final private Integer attackIdentifier;

    public AttackInputData(Integer attack) {
        this.attackIdentifier = attack;
    }
    public Integer getAttackIdentifier() {return this.attackIdentifier;}
}
