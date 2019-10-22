package by.epam.webpayment.entity;
public class User {

    private int id;
    private String firstName;
    private String secondName;
    private String login;
    private String password;
    private String email;
    private int roleId;

    public User(int id, String firstName, String secondName, String login, String password, String email, int role) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roleId = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int role) {
        this.roleId = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }

        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.secondName == null) ? (other.secondName != null) : !this.secondName.equals(other.secondName)) {
            return false;
        }
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * id + roleId + ((firstName == null) ? 0 : firstName.hashCode())
                + ((secondName == null) ? 0 : secondName.hashCode())
                + ((login == null) ? 0 : login.hashCode())
                + ((password == null) ? 0 : password.hashCode())
                + ((email == null) ? 0 : email.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@id:" + id + " firstName:" + firstName + " secondName:" + secondName
                + " login:" + login + " password:" + password + " email:" + email;
    }
}
