package safide.erp.generic.domain.port;

public interface IGeneErpRepository<T, ID> {
    T save (T entity);
    Iterable<T> findAll();
    T findById(ID id);
    //Iterable<T> findAllPageable(Pageable pageable);
    T update(ID id, T entity);
    void deleteById(ID id);
}
