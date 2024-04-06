package com.finalProject.applianceStore.applianceStore.business.concretes;

import com.finalProject.applianceStore.applianceStore.core.utilities.mapping.ModelMapperService;
import com.finalProject.applianceStore.applianceStore.dataaccess.AddressRepository;
import com.finalProject.applianceStore.applianceStore.dtos.AddressDTO;
import com.finalProject.applianceStore.applianceStore.entities.Address;
import org.springframework.stereotype.Service;


@Service
public class AddressManager {
    private final AddressRepository addressRepository;
private ModelMapperService modelMapperService;
    public AddressManager(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO saveAddress(AddressDTO dto) {
        Address address = modelMapperService.forRequest().map(dto,Address.class);
        address.setState(address.getState());
        address.setStreet(address.getStreet());
        address.setCity(address.getCity());
        address.setCountry(address.getCountry());
        address.setBuildingName(address.getBuildingName());
        address.setPincode(address.getPincode());
        Address sevaedAddress = addressRepository.save(address);

        AddressDTO addressDTO = modelMapperService.forResponse().map(sevaedAddress,AddressDTO.class);


        return addressDTO;
    }
}