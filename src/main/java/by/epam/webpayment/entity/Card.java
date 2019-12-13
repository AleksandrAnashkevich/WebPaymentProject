package by.epam.webpayment.entity;

public class Card {
    private int id;
    private int arrayId;
    private double deposit;
    private String number;
    private String cvv;

    public Card(int id, double deposit, String number, String cvv, int arrayId) {
        this.id = id;
        this.deposit = deposit;
        this.number = number;
        this.cvv = cvv;
        this.arrayId = arrayId;
    }

    public Card(double deposit, String number, String cvv, int arrayId) {
        this.deposit = deposit;
        this.number = number;
        this.cvv = cvv;
        this.arrayId = arrayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getArrayId() {
        return arrayId;
    }

    public void setArrayId(int arrayId) {
        this.arrayId = arrayId;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Card other = (Card) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.deposit != other.deposit) {
            return false;
        }

        if (this.arrayId != other.arrayId) {
            return false;
        }

        if ((this.number == null) ? (other.number != null) : !this.number.equals(other.number)) {
            return false;
        }

        if ((this.cvv == null) ? (other.cvv != null) : !this.cvv.equals(other.cvv)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * id + arrayId + deposit +
                + ((number == null) ? 0 : number.hashCode())
                + ((cvv == null) ? 0 : cvv.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@id:" + id + " number:" + number + " cvv:" + cvv
                 + " deposit:" + deposit + " arrayId:" + arrayId;
    }
}
