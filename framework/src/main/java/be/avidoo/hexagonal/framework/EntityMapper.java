package be.avidoo.hexagonal.framework;

import be.avidoo.hexagonal.domain.AggregateRoot;

/**
 * D : DomainEntity
 * J: JpaEntity
 */
public interface EntityMapper<D extends AggregateRoot, J> {


    J toJpaEntity(D domainEntity);

    D toDomainEntity(J jpaEntity);
}
