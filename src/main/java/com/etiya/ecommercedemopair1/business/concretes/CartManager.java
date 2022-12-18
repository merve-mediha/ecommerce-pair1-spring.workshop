package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CartService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.cart.GetCartResponse;
import com.etiya.ecommercedemopair1.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Cart;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import com.etiya.ecommercedemopair1.repository.abstracts.CartRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartManager implements CartService {
    private CartRepository cartRepository;
    private ModelMapperService modelMapperService;
    private final CustomerRepository customerRepository;


    @Override
    public DataResult<List<GetCartResponse>> getAll() {
        List<Cart> carts = cartRepository.findAll();
        List<GetCartResponse> responses= carts.stream()
                .map(cart-> modelMapperService.getMapperforResponse()
                        .map(cart,GetCartResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetCartResponse>>(responses, Messages.AllSuffix.allFetchedFromDatabase);
    }

    @Override
    public DataResult<GetCartResponse> addCart(AddCartRequest addCartRequest) {
        checkCustomerExists(addCartRequest.getCustomerId());
        Cart cart = modelMapperService.getMapperforRequest().map(addCartRequest, Cart.class);
        Cart savedCart = cartRepository.save(cart);
        GetCartResponse response = modelMapperService.getMapperforResponse().map(savedCart, GetCartResponse.class);

        return new SuccessDataResult<GetCartResponse>(response, Messages.AllSuffix.allFetchedFromDatabase);
    }

    @Override
    public List<Product> findProductsByCartId(int id) {
        return cartRepository.findProductsByCartId(id);
    }


    private void checkCustomerExists(int id){

        boolean isExists = customerRepository.existsById(id);
        if(!isExists){
            throw new BusinessException("This customer doesn't exist in database");
        }
    }
}
