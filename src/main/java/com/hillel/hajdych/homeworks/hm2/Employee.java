package com.hillel.hajdych.homeworks.hm2;

public class Employee {

    private String nameSurname;
    private String position;
    private String email;
    private String phone;
    private int yearOld;

    public Employee(String nameSurname, String position, String email, String phone, int yearOld) {
        this.nameSurname = nameSurname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.yearOld = yearOld;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "ПІБ = '" + nameSurname + '\'' +
                ", посада = '" + position + '\'' +
                ", email = '" + email + '\'' +
                ", телефон = '" + phone + '\'' +
                ", вік = " + yearOld +
                '}';
    }
}
