package com.reservas.booking;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceBooking {

    private final RepositoryBooking repositoryBooking;
    @Transactional(readOnly = true)
    public List<Booking> list(){
        return this.repositoryBooking.findAll();
    }

    @Transactional(readOnly = true)
    public Booking show(Long id) throws NullResponseNotFoundException {
        Optional<Booking> booking=  this.repositoryBooking.findById(id);
        if (!booking.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return booking.get();
    }
    @Transactional
    public Booking create(Booking booking){
        return this.repositoryBooking.save(booking);
    }

    @Transactional
    public Booking edit(Booking booking) throws NullResponseNotFoundException{
        Optional<Booking> book=  Optional.of(this.repositoryBooking.findById(booking.getId()).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        //Validar entrada
        return this.repositoryBooking.save(book.get());
    }
    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException{
        Optional<Booking> booking=  Optional.of(this.repositoryBooking.findById(id).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        this.repositoryBooking.deleteById(id);
    }
}
