package business;

public class User {
    public String name;
    public int age;
    public UserStatusEnum status;

    public User() {}

    public User(String name, int age, UserStatusEnum status) {
        this.name = name;
        this.age = age;
        this.status = status;
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

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", age=" + age + ", status=" + status + '}';
    }
    
    
}
