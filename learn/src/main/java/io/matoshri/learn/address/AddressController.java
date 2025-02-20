package io.matoshri.learn.address;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/learn/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public Collection<Address> getAll() {
        return addressService.getAllAddress();
    }

    @GetMapping
    public Address getAddressById(@RequestParam("id") Integer id) {
        return addressService.getAddressById(id);
    }
}
