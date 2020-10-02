package io.github.ruoxijun.pojo;

public class UserPojo {
    private int id;
    private String name;
    private int a;

    public UserPojo(){}
    public UserPojo(int id, String name, int a) {
        this.id = id;
        this.name = name;
        this.a = a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", a=" + a +
                '}';
    }
}
