package com.rentcar.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

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
    private Date startDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    @OneToOne
    @JoinColumn(name="CAR_TYPE_ID")
    private CarType carType;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return getRegNo();
    }
}
