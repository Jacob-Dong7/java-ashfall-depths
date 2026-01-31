import java.util.ArrayList;

public class room {
    String description, name;
    int location, enemyCount;
    boolean boss, exit, heal, strength;

    public room(String name, String description, int location, int count, boolean boss, boolean exit, boolean heal, boolean strength) {
        this.name = name;
        this.description = description;
        this.location = location;
        enemyCount = count;
        this.boss = boss;
        this.exit = exit;
        this.heal = heal;
        this.strength = strength;
    }


}
