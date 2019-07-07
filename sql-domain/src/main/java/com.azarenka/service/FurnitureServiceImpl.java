package com.azarenka.service;

import com.azarenka.domain.Furniture;
import com.azarenka.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    @Autowired
    private FurnitureRepository repository;

    @Override
    public List<Furniture> findFurniture(String name, BigDecimal cost) {
        return repository.findFurniture(name, cost);
    }
}
