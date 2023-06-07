package com.reservas.categorydish;


import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceCategoryDish {
    private final RepositoryCategoryDish repositoryCategoryDish;

    public List<CategoryDish> list(){
        return this.repositoryCategoryDish.findAll();
    }

    public CategoryDish show(Long id) throws NullResponseNotFoundException {
        Optional<CategoryDish> categoryDishOptional= this.repositoryCategoryDish.findById(id);
        if(!categoryDishOptional.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return categoryDishOptional.get(); }

    public CategoryDish create(CategoryDish categoryDish){
        return this.repositoryCategoryDish.save(categoryDish);
    }

    public CategoryDish edit(CategoryDish categoryDish) throws NullResponseNotFoundException {
        Optional<CategoryDish> category = Optional.of(this.repositoryCategoryDish.findById(categoryDish.getId()).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        //Validar entrada
        return this.repositoryCategoryDish.save(category.get());
    }

    public void delete(Long id) throws NullResponseNotFoundException{
        Optional<CategoryDish> category = Optional.of(this.repositoryCategoryDish.findById(id).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        this.repositoryCategoryDish.deleteById(id);
    }


}
