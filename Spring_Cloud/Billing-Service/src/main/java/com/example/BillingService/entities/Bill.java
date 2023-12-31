package com.example.BillingService.entities;

import com.example.BillingService.Models.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date BillingDate;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Long customerid;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> ProductItems;

    public double getTotal(){
        double somme=0;
        for(ProductItem p :ProductItems){
            somme+=p.getAmount();
        }
        return somme;
    }
}
