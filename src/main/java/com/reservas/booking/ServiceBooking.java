package com.reservas.booking;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceBooking {

    private final RepositoryBooking repositoryBooking;
    public List<Booking> list(){
        return this.repositoryBooking.findAll();
    }
    public Booking show(Long id) throws NullResponseNotFoundException {
        Optional<Booking> booking=  this.repositoryBooking.findById(id);
        if (!booking.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return booking.get();
    }

    public Booking create(Booking booking){
        return this.repositoryBooking.save(booking);
    }

    public Booking edit(Booking booking) throws NullResponseNotFoundException{
        Optional<Booking> book=  Optional.of(this.repositoryBooking.findById(booking.getId()).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        //Validar entrada
        return this.repositoryBooking.save(book.get());
    }

    public void delete(Long id) throws NullResponseNotFoundException{
        Optional<Booking> booking=  Optional.of(this.repositoryBooking.findById(id).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        this.repositoryBooking.deleteById(id);
    }
}
