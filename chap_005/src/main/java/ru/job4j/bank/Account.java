package ru.job4j.bank;

/**
 * @author Aleksandr Smirnov.
 */
public class Account extends Accounts {
    /**
     * Кол-во средств на счете.
     */
    private double values;
    /**
     * Номер счета.
     */
    private int requisites;
    /**
     * Конструктор по умолчанию.
     * @param values - средства.
     * @param requisites - номер счета.
     */
    public Account(double values, int requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public int getRequisites() {
        return requisites;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    @Override
    public String toString() {
        return "Account{" +
                "values=" + values +
                ", requisites=" + requisites +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (Double.compare(account.values, values) != 0) return false;
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(values);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + requisites;
        return result;
    }
}
