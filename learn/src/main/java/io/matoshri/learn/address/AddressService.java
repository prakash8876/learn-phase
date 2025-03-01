package io.matoshri.learn.address;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class AddressService {

    private static final String DEFAULT = "default";
    private static final String DEFAULT_PIN_CODE = "000 000";

    private final AddressRepository repo;

    public AddressService(AddressRepository repo) {
        this.repo = repo;
    }

    public Address saveAddress(Address address) {
        if (Objects.isNull(address)) {
            address = new Address();
            address.setArea(DEFAULT);
            address.setCity(DEFAULT);
            address.setPinCode(DEFAULT_PIN_CODE);
        }

        if (StringUtils.isEmpty(address.getArea())) {
            address.setArea(DEFAULT);
        }

        if (StringUtils.isEmpty(address.getCity())) {
            address.setCity(DEFAULT);
        }

        if (StringUtils.isEmpty(address.getPinCode())) {
            address.setPinCode(DEFAULT_PIN_CODE);
        }
        var saved = repo.save(address);
        return saved;
    }

    public Collection<Address> getAll() {
        return this.repo.findAll();
    }

    public Page<Address> getAll(int pageNo, int size) {
        return this.repo.findAll(PageRequest.of(pageNo, size));
    }

    public Address getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    public Address getByCity(String city) {
        return repo.findByCity(city).orElse(null);
    }
}
