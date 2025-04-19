package safide.erp.generic.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;

public interface GeneErpMapper<T, E> {
    T toDomain(E entity);
    Iterable<T> toDomainList(Iterable<E> entities);
    @InheritInverseConfiguration
    E toEntity(T domain);
}
