package com.etiya.ecommercedemopair1.business.dtos.request.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInvoiceforOrderRequest {
    private int invoiceNumber;

    private double totalInvoicePrice;

    private LocalDate invoiceDate;
}
