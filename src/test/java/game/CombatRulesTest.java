package game;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import asciiPanel.AsciiPanel;

public class CombatRulesTest {
    
    private World world;
    private Tile[][][] tiles;
    private Creature[] creatures;
    
    private Creature fungus;
    private Creature bat;
    private Creature zombie;
    private Creature goblin;

    private int FungusCurrentHp;
    private int FungusMaxHp;
    private int BatCurrentHp;
    private int BatMaxHp;
    private int ZombieCurrentHp;
    private int ZombieMaxHp;
    private int GoblinCurrentHp;
    private int GoblinMaxHp;


    @BeforeEach
    void setUp() {
        tiles = new Tile[10][10][1];
        world = new World(tiles);
        fungus = new Creature(world, 'f', AsciiPanel.brightGreen, "fungus", 100, 2, 1);
        bat = new Creature(world, 'b', AsciiPanel.brightYellow, "bat", 100, 5, 0);
        zombie = new Creature(world, 'z', AsciiPanel.white, "zombie", 100, 10, 10);
        goblin = new Creature(world, 'g', AsciiPanel.brightGreen, "goblin", 100, 15, 5);
        
        FungusCurrentHp = fungus.hp();
        FungusMaxHp = fungus.maxHp();
        BatCurrentHp = bat.hp();
        BatMaxHp = bat.maxHp();
        ZombieCurrentHp = zombie.hp();
        ZombieMaxHp = zombie.maxHp();
        GoblinCurrentHp = goblin.hp();
        GoblinMaxHp = goblin.maxHp();

    }

    @AfterEach
    void tearDown() {
        world = null;
        tiles = null;
        fungus = null;
        bat = null;
        zombie = null;
        goblin = null;

        FungusCurrentHp = 0;
        FungusMaxHp = 0;
        BatCurrentHp = 0;
        BatMaxHp = 0;
        ZombieCurrentHp = 0;
        ZombieMaxHp = 0;
        GoblinCurrentHp = 0;
        GoblinMaxHp = 0;
    }
    
    @ParameterizedTest
    @CsvSource ({
        "1", "10", "15", "50", "66"
    })
    void testCalculateNewHpPosotiveChanges(int amount) {
        // Test positive changes to HP
        assertTrue(CombatRules.calculateNewHp(FungusCurrentHp, FungusMaxHp, amount) == ((FungusCurrentHp + amount) <= FungusMaxHp ? FungusCurrentHp + amount : FungusMaxHp));
        assertTrue(CombatRules.calculateNewHp(BatCurrentHp,BatMaxHp, amount) == ((BatCurrentHp + amount) <= BatMaxHp? BatCurrentHp + amount : BatMaxHp));
        assertTrue(CombatRules.calculateNewHp(ZombieCurrentHp, ZombieMaxHp, amount) == ((ZombieCurrentHp + amount) <= ZombieMaxHp? ZombieCurrentHp + amount : ZombieMaxHp));
        assertTrue(CombatRules.calculateNewHp(GoblinCurrentHp, GoblinMaxHp, amount) == ((GoblinCurrentHp + amount) <= GoblinMaxHp? GoblinCurrentHp + amount : GoblinMaxHp));
    }

    @ParameterizedTest
    @CsvSource ({
        "-1", "-10", "-15", "-50", "-66"
    })
    void testCalculateNewHpNegativeChanges(int amount) {
        // Test Negative changes to HP
        assertTrue(CombatRules.calculateNewHp(FungusCurrentHp, FungusMaxHp, amount) == ((FungusCurrentHp + amount) >= 0 ? FungusCurrentHp + amount : 0));
        assertTrue(CombatRules.calculateNewHp(FungusCurrentHp, FungusMaxHp, amount) == ((FungusCurrentHp + amount) <= FungusMaxHp ? FungusCurrentHp + amount : FungusMaxHp));

        assertTrue(CombatRules.calculateNewHp(BatCurrentHp, BatMaxHp, amount) == ((BatCurrentHp + amount) >= 0 ? BatCurrentHp + amount : 0));
        assertTrue(CombatRules.calculateNewHp(BatCurrentHp, BatMaxHp, amount) == ((BatCurrentHp + amount) <= BatMaxHp ? BatCurrentHp + amount : BatMaxHp));

        assertTrue(CombatRules.calculateNewHp(ZombieCurrentHp, ZombieMaxHp, amount) == ((ZombieCurrentHp + amount) >= 0 ? ZombieCurrentHp + amount : 0));
        assertTrue(CombatRules.calculateNewHp(ZombieCurrentHp, ZombieMaxHp, amount) == ((ZombieCurrentHp + amount) <= ZombieMaxHp ? ZombieCurrentHp + amount : ZombieMaxHp));


        assertTrue(CombatRules.calculateNewHp(GoblinCurrentHp, GoblinMaxHp, amount) == ((GoblinCurrentHp + amount) >= 0 ? GoblinCurrentHp + amount : 0));
        assertTrue(CombatRules.calculateNewHp(GoblinCurrentHp, GoblinMaxHp, amount) == ((GoblinCurrentHp + amount) <= GoblinMaxHp ? GoblinCurrentHp + amount : GoblinMaxHp));
    }

    @ParameterizedTest
    @CsvSource ({
        "-150", "-100"
    })
    void testCalculateNewHpNegativeToKill(int amount) {
        assertTrue(CombatRules.isDead(CombatRules.calculateNewHp(FungusCurrentHp, FungusMaxHp, amount)));
        assertTrue(CombatRules.isDead(CombatRules.calculateNewHp(BatCurrentHp, BatMaxHp, amount)));
        assertTrue(CombatRules.isDead(CombatRules.calculateNewHp(ZombieCurrentHp, ZombieMaxHp, amount)));
        assertTrue(CombatRules.isDead(CombatRules.calculateNewHp(GoblinCurrentHp, GoblinMaxHp, amount)));
    }

    @ParameterizedTest
    @CsvSource ({
        "0", "-1", "-100000"
    })
    void testIsDead(int deadHealth) {
        assertTrue(CombatRules.isDead(deadHealth));        
    }
}
