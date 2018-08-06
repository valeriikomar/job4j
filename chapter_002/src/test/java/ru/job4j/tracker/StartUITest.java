package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    private final PrintStream stdout = System.out;
    private  final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        //System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        //System.out.println("execute after method");
    }
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
    public void whenOnlyShowMenu() {
        Input input = new StubInput(new String[] {"6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.").append(System.lineSeparator())
                                .append("0. Add new Item").append(System.lineSeparator())
                                .append("1. Show all items").append(System.lineSeparator())
                                .append("2. Edit item").append(System.lineSeparator())
                                .append("3. Delete item").append(System.lineSeparator())
                                .append("4. Find item by Id").append(System.lineSeparator())
                                .append("5. Find items by name").append(System.lineSeparator())
                                .append("6. Exit Program").append(System.lineSeparator())
                                .append("Select: ").append(System.lineSeparator())
                                .toString()
                )
        );
    }
    @Test
    public void whenShowMenuAndAddItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("One", "OneDesk");
        tracker.add(item);
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.").append(System.lineSeparator())
                                .append("0. Add new Item").append(System.lineSeparator())
                                .append("1. Show all items").append(System.lineSeparator())
                                .append("2. Edit item").append(System.lineSeparator())
                                .append("3. Delete item").append(System.lineSeparator())
                                .append("4. Find item by Id").append(System.lineSeparator())
                                .append("5. Find items by name").append(System.lineSeparator())
                                .append("6. Exit Program").append(System.lineSeparator())
                                .append("Select: ").append(System.lineSeparator())
                                .append("------------ Выввод всех заявок ------------").append(System.lineSeparator())
                                .append("ID: " + item.getId() + "; ")
                                .append("Name: " + item.getName() + "; ")
                                .append("Description: " + item.getDesc()).append(System.lineSeparator())
                                .append("Меню.").append(System.lineSeparator())
                                .append("0. Add new Item").append(System.lineSeparator())
                                .append("1. Show all items").append(System.lineSeparator())
                                .append("2. Edit item").append(System.lineSeparator())
                                .append("3. Delete item").append(System.lineSeparator())
                                .append("4. Find item by Id").append(System.lineSeparator())
                                .append("5. Find items by name").append(System.lineSeparator())
                                .append("6. Exit Program").append(System.lineSeparator())
                                .append("Select: ").append(System.lineSeparator())
                                .toString()
                )
        );
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
