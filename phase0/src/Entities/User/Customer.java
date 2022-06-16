package Entities.User;

public class Customer extends User{

    public Customer(String username, String password, int birthYear, int birthMonth, int birthDay, String email, boolean isMember) {
        super(username, password, birthYear, birthMonth, birthDay, email, isMember);
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    public String toString(){return super.getUsername() + "," + super.getPassword() + "," + super.getBirthDay() + "," +
            super.getEmail() + "," + super.getMemberStatus() + "," + super.getAddress() + "," + super.getLastLoginTime()
            + "," + false;}
}
