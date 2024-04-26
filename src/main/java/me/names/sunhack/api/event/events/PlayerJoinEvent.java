package me.names.sunhack.api.event.events;

import me.names.sunhack.api.event.SunHackEvent;

public class PlayerJoinEvent extends SunHackEvent {

    private final String name;

    public PlayerJoinEvent(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}