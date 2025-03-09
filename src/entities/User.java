package entities;

public abstract class User {
    protected int userId;
    protected String username;
    protected String email;

    public User(int userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public abstract void displayInfo();
}
