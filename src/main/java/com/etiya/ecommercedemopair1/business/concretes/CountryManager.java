package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CountryService;
import com.etiya.ecommercedemopair1.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public boolean existsById(int id) {
        return countryRepository.existsById(id);
    }
}
