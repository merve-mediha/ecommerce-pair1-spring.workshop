package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Address;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    String findEmailByName(String name);
    @Query("select c from Customer c where c.gender=:gender")
    List<Customer> getCustomerWithGender(String gender);
    boolean existsById(int id);


//    @Query("Select c from Address as a join a.User as u join u.Customer as c Where a.id=:id")
//    Customer findCustomerWhereAddressId(@Param("id") int id);

//@Query("Select c from Customer c JOIN c.User u on u.id=c.id where u.name=:name")
//String getEmailByCustomerName(@Param("name") String name);
}
