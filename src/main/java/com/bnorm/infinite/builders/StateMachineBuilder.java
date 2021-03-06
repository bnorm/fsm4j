package com.bnorm.infinite.builders;

import com.bnorm.infinite.StateMachine;

/**
 * State machine builder interface.  A state machine builder provides access to configuring each state and also for
 * creating the final state machine.  Since the builder and the state machine share the same backend it is possible to
 * build the state machine before configuring any states.  This allows the state machine itself to be reference from any
 * entrance or exit actions.  This however, is not fully supported at this time.
 *
 * @param <S> the class type of the states.
 * @param <E> the class type of the events.
 * @param <C> the class type of the context.
 * @author Brian Norman
 * @since 1.0.0
 */
public interface StateMachineBuilder<S, E, C> {

    /**
     * Returns a state builder that can be used to configure the specified state.
     *
     * @param state the state to configure.
     * @return the state builder for the state.
     */
    StateBuilder<S, E, C> configure(S state);

    /**
     * Builds and returns the state machine the state machine builder is constructing.
     *
     * @param starting the starting state of the state machine.
     * @param context the state machine context.
     * @return the state machine.
     */
    StateMachine<S, E, C> build(S starting, C context);
}
