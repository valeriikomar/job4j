package ru.job4j.tracker;
import java.util.*;
/**
 * @author Valerii Komar (mailto: val1988x@gmail.com)
 * @version 18.07.18
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Для генерации случайных чисел
     */
    private static final Random RN = new Random();
    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     * @return заявка по Id
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод поиска по ID
     * @param id уникальный идентификатор
     * @return искоимый элемент
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item: items) {
            if ((item != null) && (item.getId().equals(id))) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Метод поиска по имени
     * @param key имя
     * @return массив совпадений
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int posresult = 0;
        for (Item item: this.items) {
            if (item.getName().equals(key)) {
                result[posresult] = item;
                posresult++;
            }
        }
        return result;
    }
    /**
     * Метод вывода всех элементов
     * @return массив элементов
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод редактирования заявок
     * @param id ключ
     * @param item элемент для редактирования
     */
    public void replace(String id, Item item) {
        Item it = this.findById(id);
        it = item;
        /*
        it.setName(item.getName());
        it.setDesc(item.getDesc());
        it.setComments(item.getComments());
        it.setCreate(item.getCreate());
        */
    }

    /**
     * Метод удаления заявок
     * @param id
     */
    public void delete(String id) {
        Item it = this.findById(id);
        Item[]  items = new Item[this.position - 1];
        int pos = 0;
        while (this.items[pos] != it) {
            pos++;
        }
        System.arraycopy(items, 0, this.items, 0, pos - 1);
        System.arraycopy(items, pos, this.items, pos + 1, position);
    }
}
