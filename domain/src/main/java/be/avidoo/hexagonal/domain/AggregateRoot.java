package be.avidoo.hexagonal.domain;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @param <T>: Implementation of EntityId
 */
@Getter
public class AggregateRoot<T extends EntityId<?>> {

    private final T id;

    private final List<DomainEvent> events;


    public AggregateRoot(@NonNull T id) {
        this.id = id;
        this.events = new ArrayList<>();
    }

    public void clearEvents() {
        events.clear();
    }

    public List<DomainEvent> getEvents() {
        return Collections.unmodifiableList(events); // prevent mutating
    }

    protected void registerEvent(DomainEvent domainEvent) {
        events.add(domainEvent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggregateRoot<?> that = (AggregateRoot<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
