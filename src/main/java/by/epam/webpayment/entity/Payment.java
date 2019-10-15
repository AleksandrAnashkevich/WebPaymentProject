package by.epam.webpayment.entity;

public class Payment {

    private int id;
    private double amount;
    private String number;
    private String name;

    public Payment(int id, double amount, String number, String name){
        this.id=id;
        this.amount=amount;
        this.number=number;
        this.name=name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment payment = (Payment) obj;
        if (id != payment.id) {
            return false;
        }

        if (amount != payment.amount) {
            return false;
        }

        if (name == null) {
            return name == payment.name;
        } else if (!name.equals(payment.name)) {
            return false;
        }

        if (number == null) {
            return number == payment.number;
        } else if (!number.equals(payment.number)) {
            return false;
        }

        return true;

    }
}
