package Entities.User;

public class Admin extends User{

    public Admin(String username, String password, int birthYear, int birthMonth, int birthDay, String email,
                 boolean isMember) {
        super(username, password, birthYear, birthMonth, birthDay, email, isMember);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
