package safide.erp.generic.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import safide.erp.generic.application.port.GeneErpService;

public class GeneErpController<T, ID> {
    private final GeneErpService<T, ID> manaGenericService;

    public GeneErpController(GeneErpService<T, ID> manaGenericService) {
        this.manaGenericService = manaGenericService;
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T entity) {
        return new ResponseEntity<>(manaGenericService.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<T>> findAll() {
        return ResponseEntity.ok(manaGenericService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        return ResponseEntity.ok(manaGenericService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable ID id) {
        manaGenericService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
