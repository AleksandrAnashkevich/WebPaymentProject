package by.epam.webpayment.entity;

public class Payment {

    private int id;
    private double amount;
    private String number;
    private String name;

    public Payment(int id, double amount, String number, String name) {
        this.id = id;
        this.amount = amount;
        this.number = number;
        this.name = name;
    }

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        final Payment other = (Payment) obj;

        if (this.id != other.id) {
            return false;
        }

        if (this.amount != other.amount) {
            return false;
        }

        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }

        if ((this.number == null) ? (other.number != null) : !this.number.equals(other.number)) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return (int) (31 * id + amount + ((number == null) ? 0 : number.hashCode())
                + ((name == null) ? 0 : name.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@id:" + id + " amount:" + amount + " name:" + name + " number:" + number;
    }
}
