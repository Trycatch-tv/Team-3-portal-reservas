package com.reservas.detailraiting;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceDetailRaiting {

    private final RepositoryDetailRaiting repositoryDetailRaiting;

    @Transactional(readOnly = true)
    public List<DetailRaiting> list(){ return this.repositoryDetailRaiting.findAll(); }

    @Transactional(readOnly = true)
    public DetailRaiting show(Long id) throws NullResponseNotFoundException {
        Optional<DetailRaiting> detailRaiting = this.repositoryDetailRaiting.findById(id);
        if(!detailRaiting.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return detailRaiting.get();}

    @Transactional
    public DetailRaiting create(DetailRaiting detailRaiting){ return this.repositoryDetailRaiting.save(detailRaiting); }

    @Transactional
    public DetailRaiting edit(DetailRaiting detailRaiting) throws NullResponseNotFoundException {
        Optional<DetailRaiting> detail = Optional.of(this.repositoryDetailRaiting.findById(detailRaiting.getId()).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        if(detailRaiting.getComments() != null && !detailRaiting.getComments().isEmpty()){
            detail.get().setComments(detailRaiting.getComments());
        }
        return this.repositoryDetailRaiting.save(detail.get());
    }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<DetailRaiting> detail = Optional.of(this.repositoryDetailRaiting.findById(id).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        this.repositoryDetailRaiting.deleteById(id);
    }
}
