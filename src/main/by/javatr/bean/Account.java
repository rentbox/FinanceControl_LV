package main.by.javatr.bean;

import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = 1723763139833699804L;

    private String login;
    private String password;
    private double balance;
    private double expenses;
    private double food;
    private double transport;
    private double entertainment;
    private double other;
    private boolean admin;
    private boolean ban;
    private char currentCur = '$';


    public Account(){

        login = null;
        password = null;
        balance = 0;
        expenses = 0;
        food = 0;
        transport = 0;
        entertainment = 0;
        other = 0;
        admin = false;

    }

    @Override
    public String toString() {
        return getClass().getName() +"@"+
                "{ login=" + login +
                ", password=" + password +
                ", balance=" + balance +
                ", expenses=" + expenses +
                ", food=" + food +
                ", transport=" + transport +
                ", entertainment=" + entertainment +
                ", other=" + other;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getTransport() {
        return transport;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    public double getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(double entertainment) {
        this.entertainment = entertainment;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public char getCurrentCur() {
        return currentCur;
    }

    public void setCurrentCur(char currentCur) {
        this.currentCur = currentCur;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (admin ? 1231 : 1237);
        long temp;
        temp = Double.doubleToLongBits(balance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (ban ? 1231 : 1237);
        result = prime * result + currentCur;
        temp = Double.doubleToLongBits(entertainment);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(expenses);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(food);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        temp = Double.doubleToLongBits(other);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        temp = Double.doubleToLongBits(transport);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        if (admin != other.admin) {
            return false;
        }
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (ban != other.ban) {
            return false;
        }
        if (currentCur != other.currentCur) {
            return false;
        }
        if (Double.doubleToLongBits(entertainment) != Double.doubleToLongBits(other.entertainment)) {
            return false;
        }
        if (Double.doubleToLongBits(expenses) != Double.doubleToLongBits(other.expenses)) {
            return false;
        }
        if (Double.doubleToLongBits(food) != Double.doubleToLongBits(other.food)) {
            return false;
        }
        if (login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!login.equals(other.login)) {
            return false;
        }
        if (Double.doubleToLongBits(this.other) != Double.doubleToLongBits(other.other)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (Double.doubleToLongBits(transport) != Double.doubleToLongBits(other.transport)) {
            return false;
        }
        return true;
    }



}
