package io.matoshri.learn.address;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

interface AddressRepository extends ListPagingAndSortingRepository<Address, Integer>, ListCrudRepository<Address, Integer> {

    @Query("FROM Address a WHERE a.city = :city")
    Optional<Address> findByCity(@Param("city") String city);
}
