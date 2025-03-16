package io.matoshri.learn.address;

import io.matoshri.learn.exception.AppIllegalArgumentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {

    private static final String DEFAULT = "default";
    private static final String DEFAULT_PIN_CODE = "000 000";

    private final AddressRepository repo;

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
        final Address saved = repo.save(address);
        log.info("New address saved {}", address);
        return saved;
    }

    public Collection<Address> getAll() {
        return this.repo.findAll();
    }

    public Page<Address> getAll(int pageNo, int size) {
        return this.repo.findAll(PageRequest.of(pageNo, size));
    }

    public Address getById(Integer id) {
        return this.repo.findById(id).orElseThrow(() -> new AppIllegalArgumentException("Invalid Address ID, doesn't exists"));
    }

    public Address getByCity(String city) {
        return repo.findByCity(city).orElseThrow(() -> new AppIllegalArgumentException("Incorrect City, doesn't exists: " + city));
    }
}
