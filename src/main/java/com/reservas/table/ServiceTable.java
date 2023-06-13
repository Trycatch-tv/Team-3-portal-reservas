package com.reservas.table;

import com.reservas.configrestaurant.ConfigRestaurant;
import com.reservas.configrestaurant.RepositoryConfigRestaurant;
import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceTable {

    private final RepositoryTable repositoryTable;

    @Transactional(readOnly = true)
    public List<TableRest> list(){ return this.repositoryTable.findAll(); }

    @Transactional(readOnly = true)
    public TableRest show(Long id) throws NullResponseNotFoundException {
        Optional<TableRest> tableRest = this.repositoryTable.findById(id);
        if(!tableRest.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return tableRest.get(); }

    @Transactional
    public TableRest create(TableRest tableRest){ return this.repositoryTable.save(tableRest); }

    @Transactional
    public TableRest edit(TableRest tableRest) throws NullResponseNotFoundException {
        Optional<TableRest> table = this.repositoryTable.findById(tableRest.getId());
        if(!table.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //name, description, capacity,position, status
        if(tableRest.getName() != null && !tableRest.getName().isEmpty()){
            table.get().setName(tableRest.getName());
        }

        if(tableRest.getDescription() != null && !tableRest.getDescription().isEmpty()){
            table.get().setDescription(tableRest.getDescription());
        }

        if(tableRest.getCapacity() != null && tableRest.getCapacity() > 0){
            table.get().setCapacity(tableRest.getCapacity());
        }

        if(tableRest.getPosition() != null && !tableRest.getPosition().isEmpty()){
            table.get().setPosition(tableRest.getPosition());
        }

        if(tableRest.getStatus() != null && (tableRest.getStatus().equals(true) || tableRest.getStatus().equals(false))){
            table.get().setStatus(tableRest.getStatus());
        }

        return this.repositoryTable.save(table.get()); }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<TableRest> tableRest = this.repositoryTable.findById(id);
        if(!tableRest.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryTable.deleteById(id); }
}
