package com.reservas.table;

import com.reservas.configrestaurant.ConfigRestaurant;
import com.reservas.configrestaurant.RepositoryConfigRestaurant;
import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceTable {

    private final RepositoryTable repositoryTable;
    public List<TableRest> list(){ return this.repositoryTable.findAll(); }

    public TableRest show(Long id) throws NullResponseNotFoundException {
        Optional<TableRest> tableRest = this.repositoryTable.findById(id);
        if(!tableRest.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return tableRest.get(); }

    public TableRest create(TableRest tableRest){ return this.repositoryTable.save(tableRest); }

    public TableRest edit(TableRest tableRest) throws NullResponseNotFoundException {
        Optional<TableRest> table = this.repositoryTable.findById(tableRest.getId());
        if(!table.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositoryTable.save(table.get()); }

    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<TableRest> tableRest = this.repositoryTable.findById(id);
        if(!tableRest.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryTable.deleteById(id); }
}
