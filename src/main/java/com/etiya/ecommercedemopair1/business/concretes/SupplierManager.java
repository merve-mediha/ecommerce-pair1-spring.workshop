package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.SupplierService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.messages.MessageService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessResult;
import com.etiya.ecommercedemopair1.entities.concretes.Supplier;
import com.etiya.ecommercedemopair1.repository.abstracts.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {

    private SupplierRepository supplierRepository;
    private final ModelMapperService modelMapperService;
    private MessageService messageService;

    @Override
    public Result addSupplier(AddSupplierRequest addSupplierRequest) {
        // Matching
        Supplier supplier = modelMapperService.getMapperforRequest().map(addSupplierRequest, Supplier.class);

        supplierRepository.save(supplier);
        return new SuccessResult(messageService.getMessage(Messages.AllSuffix.addSuffixOfMessages));
    }

    @Override
    public DataResult<GetSupplierResponse> addSupplierWithInfo(AddSupplierRequest addSupplierRequest) {
        // Matching
        Supplier supplier = modelMapperService.getMapperforRequest().map(addSupplierRequest, Supplier.class);

       Supplier savedSupplier =  supplierRepository.save(supplier);


        GetSupplierResponse getSupplierResponse = modelMapperService.getMapperforResponse()
                .map(savedSupplier, GetSupplierResponse.class);
        return new SuccessDataResult<GetSupplierResponse>(getSupplierResponse,messageService.getMessage(Messages.AllSuffix.addSuffixOfMessages));

    }

    @Override
    public DataResult<List<GetSupplierResponse>> getAll(){
        List<Supplier> suppliers = supplierRepository.findAll();
        List<GetSupplierResponse> responses = suppliers.stream()
                .map(supplier -> modelMapperService.getMapperforResponse()
                .map(supplier,GetSupplierResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetSupplierResponse>>(responses,messageService.getMessage(Messages.AllSuffix.allFetchedFromDatabase));
    }
}
