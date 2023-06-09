package com.reservas.categorydish;


import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceCategoryDish {
    private final RepositoryCategoryDish repositoryCategoryDish;

    @Transactional(readOnly = true)
    public List<CategoryDish> list() {
        return this.repositoryCategoryDish.findAll();
    }

    @Transactional(readOnly = true)
    public CategoryDish show(Long id) throws NullResponseNotFoundException {
        Optional<CategoryDish> categoryDishOptional = this.repositoryCategoryDish.findById(id);
        if (!categoryDishOptional.isPresent()) {
            throw new NullResponseNotFoundException("Data not available");
        }
        return categoryDishOptional.get();
    }

    @Transactional
    public CategoryDish create(CategoryDish categoryDish) throws NullResponseNotFoundException {
        Optional<CategoryDish> categoryDish1 = findCategory(categoryDish.getName());
        System.out.println(categoryDish.getName());
        if (categoryDish1.isPresent()) {
            throw new NullResponseNotFoundException("Name already exists");
        }
        System.out.println(categoryDish.getDescription());
        return this.repositoryCategoryDish.save(categoryDish);
    }

    @Transactional
    public CategoryDish edit(CategoryDish categoryDish) throws NullResponseNotFoundException {
        Optional<CategoryDish> category = Optional.of(this.repositoryCategoryDish.findById(categoryDish.getId()).orElseThrow(() -> new NullResponseNotFoundException("Data not available")));
        if (categoryDish.getName() != null && !categoryDish.getName().isEmpty()){
            if(!category.get().getName().equals(categoryDish.getName()) ){
                Optional<CategoryDish> newName = findCategory(categoryDish.getName());
                if (newName.isPresent()){ throw new NullResponseNotFoundException("Name already exists");}
                category.get().setName(categoryDish.getName());
            }
        }

        if (categoryDish.getDescription() != null && !categoryDish.getDescription().isEmpty()){
            category.get().setDescription(categoryDish.getDescription());
        }
        return this.repositoryCategoryDish.save(category.get());
    }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<CategoryDish> category = Optional.of(this.repositoryCategoryDish.findById(id).orElseThrow(() -> new NullResponseNotFoundException("Data not available")));
        this.repositoryCategoryDish.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<CategoryDish> findCategory(String name){
        return this.repositoryCategoryDish.findByName(name);
    };

}

