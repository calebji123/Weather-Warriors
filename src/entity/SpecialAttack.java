package entity;

public class SpecialAttack extends Attack{
    private int modifier;

    private final int code;
    public SpecialAttack(int dmg, int code) {
        super(dmg);
        this.code = code;
    }

    private int modify(Location location){
        if (this.code / 10 == 1){
            this.modifier = this.code % 10 * location.getModifiedTemperature(); // + something based on the location
        } else if (this.code / 10 == 2){
            this.modifier = this.code % 10 * location.getModifiedHumidity();
//        } else if (this.code / 10 == 3){
            //this.modifier = this.code % 10 * location.getWind();
  //      } else if (this.code / 10 == 4){
            //this.modifier = this.code % 10 * location.getAirPressure();
    //    } else if (this.code / 10 == 5){
            //this.modifier = this.code % 10 * location.getSeaLevel();
        } else if (this.code / 10 == 6){
            this.modifier = this.code % 10 * location.getModifiedTemperature() * -1;
        } else if (this.code / 10 == 7) {
            this.modifier = this.code % 10 * location.getModifiedHumidity() * -1;
        }
        return Math.max(this.dmg + this.modifier, 1);
    }

    public Integer modified(Location location){
        return modify(location);
    }

}
