package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Contact extends BaseEntity {

    private String phone;
    private String city;
    private String street;
    private String country;
    private String email;

    public Contact() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(phone, contact.phone)
                .append(city, contact.city)
                .append(country, contact.country)
                .append(email, contact.email)
                .append(street, contact.street)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(phone)
                .append(city)
                .append(street)
                .append(country)
                .append(email)
                .toHashCode();
    }
}
