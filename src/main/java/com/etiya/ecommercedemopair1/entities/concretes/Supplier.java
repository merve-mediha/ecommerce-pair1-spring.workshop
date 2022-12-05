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
@Table(name="suppliers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id")
public class Supplier extends User {



    @Column(name="description")
    private String description;


}
