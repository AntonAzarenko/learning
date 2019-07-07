package com.azarenka.service;

import com.azarenka.domain.Furniture;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface FurnitureService {

    List<Furniture>  findFurniture(String name, BigDecimal cost);
}
