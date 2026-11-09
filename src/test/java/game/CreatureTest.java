package game;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



public class CreatureTest {
    private World world;
    private Creature creature;

    @BeforeEach
    void setUp() {
        Tile[][][] tiles = new Tile[3][3][1];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tiles[x][y][0] = Tile.FLOOR;
            }
        }

        world = new World(tiles);

        creature = new Creature(world, '@', Color.GRAY, "josh", 100, 10, 5);

        creature.x = 1;
        creature.y = 1;
        creature.z = 0;
    }

    @ParameterizedTest
    @CsvSource ({
        "1","10","100"
    })
    void testModifyHpPosotive(int amount) {
        int initialHp = creature.hp();

        int _amount = amount;

        creature.modifyHp(_amount, "");

        int expectedHp = (initialHp + _amount >= creature.maxHp()) ? creature.maxHp() : initialHp + _amount;
        

        assertTrue(expectedHp == creature.hp());
    }

    @ParameterizedTest
    @CsvSource ({
        "-1","-10","-100","-999"
    })
    void testModifyHpNegative(int amount) {
        int initialHp = creature.hp();

        int _amount = amount;

        creature.modifyHp(_amount, "");

        int expectedHp = (initialHp + _amount >= creature.maxHp()) ? creature.maxHp() : initialHp + _amount;
        
        if(initialHp <= _amount * -1){
            assertTrue(CombatRules.isDead(creature.hp()));
        }
        assertTrue(expectedHp == creature.hp());
    }




    // @Test
    // void testArmor() {

    // }

    // @Test
    // void testAttackValue() {

    // }

    // @Test
    // void testCanEnter() {

    // }

    // @Test
    // void testCanSee() {

    // }

    // @Test
    // void testCastSpell() {

    // }

    // @Test
    // void testCauseOfDeath() {

    // }

    // @Test
    // void testColor() {

    // }

    // @Test
    // void testCreature() {

    // }

    // @Test
    // void testDefenseValue() {

    // }

    // @Test
    // void testDetails() {

    // }

    // @Test
    // void testDig() {

    // }

    // @Test
    // void testDoAction() {

    // }

    // @Test
    // void testDoAction2() {

    // }

    // @Test
    // void testDrop() {

    // }

    // @Test
    // void testEat() {

    // }

    // @Test
    // void testEffects() {

    // }

    // @Test
    // void testEquip() {

    // }

    // @Test
    // void testFood() {

    // }

    // @Test
    // void testGainXp() {

    // }

    // @Test
    // void testGlyph() {

    // }

    // @Test
    // void testHp() {

    // }

    // @Test
    // void testInventory() {

    // }

    // @Test
    // void testIsPlayer() {

    // }

    // @Test
    // void testItem() {

    // }

    // @Test
    // void testLearnName() {

    // }

    // @Test
    // void testLevel() {

    // }

    // @Test
    // void testMana() {

    // }

    // @Test
    // void testMaxFood() {

    // }

    // @Test
    // void testMaxHp() {

    // }

    // @Test
    // void testMaxMana() {

    // }

    // @Test
    // void testMeleeAttack() {

    // }

    // @Test
    // void testModifyAttackValue() {

    // }

    // @Test
    // void testModifyDefenseValue() {

    // }

    // @Test
    // void testModifyDetectCreatures() {

    // }

    // @Test
    // void testModifyFood() {

    // }

    // @Test
    // void testModifyHp() {

    // }

    // @Test
    // void testModifyMana() {

    // }

    // @Test
    // void testModifyMaxHp() {

    // }

    // @Test
    // void testModifyMaxMana() {

    // }

    // @Test
    // void testModifyRegenHpPer1000() {

    // }

    // @Test
    // void testModifyRegenManaPer1000() {

    // }

    // @Test
    // void testModifyVisionRadius() {

    // }

    // @Test
    // void testModifyXp() {

    // }

    // @Test
    // void testMoveBy() {

    // }

    // @Test
    // void testName() {

    // }

    // @Test
    // void testNameOf() {

    // }

    // @Test
    // void testNotify() {

    // }

    // @Test
    // void testPickup() {

    // }

    // @Test
    // void testQuaff() {

    // }

    // @Test
    // void testRangedWeaponAttack() {

    // }

    // @Test
    // void testRealTile() {

    // }

    // @Test
    // void testSetCreatureAi() {

    // }

    // @Test
    // void testSummon() {

    // }

    // @Test
    // void testThrowItem() {

    // }

    // @Test
    // void testTile() {

    // }

    // @Test
    // void testUnequip() {

    // }

    // @Test
    // void testUpdate() {

    // }

    // @Test
    // void testVisionRadius() {

    // }

    // @Test
    // void testWeapon() {

    // }

    // @Test
    // void testXp() {

    // }
}
