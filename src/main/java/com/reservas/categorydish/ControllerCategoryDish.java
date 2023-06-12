package com.reservas.categorydish;

import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/category-dish")
public class ControllerCategoryDish {

    private final ServiceCategoryDish serviceCategoryDish;
    @GetMapping
    public ResponseEntity<List<CategoryDish>> list(){
        return ResponseEntity.ok(this.serviceCategoryDish.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDish> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceCategoryDish.show(id)); }

    @PostMapping
    public ResponseEntity<CategoryDish> create(@RequestBody @Valid CategoryDish categoryDish)  throws NullResponseNotFoundException {
        System.out.println(categoryDish.getName()+" Controller");
        return ResponseEntity.ok(this.serviceCategoryDish.create(categoryDish));
    }

    @PutMapping
    public ResponseEntity<CategoryDish> edit(@RequestBody CategoryDish categoryDish) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceCategoryDish.edit(categoryDish)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException{
        this.serviceCategoryDish.delete(id);
        return ResponseEntity.ok("Deleted category dish.");
    }
}
