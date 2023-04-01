package be.avidoo.hexagonal.framework;

import be.avidoo.hexagonal.domain.AggregateRoot;
import be.avidoo.hexagonal.domain.EntityId;

/**
 * D: DomainEntity
 * J: JpaEntity
 */
public interface EntityMapper<D extends AggregateRoot<? extends EntityId<?>>, J> {


    J toJpaEntity(D domainEntity);

    D toDomainEntity(J jpaEntity);
}
