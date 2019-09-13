package com.azarenka.ships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Space extends Thread {

    public static void main(String[] args) {
        try {
            new Space().startToMine();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void startToMine() throws InterruptedException {
        List<Angar> angars = new ArrayList<>();
        for (int i = 0; i < 2 ; i++) {
            Angar angar = new Angar();
            angar.setAngarNumber(i);
            angars.add(angar);
        }
        List<Ship> ships = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Ship ship = new Ship();
            ship.setTitle("ship " + i);
            ship.setAngar(angars);
            ships.add(ship);
        }
        for (Ship c : ships) {
            c.start();
            Thread.sleep(500);
        }
        while (true) {
            Map<Ship, Integer> map1 = angars.get(0).getMap();
            Map<Ship, Integer> map2 = angars.get(1).getMap();
            Map<Ship, Integer> map = new HashMap<>(map1);
            map2.forEach((k, v) -> map.merge(k, v, (a, b) -> a + b));
            Thread.sleep(60000);
            System.out.println("Проверка руды...");
            if (!map.isEmpty()) {
                System.out.println("добыто:");
                map.forEach((k, v) -> System.out.println(k.getTitle() + " " + v.toString()));
            }
            System.out.println("Проверка Кораблей...");
            for (Ship c : ships) {
                if (c.isAlive()) {
                    System.out.println(c.getTitle() + " жив");
                } else {
                    System.out.println(c.getTitle() + " погиб");
                }
            }
        }
    }
}
