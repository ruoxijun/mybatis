package io.github.ruoxijun.data;

public class User {
//    字段
    private int id;
    private String name;
    private int age;

//    构造函数
    public User(){}
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

//    get 和 set 方法
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

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

//    toString 方法
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}