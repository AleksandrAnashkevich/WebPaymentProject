package by.epam.webpayment.entity;

public class Operation {
    private int id;
    private int paymentId;
    private int accountId;
    private int operationTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(int operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Operation other = (Operation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.accountId != other.accountId) {
            return false;
        }

        if (this.operationTypeId != other.operationTypeId) {
            return false;
        }

        if (this.paymentId != other.paymentId) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return (int) (31 * id + accountId + operationTypeId +paymentId);
    }

    @Override
    public String toString() {
        return getClass().getName() + "@id:" + id;
    }
}
