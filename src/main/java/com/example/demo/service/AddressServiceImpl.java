package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.interfaces.base.BaseService;
import com.example.demo.service.interfaces.AddressService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends BaseService<Address, AddressDto, Integer, AddressRepository>
        implements AddressService {

    public AddressServiceImpl(AddressRepository repository,
                              MapperFacade mapper) {
        super(Address.class, AddressDto.class, repository, mapper);
    }
}
