import java.util.ArrayList;
public class world {
    
    public room[] setWorld() {
        room[] dungeon = new room[] {
            new room("Broken Stairs", "Cracked steps descend into the earth. The air grows colder with every breath.", 0, 0, false, false, true, false ),
            new room("Wet Corridor", "Water drips from the ceiling. Your footsteps echo too loudly in the narrow hall.", 1, 1, false, false, false, false ),
            new room("Rust Cells", "Bent prison bars and old chains sway slightly, though there is no wind.", 2, 2, false, false, false, false ),
            new room("Forgotten Shrine", "A shattered statue kneels before an altar. Melted candles suggest someone prayed here recently.", 3, 1, false, false, false, false  ),
            new room("Broken Stairs", "Cracked steps descend into the earth. The air grows colder with every breath.", 4, 3, false, false, false, true  ),
            new room("Broken Stairs", "Cracked steps descend into the earth. The air grows colder with every breath.", 5, 1, false, false, false, false  ),
            new room("Broken Stairs", "Cracked steps descend into the earth. The air grows colder with every breath.", 6, 6, false, false , true, true ),
            new room("Broken Stairs", "Cracked steps descend into the earth. The air grows colder with every breath.", 7, 0, true, true , false, false ),
        };
        return dungeon;
    }
}
