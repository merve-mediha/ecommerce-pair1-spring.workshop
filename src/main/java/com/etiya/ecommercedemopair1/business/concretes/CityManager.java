package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CityService;
import com.etiya.ecommercedemopair1.repository.abstracts.CityRepository;
import org.springframework.stereotype.Service;

@Service

public class CityManager implements CityService {
    private final CityRepository cityRepository;

    public CityManager(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean existsById(int id) {
        return cityRepository.existsById(id);
    }
}
