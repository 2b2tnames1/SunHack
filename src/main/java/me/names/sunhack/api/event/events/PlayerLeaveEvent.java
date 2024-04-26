package me.names.sunhack.api.event.events;

import me.names.sunhack.api.event.SunHackEvent;

public class PlayerLeaveEvent extends SunHackEvent {

    private final String name;

    public PlayerLeaveEvent(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}