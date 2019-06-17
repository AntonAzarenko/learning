package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Dimensions extends BaseEntity {

    private Long height;
    private Long width;
    private Long thickness;

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getThickness() {
        return thickness;
    }

    public void setThickness(Long thickness) {
        this.thickness = thickness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Dimensions that = (Dimensions) o;

        return new EqualsBuilder()
            .appendSuper(super.equals(o))
            .append(height, that.height)
            .append(width, that.width)
            .append(thickness, that.thickness)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .appendSuper(super.hashCode())
            .append(height)
            .append(width)
            .append(thickness)
            .toHashCode();
    }
}
