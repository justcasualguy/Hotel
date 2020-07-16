package models;

public class Room {
    private int number;
    private int pricePerDay;

    public Room(int number, int pricePerDay) {
        this.number = number;
        this.pricePerDay = pricePerDay;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
