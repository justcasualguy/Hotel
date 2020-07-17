package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {
    private String name;
    private String city;
    private String street;
    private String zipCode;
    List<Room> rooms;

    public Hotel(String name, String city, String street, String zipCode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.rooms = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) &&
                Objects.equals(city, hotel.city) &&
                Objects.equals(street, hotel.street) &&
                Objects.equals(zipCode, hotel.zipCode) &&
                Objects.equals(rooms.size(),hotel.rooms.size())
                ;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, street, zipCode);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
