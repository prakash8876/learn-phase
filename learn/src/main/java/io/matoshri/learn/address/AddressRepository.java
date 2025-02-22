package io.matoshri.learn.address;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository extends ListCrudRepository<Address, Integer> {

    @Query("FROM Address a WHERE a.city = :city")
    Optional<Address> findByCity(@Param("city") String city);
}
