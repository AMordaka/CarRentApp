package com.rentcar.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="CAR")
public class Car implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CAR_ID", unique=true, nullable=false)
    private long id;

    @NotEmpty
    @Column(name = "REG_NO", nullable=false)
    private String regNo;

    @NotEmpty
    @Column(name = "YEAR", nullable=false, length = 4)
    private String year;

    @Column(name = "AVAILABLE", nullable=false)
    private boolean available = true;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "RETURN_DATE")
    private String returnDate;

    @OneToOne
    @JoinColumn(name="CAR_TYPE_ID")
    private CarType carType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "OWNED_CAR",
            joinColumns = { @JoinColumn(name = "CAR_ID")},
            inverseJoinColumns = { @JoinColumn(name = "USER_ID")})
    private Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RESERVATION",
            joinColumns = { @JoinColumn(name = "CAR_ID")},
            inverseJoinColumns = { @JoinColumn(name = "USER_ID")})
    private List<User> rentUsers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<User> getRentUsers() {
        return rentUsers;
    }

    public void setRentUsers(List<User> rentUsers) {
        this.rentUsers = rentUsers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (regNo != null ? !regNo.equals(car.regNo) : car.regNo != null) return false;
        if (year != null ? !year.equals(car.year) : car.year != null) return false;
        return (carType != null ? !carType.equals(car.carType) : car.carType != null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (regNo != null ? regNo.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getRegNo();
    }
}
