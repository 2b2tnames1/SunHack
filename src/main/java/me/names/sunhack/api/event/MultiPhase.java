package me.names.sunhack.api.event;


public interface MultiPhase<T extends SunHackEvent> {

    Phase getPhase();

    T nextPhase();
}
