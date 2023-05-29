package com.reservas.table;

import com.reservas.configrestaurant.ConfigRestaurant;
import com.reservas.configrestaurant.RepositoryConfigRestaurant;
import com.reservas.error.NullResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTable {
    @Autowired
    private final RepositoryTable repositoryTable;

    @Autowired
    public ServiceTable(RepositoryTable repositoryTable){
        this.repositoryTable = repositoryTable;
    }

    public List<TableRest> list(){ return this.repositoryTable.findAll(); }

    public TableRest show(Long id) throws NullResponseNotFoundException {
        Optional<TableRest> tableRest = this.repositoryTable.findById(id);
        if(!tableRest.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return tableRest.get(); }

    public TableRest create(TableRest tableRest){ return this.repositoryTable.save(tableRest); }

    public TableRest edit(TableRest tableRest){ return this.repositoryTable.save(tableRest); }

    public void delete(Long id){ this.repositoryTable.deleteById(id); }
}
