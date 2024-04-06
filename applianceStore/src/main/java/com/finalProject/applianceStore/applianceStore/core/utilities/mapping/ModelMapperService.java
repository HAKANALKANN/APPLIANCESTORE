package com.finalProject.applianceStore.applianceStore.core.utilities.mapping;
import org.modelmapper.ModelMapper;
public interface ModelMapperService {
ModelMapper forResponse();
ModelMapper forRequest();
}
