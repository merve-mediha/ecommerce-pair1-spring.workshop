package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


    @Query("select a from Address a JOIN a.city c where c.name=:name")
    List<Address> findAddressByCityName(@Param("name") String name);




}
