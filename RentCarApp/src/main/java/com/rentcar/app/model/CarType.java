package com.rentcar.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "CAR_TYPE")
public class CarType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CAR_TYPE_ID", unique=true, nullable=false)
    private int id;

    @NotEmpty
    @Column(name = "MARK", nullable=false)
    private String mark;

    @NotEmpty
    @Column(name = "MODEL", nullable=false)
    private String model;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    @Override
    public String toString() {
        return id + " - " + mark + " " + model;
    }
}
