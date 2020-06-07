public class User {
    String username;

    public User(String name, int age) {
        this.username = name + age;
    }

    public String getUsername() {
        return username;
    }
}
