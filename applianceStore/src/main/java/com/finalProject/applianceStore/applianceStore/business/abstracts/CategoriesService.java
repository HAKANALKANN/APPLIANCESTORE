package com.finalProject.applianceStore.applianceStore.business.abstracts;

import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.CreateCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.UpdateCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.CreateCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.DeleteCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.GetAllCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.UpdateCategoriesResponse;


import java.util.List;


public interface CategoriesService {
    CreateCategoriesResponse add(CreateCategoriesRequest request);

    UpdateCategoriesResponse update(UpdateCategoriesRequest request);

    DeleteCategoriesResponse delete(Integer id);

    List<GetAllCategoriesResponse> getAll();


}
