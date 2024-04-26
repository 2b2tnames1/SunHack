package me.names.sunhack.api.event.events;

import me.names.sunhack.api.event.SunHackEvent;

public class ReachDistanceEvent extends SunHackEvent {

    private float distance;

    public ReachDistanceEvent(float distance) {
        this.distance = distance;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}