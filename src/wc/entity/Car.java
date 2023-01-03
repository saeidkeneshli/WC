package wc.entity;

import java.io.Serializable;

public class Car implements Serializable {
    private String name, company;

    public Car() {
    }

    public Car(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Car setCompany(String company) {
        this.company = company;
        return this;
    }
}
