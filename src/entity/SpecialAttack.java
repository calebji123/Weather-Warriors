package entity;

public class SpecialAttack extends Attack{
    private int modifier;
    private int specialDmg;
    private String name;
    private final int code;
    public SpecialAttack(int dmg, int code) {
        super(dmg);
        this.code = code;
        this.modify();
        this.specialDmg = this.specialDmg();
    }

    public void refresh(){
        this.modify();
    }

    private void modify(){
        if (this.code == 1){
            this.modifier = 0;
        } else if (this.code == 2){

        }
        //etc.
        //todo when cards and api calls are finalized
    }
    private int specialDmg(){
        return this.getDmg() + this.modifier;
        //not exactly this but close
    }
    public int getSpecialDmg(){return this.specialDmg;}
    public String getSpName(){return this.name;}
}
