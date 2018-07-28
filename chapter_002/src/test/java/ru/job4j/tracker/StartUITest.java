package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    @Test
    public void whenAddOneNewItemThenFindThisItem() {
        Input input = new StubInput(new String[] {"0", "one", "oneDesc", "1", "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("one")[0], is(tracker.findAll()[0]));
    }
    @Test
    public void whenAddTwoNewItemThenFindThem() {
        Input input = new StubInput(new String[] {"0", "one", "oneDesc", "0", "one", "twoDesc", "1", "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("one"), is(tracker.findAll()));
    }
    @Test
    public void whenShowAllItemsThenShow() {
        Input input = new StubInput(new String[] {"0", "one", "oneDesc", "0", "two", "twoDesc", "1", "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        Item[] items = new Item[2];
        items[0] = tracker.findByName("one")[0];
        items[1] = tracker.findByName("two")[0];
        assertThat(tracker.findAll(), is(items));
    }
    @Test
    public void whenEditItemThenShowEditedItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "oneDesc");
        tracker.add(item);
        Input input = new StubInput(new String[] {"0", "two", "oneDesc", "0", "three", "twoDesc", "2", item.getId(), "four", "fourDesc", "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("four"));
    }
    @Test
    public void whenDeleteItemThenItemsLessOne() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "oneDesc");
        tracker.add(item);
        Input input = new StubInput(new String[] {"0", "two", "oneDesc", "0", "three", "twoDesc", "3", item.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("two"));
    }
    @Test
    public void whenFindByIdThenShowIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "oneDesc");
        tracker.add(item);
        Input input = new StubInput(new String[] {"0", "two", "oneDesc", "0", "three", "twoDesc", "4", item.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("one"));
    }
    @Test
    public void whenFindByNameThenShowIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "oneDesc");
        tracker.add(item);
        Input input = new StubInput(new String[] {"0", "two", "oneDesc", "0", "three", "twoDesc", "5", "one", "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("one")[0], is(item));
    }

    /*  public static void main(String[] args) {
        Input input = new StubInput(new String[] {"Someone"});
        new StartUI(input, new Tracker()).init();
    }*/

}
