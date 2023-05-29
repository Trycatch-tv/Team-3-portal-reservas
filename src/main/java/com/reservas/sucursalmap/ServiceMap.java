package com.reservas.sucursalmap;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.table.RepositoryTable;
import com.reservas.table.TableRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMap {

    @Autowired
    private final RepositoryMap repositoryMap;

    @Autowired
    public ServiceMap(RepositoryMap repositoryMap){
        this.repositoryMap = repositoryMap;
    }

    public List<Maps> list(){ return this.repositoryMap.findAll(); }

    public Maps show(Long id) throws NullResponseNotFoundException  {
        Optional<Maps> maps =this.repositoryMap.findById(id);
        if(!maps.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return maps.get(); }

    public Maps create(Maps maps){ return this.repositoryMap.save(maps); }

    public Maps edit(Maps maps){ return this.repositoryMap.save(maps); }

    public void delete(Long id){ this.repositoryMap.deleteById(id); }

}
