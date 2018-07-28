package ru.job4j.tracker;

import javax.sound.midi.Track;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
/*    private enum Menu {
        ADD(0), SHOW(1), EDIT(2), DELETE(3), FINDBYID(4), FINDBYNAME(5), EXIT(6);
        private int number;
        Menu(int number) {
            this.number = number;
        }
        int getNumber() {
            return this.number;
        }
      }
*/

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showItems();
                    break;
                case EDIT:
                    this.replaceItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FINDBYID:
                    this.findById();
                    break;
                case FINDBYNAME:
                    this.findByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод выводит все заявки
     */
    public void showItems() {
        System.out.println("------------ Выввод всех заявок ------------");
        for (Item it: this.tracker.findAll()) {
            System.out.print("ID: " + it.getId() + "; ");
            System.out.print("Name: " + it.getName() + "; ");
            System.out.println("Description: " + it.getDesc());
        }
    }

    /**
     * Метод редактирования элемента
      */
    public void replaceItem() {
        System.out.println("------------ Редактирование заявки ------------");
        String id = this.input.ask("Введите Id заявки : ");
        Item it = this.tracker.findById(id);
        if (it != null) {
            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            it.setName(name);
            it.setDesc(desc);
        } else {
            System.out.println("Заявка по id " + id + " не найдена");
        }
    }
    /**
     * Метод удаления заявки по Id
      */
    public void deleteItem() {
        System.out.println("------------ Удаление элемента по ID ------------");
        String id = this.input.ask("Введите Id заявки : ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка по id: " + id + " не найдена");
        }
    }

    /**
     * Метод поиска по Id
     */
    public void findById() {
        System.out.println("------------ Найти заявку по Id ------------");
        String id = this.input.ask("Введите Id заявки : ");
        Item it = this.tracker.findById(id);
        if (it != null) {
            System.out.print("ID: " + it.getId() + "; ");
            System.out.print("Name: " + it.getName() + "; ");
            System.out.println("Description: " + it.getDesc());
        } else {
            System.out.println("Заявка по id: " + id + " не найдена");
        }
    }
    public void findByName() {
        System.out.println("------------ Найти заявку по имени ------------");
        String name = this.input.ask("Введите имя заявки : ");
        Item[] items = this.tracker.findByName(name);
        if (items[0] != null) {
            for (Item it: items) {
                System.out.print("ID: " + it.getId() + "; ");
                System.out.print("Name: " + it.getName() + "; ");
                System.out.println("Description: " + it.getDesc());
            }
        } else {
            System.out.println("Заявка по имени: " + name + " не найдена");
        }
    }
    /**
     * Метод вывода меню на экран
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");
    }

    /**
     * Запускт программы
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

}
