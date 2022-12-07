package com.etiya.ecommercedemopair1.core.util.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper getMapperforResponse();
    ModelMapper getMapperforRequest();
}
