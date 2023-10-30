package use_case.attack;

public class AttackInputData {
    final private String attack;
    final private String specialAttack;


    public AttackInputData(String attack, String specialAttack) {
        this.attack = attack;
        this.specialAttack = specialAttack;
    }
    public String getAttack() {return this.attack;}
    public String getSpecial() {return this.specialAttack;}
}
