package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

public class Furniture extends BaseEntity {

    private String title;
    private int width;
    private int m_long;
    private int height;
    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getM_long() {
        return m_long;
    }

    public void setM_long(int m_long) {
        this.m_long = m_long;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Furniture furniture = (Furniture) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(width, furniture.width)
                .append(m_long, furniture.m_long)
                .append(height, furniture.height)
                .append(title, furniture.title)
                .append(price, furniture.price)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(title)
                .append(width)
                .append(m_long)
                .append(height)
                .append(price)
                .toHashCode();
    }
}
