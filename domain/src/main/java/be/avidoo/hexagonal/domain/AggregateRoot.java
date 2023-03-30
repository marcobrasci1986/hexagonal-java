package be.avidoo.hexagonal.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class AggregateRoot<T extends EntityId<?>> {

    private final T id;

    public AggregateRoot(T id) {
        this.id = requireNonNull(id);
    }

    public T getId() {
        return id;
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
