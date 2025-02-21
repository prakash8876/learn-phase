package io.matoshri.learn.address;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/learn/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<Address>> getAll() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAddressById(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }
}
