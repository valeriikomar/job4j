package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long create;
    private String[] comments;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.desc = description;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.desc = description;
        this.create = create;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreate() {
        return create;
    }


    public void setCreate(long create) {
        this.create = create;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
