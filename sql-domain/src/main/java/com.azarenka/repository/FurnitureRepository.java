package com.azarenka.repository;

import com.azarenka.domain.Furniture;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface FurnitureRepository {

    /**
     * Returns list of furniture from manufacturers {@link com.azarenka.domain.Manufacturer} with title #name and where
     * price not more #cost
     *
     * @param name @{link Manufacturer}
     * @param cost price to furniture
     * @return list of furniture.
     */
    List<Furniture> findFurniture(@Param("name") String name, @Param("cost") BigDecimal cost);


    BigDecimal getFullPriceFromManufacturer(@Param("title") String title);
}
