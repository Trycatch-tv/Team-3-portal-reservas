package com.reservas.categorydish;


import com.reservas.error.NullResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoryDish {
    @Autowired
    private final RepositoryCategoryDish repositoryCategoryDish;

    @Autowired
    public ServiceCategoryDish(RepositoryCategoryDish repositoryCategoryDish){
        this.repositoryCategoryDish = repositoryCategoryDish;
    }

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

    public CategoryDish edit(CategoryDish categoryDish){
        return this.repositoryCategoryDish.save(categoryDish);
    }

    public void delete(Long id){ this.repositoryCategoryDish.deleteById(id);}


}
