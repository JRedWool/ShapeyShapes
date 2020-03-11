import java.util.ArrayList;

public class STATS {

    Board board;
    private static int numFood = 5;
    private static int numEnemies = 2;
    private static int life = 3;
    private static int level = 0;
    private static int lowSpeed = 4;
    private static int rangeSpeed = 8;
    private static int currentFood;

    public static int getFoodCurrent(ArrayList<Sprite> actors){
        currentFood = 0;
        for(int i = 0; i < actors.size(); i++){
            if(actors.get(i) instanceof Food){
                currentFood++;
            }
        }
        return currentFood;
    }





    public static int getNumFood() {
        return numFood;
    }

    public static void setNumFood(int numFood) {
        STATS.numFood = numFood;
    }

    public static int getNumEnemies() {
        return numEnemies;
    }

    public static void setNumEnemies(int numEnemies) {
        STATS.numEnemies = numEnemies;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        STATS.life = life;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        STATS.level = level;
    }

    public static int getLowSpeed() {
        return lowSpeed;
    }

    public static void setLowSpeed(int lowSpeed) {
        STATS.lowSpeed = lowSpeed;
    }

    public static int getRangeSpeed() {
        return rangeSpeed;
    }

    public static void setRangeSpeed(int rangeSpeed) {
       STATS.rangeSpeed = rangeSpeed;
    }


    public static void updateLevel(){
        level++;
        switch(level){
            case 1:
                setNumFood(5);
                setNumEnemies(2);
                setLowSpeed(3);
                setRangeSpeed(3);
                break;
            case 2:
                setNumFood(7);
                setNumEnemies(3);
                setLowSpeed(3);
                setRangeSpeed(3);
                break;
            case 3:
                setNumFood(9);
                setNumEnemies(4);
                setLowSpeed(4);
                setRangeSpeed(4);
                break;


        }

        System.out.println(lowSpeed + " " + rangeSpeed);
    }


}
