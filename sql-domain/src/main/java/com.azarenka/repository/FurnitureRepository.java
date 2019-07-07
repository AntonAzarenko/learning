package com.azarenka.repository;

import com.azarenka.domain.Furniture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface FurnitureRepository {
    /**
     * @param name
     * @param cost
     * @return
     */
    List<Furniture> findFurniture(@Param("name") String name, @Param("cost") BigDecimal cost);
}
