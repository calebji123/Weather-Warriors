package entity;

public class Card {
    private Integer HP;
    private final String CardName;
    protected Attack regularAttack;
    protected Attack specialAttack;
    private boolean isDead;
    private boolean isActive;
    private boolean isNext;
    public Card(String Name, Attack rAttack, Attack sAttack, Integer hp){
        this.CardName = Name;
        this.regularAttack = rAttack;
        this.specialAttack = sAttack;
        this.isActive = false;
        this.isNext = false;
        this.isDead = false;
        this.HP = hp;
    }


    public String getCardName(){return CardName;}
    public Integer getHP(){return HP;}
    public Boolean getDeathStatus(){return isDead;}
    public Boolean getActiveStatus(){return isActive;}
    public Boolean getNextStatus(){return isNext;}
    public Attack  getRegularAttack(){return regularAttack;}
    public Attack getSpecialAttack(){return specialAttack;}
    public void setHP (int dmg){this.HP -= dmg;}
    public void die(){this.isDead = true;}
    public void activate(){this.isActive = true;}
    public void makeNext(){this.isNext = true;}
}
