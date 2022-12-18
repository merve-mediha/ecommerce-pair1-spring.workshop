package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessResult;
import com.etiya.ecommercedemopair1.entities.concretes.Invoice;
import com.etiya.ecommercedemopair1.repository.abstracts.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository invoiceRepository;


    @Autowired
    public InvoiceManager(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;

    }

    @Override
    public Result add(Invoice invoice){
        Invoice invoice1= new Invoice();
        invoice1.setOrder(invoice.getOrder());
        invoice1.setTotalInvoicePrice(invoice.getTotalInvoicePrice());
        invoice1.setInvoiceDate(invoice.getInvoiceDate());
        invoice1.setInvoiceNumber(invoice.getInvoiceNumber());
        invoiceRepository.save(invoice1);

      return new SuccessResult(Messages.AllSuffix.addSuffixOfMessages);
    }

    @Override
    public DataResult<List<Invoice>> getAll(){
        return new SuccessDataResult<List<Invoice>>(invoiceRepository.findAll(),Messages.AllSuffix.allFetchedFromDatabase);
    }
}
