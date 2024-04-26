package me.names.sunhack.api.event.events;

import me.names.sunhack.api.event.SunHackEvent;

public class RenderEvent extends SunHackEvent {

    private final float partialTicks;

    public RenderEvent(float partialTicks) {
        super();
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return this.partialTicks;
    }
}