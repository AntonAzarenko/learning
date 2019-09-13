package com.azarenka.ships;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Ship extends Thread {
    private List<Angar> angar;
    private String title;
    private LocalDateTime flyTime;
    private boolean empty = false;
    private int cargo;

    @Override
    public void run() {
        startToMine();
    }

    private void startToMine() {
        if (!isEmpty()) {
            goToAsteroid();
            startToLoad();
            goToAngar();
            uploadingCargo();
            startToMine();
        } else {
            goToAngar();
        }

    }

    private synchronized void uploadingCargo() {
        AtomicBoolean ang1 = new AtomicBoolean(true);
        Angar angars = null;
        System.out.println("Проверяю свободные ангары");
        while (ang1.get()) {
            for (Angar angar : angar) {
                if (angar.getIsEmpty().get() ) {
                    System.out.println("Ангар - " + angar.getAngarNumber() + " свободен");
                    angar.setIsEmpty(new AtomicBoolean(false));
                    angar.upload(this);
                    System.out.println("Расстыковка..." + this.getTitle());
                    angar.setIsEmpty(new AtomicBoolean(true));
                    ang1 = new AtomicBoolean(false);
                    break;
                } else {
                    System.out.println("...");
                      continue;
                }
            }
        }
    }

    private void startToLoad() {
        showStatus(this, "Загрузка..." + this.getTitle());
        double count = Math.random();
        double c = count * 100;
        c = Math.round(c);
        double f = c / 100 * 1;
        while (!empty) {
            cargo++;
            try {
                Thread.sleep(500);
            } catch (Throwable e) {
                System.out.println(this.getTitle() + " Погиб при загрузке");
            }
            double percent = cargo / f;
            if (percent % 2 == 0) {
                showStatus(this, "- загрузка " + percent + "%");
            }
            if (cargo == c) {
                empty = true;
                showStatus(this, "loading has been complete..." + this.getTitle());
            }
        }
    }

    private void goToAngar() {
        int time = 0;
        if (!this.isEmpty()) {
            time = 2000;
        } else {
            time = 2000 + (this.cargo * 100);
        }
        showStatus(this, "flying to Angar...! Время в пути - " + time / 1000 + " секунды");
        try {
            Thread.sleep(time);
        } catch (Throwable e) {
            System.out.println(this.getTitle() + " Погиб");
        }
    }

    private void goToAsteroid() {
        showStatus(this, "flying to asteroid...");
        try {
            Thread.sleep(2000);
        } catch (Throwable e) {
            System.out.println(this.getTitle() + " Погиб при полете на астероид");
        }
    }

    public List<Angar> getAngar() {
        return angar;
    }

    public void setAngar(List<Angar> angar) {
        this.angar = angar;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public LocalDateTime getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(LocalDateTime flyTime) {
        this.flyTime = flyTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void showStatus(Ship ship, String message) {
        System.out.println(ship.getTitle() + " " + message);
    }

    public void showStatus(Angar angar, String message, Ship ship) {
        System.out.println(angar.getAngarNumber() + " " + message + " " + ship.getTitle());

    }
}
