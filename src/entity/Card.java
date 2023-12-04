package entity;

public class Card {
    private Integer HP;
    private final String CardName;
    protected Attack regularAttack;
    protected SpecialAttack specialAttack;
    private boolean isDead;
    private boolean isActive;
    private boolean isNext;
    public Card(String Name, int rAttack, int sAttackCode, Integer hp){
        this.CardName = Name;
        this.regularAttack = new Attack(rAttack);
        this.specialAttack = new SpecialAttack(rAttack, sAttackCode);
        this.isActive = false;
        this.isNext = false;
        this.isDead = false;
        this.HP = hp;
        this.regularAttack = new Attack(rAttack);
    }


    public String getCardName(){return CardName;}
    public Integer getHP(){return HP;}
    public Boolean getDeathStatus(){return isDead;}
    public Boolean getActiveStatus(){return isActive;}
    public Boolean getNextStatus(){return isNext;}
    public Attack  getRegularAttack(){return regularAttack;}
    public SpecialAttack getSpecialAttack(){return specialAttack;}
    public void setHP (int dmg){this.HP -= dmg;}
    public void die(){this.isDead = true;}
    public void activate(){this.isActive = true;}
    public void deactivate(){this.isActive = false;}
    public void makeNext(){this.isNext = true;}
}
