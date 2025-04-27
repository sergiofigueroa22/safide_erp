package safide.erp.generic.application.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import safide.erp.generic.domain.port.IGeneErpRepository;

public class GeneErpService <T, ID> {
    private final IGeneErpRepository<T, ID> iGeneErpRepository;

    public GeneErpService(IGeneErpRepository<T, ID> iGeneErpRepository) {
        this.iGeneErpRepository = iGeneErpRepository;
    }

    public T save(T entity) {
        return iGeneErpRepository.save(entity);
    }

    public Iterable<T> findAll(){
        return iGeneErpRepository.findAll();
    }

    public T findById(ID id) {
        return iGeneErpRepository.findById(id);
    }

    public T update(ID id, T entity) {
        return iGeneErpRepository.save(entity);
    }

    public void deleteById(ID id) {
        iGeneErpRepository.deleteById(id);
    }

//    public Page<T> findAll(Pageable pageable) {
//        return iGeneErpRepository.findAll(pageable);
//    }

}
