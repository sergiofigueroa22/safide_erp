package safide.erp.generic.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface GeneErpMapper<T, E> {
    @Mappings(
            {
                    @Mapping(source ="id", target="id")
            }
    )
    T toDomain(E entity);
    Iterable<T> toDomainList(Iterable<E> entities);
    @InheritInverseConfiguration
    E toEntity(T domain);
}
