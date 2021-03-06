package com.bnorm.infinite.builders;

import java.util.function.Supplier;

import com.bnorm.infinite.Action;
import com.bnorm.infinite.Transition;
import com.bnorm.infinite.TransitionGuard;

/**
 * Represents a builder of a specific state.  The interface provides methods that add behavior to the state machine.
 *
 * @param <S> the class type of the states.
 * @param <E> the class type of the events.
 * @param <C> the class type of the context.
 * @author Brian Norman
 * @since 1.0.0
 */
public interface StateBuilder<S, E, C> {

    /**
     * Sets the the parent of the internal state to be the specified state.  The parent state must already be partially
     * built by another state builder before it can be set as the parent of another state.
     *
     * @param state the parent state.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> childOf(S state);

    /**
     * Adds the specified action as an entry action to the internal state.
     *
     * @param action the new entry action.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> onEntry(Action<? super S, ? super E, ? super C> action);

    /**
     * Adds the specified action as an exit action to the internal state.
     *
     * @param action the new exit action.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> onExit(Action<? super S, ? super E, ? super C> action);

    /**
     * Adds the specified transition as a possible transition given the specified event.
     *
     * @param event the event that will cause the transition.
     * @param transition the transition that will result because of the event.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, Transition<S, E, C> transition);

    /**
     * Adds a reentrant transition as a possible transition given the specified event.
     *
     * @param event the event that will cause the reentrant transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event and destination.
     *
     * @param event the event that will cause the transition.
     * @param destination the destination of the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, S destination);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event and destination
     * supplier.
     *
     * @param event the event that will cause the transition.
     * @param destination the destination supplier of the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, Supplier<S> destination);

    /**
     * Adds a reentrant transition as a possible transition given the specified event and transition guard.
     *
     * @param event the event that will cause the reentrant transition.
     * @param guard the guard for the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, TransitionGuard<C> guard);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event and transition
     * action.
     *
     * @param event the event that will cause the transition.
     * @param action the action to perform during the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, Action<? super S, ? super E, ? super C> action);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event, destination, and the
     * transition guard.
     *
     * @param event the event that will cause the transition.
     * @param destination the destination of the transition.
     * @param guard the guard for the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, S destination, TransitionGuard<C> guard);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event, destination
     * supplier, and transition guard.
     *
     * @param event the event that will cause the transition.
     * @param destination the destination supplier of the transition.
     * @param guard the guard for the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, Supplier<S> destination, TransitionGuard<C> guard);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event, destination, and
     * transition action.
     *
     * @param event the event that will cause the transition.
     * @param destination the destination of the transition.
     * @param action the action to perform during the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, S destination, Action<? super S, ? super E, ? super C> action);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event, destination
     * supplier, and transition action.
     *
     * @param event the event that will cause the transition.
     * @param destination the destination supplier of the transition.
     * @param action the action to perform during the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, Supplier<S> destination, Action<? super S, ? super E, ? super C> action);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event, destination,
     * transition guard, and transition action.
     *
     * @param event the event that will cause the transition.
     * @param destination the destination of the transition.
     * @param guard the guard for the transition.
     * @param action the action to perform during the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, S destination, TransitionGuard<C> guard,
                                 Action<? super S, ? super E, ? super C> action);

    /**
     * Adds a transition to the specified state as a possible transition given the specified event, destination
     * supplier, transition guard, and transition action.
     *
     * @param event the event that will cause the transition.
     * @param destination the destination supplier of the transition.
     * @param guard the guard for the transition.
     * @param action the action to perform during the transition.
     * @return the current state builder for chaining.
     */
    StateBuilder<S, E, C> handle(E event, Supplier<S> destination, TransitionGuard<C> guard,
                                 Action<? super S, ? super E, ? super C> action);
}
