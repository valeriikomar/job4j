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
        Item[] result = null;
        int max = 0, pos = 0;
        for (int i = 0; i < position; i++) {
            if ((this.items[i] != null) && (this.items[i].getName().equals(key))) {
                max++;
            }
        }
        if (max != 0) {
             result = new Item[max];
            for (int i = 0; i < position; i++) {
                if (items[i].getName().equals(key)) {
                    result[pos] = items[i];
                    pos++;
                }
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
    public boolean replace(String id, Item item) {
        boolean found = false;
        for (int i = 0; i < position; i++) {
            if ((this.items[i] != null) && (this.items[i].getId().equals(id))) {
                item.setId(id);
                this.items[i] = item;
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Метод удаления заявок
     * @param id
     */
    public boolean delete(String id) {
        boolean found = false;
        for (int i = 0; i < position; i++) {
            if ((this.items[i] != null) && (this.items[i].getId().equals(id))) {
                System.arraycopy(items, i, items, i - 1, position - i);
                found = true;
                break;
            }
        }
        return found;
    }
}
