package game;


import java.awt.Color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest {
  private Inventory inventory1;
  private Inventory inventory2;
  private Inventory inventory_null;
  private Inventory inventory_full;
  private Item item_a;
  private Item item_b;

  @BeforeEach
  public void setUp() {
    inventory1 = new Inventory(5);
    inventory2 = new Inventory(10);

    inventory_null = new Inventory(0);

    inventory_full = new Inventory(2);

    item_a = (new Item((char) 1, Color.magenta, "Item1", "sharp"));
    item_b = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory_full.add(item_a);
    inventory_full.add(item_b);
  }

  @AfterEach
  public void tearDown() {
    inventory1 = null;
    inventory2 = null;
    inventory_null = null;
    inventory_full = null;
  }

  @Test
  public void testAdd() {

    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory2.add(item2);
    assertTrue(inventory1.get(0).equals(item1));
    assertTrue(inventory2.get(0).equals(item2));

  }

  @Test
  public void testContains() {
    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory2.add(item2);
    assertTrue(inventory1.contains(item1));
    assertTrue(inventory2.contains(item2));

    assertFalse(inventory1.contains(item2));
    assertFalse(inventory2.contains(item1));

  }

  @Test
  public void testGet() {

    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory1.add(item2);
    assertTrue(inventory1.get(0).equals(item1));
    assertTrue(inventory1.get(1).equals(item2));

    assertThrows(IndexOutOfBoundsException.class, () -> inventory1.get(5));

  }

  @Test
  public void testGetItems() {
    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory1.add(item2);

    assertTrue(inventory1.getItems()[0].equals(item1));
    assertTrue(inventory1.getItems()[1].equals(item2));


    try{
      assertFalse(inventory2.getItems()[0].equals(item1));
    } catch (Exception e) {
      assertFalse(false);
    }
    

    assertTrue(inventory1.getItems().length == 5);

    assertTrue(inventory1.getItems()[4] == null);
  }

  @Test
  public void testIsFull() {
    assertFalse(inventory1.isFull());
    assertFalse(inventory2.isFull());

    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");

    inventory1.add(item1);
    inventory1.add(item2);

    assertFalse(inventory1.isFull());
    assertFalse(inventory2.isFull());

    assertTrue(inventory_full.isFull());

    assertTrue(inventory_null.isFull());

  }

  @Test
  public void testRemove() {
    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory1.add(item2);
    inventory2.add(item1);

    inventory1.remove(item1);
    
    assertFalse(inventory1.contains(item1));
    assertTrue(inventory1.contains(item2));

    inventory2.remove(item1);
    assertFalse(inventory2.contains(item1));

    assertTrue(inventory_full.isFull());
    inventory_full.remove(item_a);

    assertFalse(inventory_full.isFull());

    inventory_full.add(item_a);
    assertTrue(inventory_full.isFull());

  }
}
