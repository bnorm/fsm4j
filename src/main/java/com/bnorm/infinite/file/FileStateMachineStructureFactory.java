package com.bnorm.infinite.file;

import java.io.IOException;
import java.nio.file.Path;

import com.bnorm.infinite.InternalStateFactory;
import com.bnorm.infinite.StateMachineException;
import com.bnorm.infinite.StateMachineStructure;
import com.bnorm.infinite.StateMachineStructureFactory;
import com.bnorm.infinite.StateMachineStructureFactoryBase;
import com.bnorm.infinite.TransitionFactory;

/**
 * A factory for creating state machine structures for a file.
 *
 * @param <S> the class type of the states.
 * @param <E> the class type of the events.
 * @param <C> the class type of the context.
 * @author Brian Norman
 * @since 1.2.0
 */
public class FileStateMachineStructureFactory<S, E, C> extends StateMachineStructureFactoryBase<S, E, C>
        implements StateMachineStructureFactory<S, E, C> {

    /** File location of the state machine text. */
    protected final Path path;

    /** Reader used to interpret the state machine text. */
    protected final StringStateMachineReader<S, E, C> stateMachineReader;

    /**
     * Constructors a new FileStateMachineStructureFactory with the specified parameters.
     *
     * @param internalStateFactory the factory used to create internal states.
     * @param transitionFactory the factory used to create transitions.
     * @param path the file location of the state machine text.
     * @param stateMachineReader the reader used to load the state machine.
     */
    public FileStateMachineStructureFactory(InternalStateFactory<S, E, C> internalStateFactory,
                                            TransitionFactory<S, E, C> transitionFactory, Path path,
                                            StringStateMachineReader<S, E, C> stateMachineReader) {
        super(internalStateFactory, transitionFactory);
        this.path = path;
        this.stateMachineReader = stateMachineReader;
    }

    /**
     * Constructors a new FileStateMachineStructureFactory with the specified parameters.
     *
     * @param path the file location of the state machine text.
     * @param stateMachineReader the reader used to load the state machine.
     */
    public FileStateMachineStructureFactory(Path path, StringStateMachineReader<S, E, C> stateMachineReader) {
        super();
        this.path = path;
        this.stateMachineReader = stateMachineReader;
    }

    @Override
    public StateMachineStructure<S, E, C> create() {
        try {
            return new FileStateMachineStructure<>(internalStateFactory, transitionFactory, path, stateMachineReader);
        } catch (IOException e) {
            throw new StateMachineException("Unable to read specified path [" + path + "]", e);
        }
    }
}
