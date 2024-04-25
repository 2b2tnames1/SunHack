package me.names.sunhack.api.event;


public interface MultiPhase<T extends GameSenseEvent> {

    Phase getPhase();

    T nextPhase();
}
