package be.avidoo.hexagonal.application;

import be.avidoo.hexagonal.domain.AggregateRoot;
import be.avidoo.hexagonal.domain.EntityId;
import org.springframework.context.ApplicationEventPublisher;

public abstract class ApplicationService<T extends AggregateRoot<? extends EntityId<?>>> {

    protected final ApplicationEventPublisher applicationEventPublisher;


    public ApplicationService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    protected T handleEvents(T aggregateRoot) {
        aggregateRoot.getEvents().forEach(applicationEventPublisher::publishEvent);
        aggregateRoot.clearEvents();

        return aggregateRoot;
    }
}
