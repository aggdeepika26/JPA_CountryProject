package be.intecbrussel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class President {
@Id
    private String name;
    private int age;

    public President(String name,int Age)
    {
        this.name = name;
        this.age = age;

    }
    protected President()
    {}

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
}
