package com.bnorm.fsm4j;

/**
 * A functional interface that is used to represent a listener for state transition events.
 *
 * @author Brian Norman
 * @version 1.0
 * @since 1.0
 */
@FunctionalInterface
public interface TransitionListener<S extends State, E extends Event> {

    /**
     * When the listener is added to a state machine, this method is called whenever there is a state transition.
     *
     * @param event the event that caused the transition.
     * @param transition the state transition that took place.
     */
    void stateTransition(E event, Transition<S> transition);
}