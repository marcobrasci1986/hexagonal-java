package be.avidoo.hexagonal.domain;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class EntityId<T> {

    private final T value;

    public EntityId(T value) {
        this.value = requireNonNull(value);
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityId<?> entityId = (EntityId<?>) o;
        return value.equals(entityId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
