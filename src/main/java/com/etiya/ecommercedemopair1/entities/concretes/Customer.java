package com.etiya.ecommercedemopair1.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id")
public class Customer extends User  {


    @Column(name="gender")
    private String gender;



}
