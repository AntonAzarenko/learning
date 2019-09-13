package com.azarenka.ships;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Angar extends Thread {

    AtomicBoolean  isEmpty = new AtomicBoolean(true) ;
    ConcurrentHashMap<Ship, Integer> map = new ConcurrentHashMap<>();
    private int angarNumber;

    public synchronized void upload(Ship ship) {
        System.out.println("Стыковка..." + ship.getTitle());
        System.out.println("Разгрузка началась " + ship.getTitle());
            int fully = ship.getCargo();
            if (Objects.nonNull(ship)) {
                map.merge(ship, fully, Integer::sum);
                while (ship.isEmpty()) {
                    fully--;
                    //System.out.println(currentThread().getState());
                    try {
                        Thread.sleep(300);

                    } catch (Throwable e) {
                        System.out.println("ПОГИБ");
                    }
                    if (fully == 0) {
                        ship.setEmpty(false);
                    }
                }
                ship.setCargo(0);
                System.out.println("Разгрузка закончилась " + ship.getTitle());
            }


    }

    public int getAngarNumber() {
        return angarNumber;
    }

    public void setAngarNumber(int angarNumber) {
        this.angarNumber = angarNumber;
    }

    public ConcurrentHashMap<Ship, Integer> getMap() {
        return map;
    }

    public void setMap(ConcurrentHashMap<Ship, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        while (true){
            if(getIsEmpty().equals(false)){
                System.out.println("я занят");
            }
        }
    }

    public AtomicBoolean getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(AtomicBoolean isEmpty) {
        this.isEmpty = isEmpty;
    }
}
