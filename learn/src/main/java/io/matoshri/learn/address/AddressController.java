package io.matoshri.learn.address;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    ResponseEntity<Collection<Address>> all() {
        Collection<Address> addressList = addressService.getAll();
        return ResponseEntity.ok(Collections.unmodifiableCollection(addressList));
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> byId(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getById(id));
    }

    @GetMapping("/{city}")
    ResponseEntity<Object> byCity(@PathVariable String city) {
        return ResponseEntity.ok(addressService.getByCity(city));
    }

    @GetMapping("/page/{pageNo}/{size}")
    public Page<Address> getAll(@PathVariable Integer pageNo, @PathVariable Integer size) {
        pageNo = Optional.ofNullable(pageNo).orElse(0);
        size = Optional.ofNullable(size).orElse(10);
        return addressService.getAll(pageNo, size);
    }
}
