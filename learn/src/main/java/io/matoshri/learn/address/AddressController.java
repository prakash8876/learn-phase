package io.matoshri.learn.address;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    ResponseEntity<Collection<Address>> all() {
        log.info("Fetching all addresses");
        Collection<Address> addressList = Collections.unmodifiableCollection(addressService.getAll());
        return ResponseEntity.ok(addressList);
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> byId(@PathVariable int id) {
        log.info("Fetching address by ID: {}", id);
        final var address = addressService.getById(id);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/{city}")
    ResponseEntity<Object> byCity(@PathVariable String city) {
        log.info("Fetching address by City: {}", city);
        final var address = addressService.getByCity(city);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/page/{pageNo}/{size}")
    public Collection<Address> getAll(@PathVariable Integer pageNo, @PathVariable Integer size) {
        log.info("Fetching all address from page no {} size {}", pageNo, size);
        pageNo = Optional.ofNullable(pageNo).orElse(0);
        size = Optional.ofNullable(size).orElse(10);
        final var all = addressService.getAll(pageNo, size).toList();
        log.info("Fetched address: {}", all.size());
        return all;
    }
}
