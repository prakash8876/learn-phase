package io.matoshri.learn.address;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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
        return repo.save(address);
    }
}
