package com.azarenka;

import java.util.concurrent.atomic.AtomicBoolean;

public interface Command {

    /**
     * Receives command, checks to has that command, handles and returns true if commands has been completed or
     * false if command has not found or not completed.
     *
     * @param command
     * @return
     */
    boolean handle(String command);
}
