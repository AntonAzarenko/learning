package com.azarenka.controller;

import com.azarenka.domain.Furniture;
import com.azarenka.service.FurnitureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ControllerAPI {
    private final static Logger log = LoggerFactory.getLogger(ControllerAPI.class);

    @Autowired
    private FurnitureService service;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Furniture> getFurniture(@RequestParam(required = true) @PathVariable("name") String name,
                                        @RequestParam(required = false) @PathVariable("cost")
                                       BigDecimal cost) {
        log.info("Connecting..{} {}", name, cost);
        return service.findFurniture(name, cost);
    }
}

