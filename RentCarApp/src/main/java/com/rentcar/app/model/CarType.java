package com.rentcar.app.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "CAR_TYPE")
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_TYPE_ID", unique = true, nullable = false)
    private int id;

    @NotEmpty
    @Column(name = "MARK", nullable = false)
    private String mark;

    @NotEmpty
    @Column(name = "MODEL", nullable = false)
    private String model;

    @Override
    public String toString() {
        return id + " - " + mark + " " + model;
    }
}
