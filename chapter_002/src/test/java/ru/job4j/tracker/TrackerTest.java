package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenFindByIdThenTrackerFindSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "onebyone", 12L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
    @Test
    public void whenFindByNameThenTrackerFindSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "IwannaFind", 122L);
        tracker.add(item);
        assertThat(tracker.findByName("name")[0], is(item.getName()));
    }
    @Test
    public void whenDeleteThenTrackerHasOneLess() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "onedesc", 12L);
        tracker.add(item);
        Item item1 = new Item("two", "twodesc", 13L);
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findAll()[0], is(item1));
    }


}
