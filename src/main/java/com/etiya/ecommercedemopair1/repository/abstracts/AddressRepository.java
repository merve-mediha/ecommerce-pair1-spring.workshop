package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Transactional
    @Query(value= "SELECT new com.etiya.ecommercedemopair1.business.dto.GetAllAddressDto FROM Addresses as a JOIN a.cities as c WHERE c.name=:name", nativeQuery = true)
    List<Address> getAddressesByCityNameUsingNative(@Param("name") String name);
}
