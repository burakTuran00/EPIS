package com.project.EPIS.core.utility.mapper;

import org.modelmapper.ModelMapper;
public interface IModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
