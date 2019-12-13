package by.epam.webpayment.entity;

public class Account {
    private int id;
    private int userId;
    private boolean locked;

    public Account(int id, int userId, boolean locked) {
        this.id = id;
        this.userId = userId;
        this.locked = locked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Account other = (Account) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }

        if (this.locked != other.locked) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return (int) (31 * id + userId + (new Boolean(locked).hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@id:" + id + " locked:" + locked;
    }
}
