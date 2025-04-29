package safide.erp.generic.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface GeneErpMapper<T, E> {
    @Mappings(
            {
                    @Mapping(source ="id", target="id"),
                    @Mapping(source ="id_macohe", target="id_macohe"),
                    @Mapping(source ="id_macode", target="id_macode")
            }
    )
    T toDomain(E entity);
    Iterable<T> toDomainList(Iterable<E> entities);
    @InheritInverseConfiguration
    E toEntity(T domain);
}
