package by.epam.webpayment.entity;


public abstract class User {
    //http://127.0.0.1:50808/?key=da115478-4264-4853-b0e7-301b93d56f6d
    int id;
    String firstName;
    String secondName;
    String login;
    String password;
    String email;

    public User(int id, String firstName, String secondName, String login, String password, String email){
        this.id=id;
        this.firstName=firstName;
        this.secondName=secondName;
        this.login=login;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        if (id != user.id) {
            return false;
        }
        if (firstName == null) {
            return firstName == user.firstName;
        } else if (!firstName.equals(user.firstName)) {
            return false;
        }

        if (secondName == null) {
            return secondName == user.secondName;
        } else if (!secondName.equals(user.secondName)) {
            return false;
        }

        if (login == null) {
            return login == user.login;
        } else if (!login.equals(user.login)) {
            return false;
        }

        if (password == null) {
            return password == user.password;
        } else if (!password.equals(user.password)) {
            return false;
        }

        if (email == null) {
            return email == user.email;
        } else if (!email.equals(user.email)) {
            return false;
        }

        return true;
    }
}
