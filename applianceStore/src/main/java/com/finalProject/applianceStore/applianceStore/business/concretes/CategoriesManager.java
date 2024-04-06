package com.finalProject.applianceStore.applianceStore.business.concretes;

import com.finalProject.applianceStore.applianceStore.business.abstracts.CategoriesService;
import com.finalProject.applianceStore.applianceStore.core.utilities.mapping.ModelMapperService;
import com.finalProject.applianceStore.applianceStore.dataaccess.CategoriesRepository;
import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.CreateCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.UpdateCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.CreateCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.DeleteCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.GetAllCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.UpdateCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.GetAllProductResponse;
import com.finalProject.applianceStore.applianceStore.entities.Categories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriesManager implements CategoriesService {
    CategoriesRepository categoriesRepository;
    ModelMapperService modelMapperService;

    @Override
    public CreateCategoriesResponse add(CreateCategoriesRequest request) {
        Categories categories = modelMapperService.forRequest().map(request,Categories.class);
        Categories createCategories = categoriesRepository.save(categories);

        CreateCategoriesResponse createCategoriesResponse =
                modelMapperService.forResponse().map(createCategories, CreateCategoriesResponse.class);

        return createCategoriesResponse;
    }

    @Override
    public UpdateCategoriesResponse update(UpdateCategoriesRequest request) {
       Categories categories = modelMapperService.forRequest().map(request, Categories.class);

        Categories updateCategories = categoriesRepository.save(categories);

        UpdateCategoriesResponse updateCategoriesResponse = modelMapperService.forResponse().map(updateCategories, UpdateCategoriesResponse.class);
        return updateCategoriesResponse;
    }

    @Override
    public DeleteCategoriesResponse delete(Integer id) {
       Categories categoriesToDelete = new Categories();
       categoriesToDelete.setId(id);
       categoriesRepository.delete(categoriesToDelete);

       DeleteCategoriesResponse response = new DeleteCategoriesResponse();
       response.setId(id);
       return response;
    }

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Categories> categories = categoriesRepository.findAll();

        List<GetAllCategoriesResponse> result = categories.stream().map(categories1 -> this.modelMapperService.forResponse()
                .map(categories1, GetAllCategoriesResponse.class)).collect(Collectors.toList());
        return result;
    }


    }


