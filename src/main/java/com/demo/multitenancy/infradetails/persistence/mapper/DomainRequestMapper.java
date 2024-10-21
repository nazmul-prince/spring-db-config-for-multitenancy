package com.demo.multitenancy.infradetails.persistence.mapper;

import java.util.List;

public interface DomainRequestMapper<T, S> {

    T requestModelToDomainModel(S requestModel);

    S domainModelToRequestModel(T domainModel);

    List<T> requestModelToDomainModel(List<S> requestModel);

    List<S> domainModelToRequestModel(List<T> domainModel);

}
