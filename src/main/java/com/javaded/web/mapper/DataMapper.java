package com.javaded.web.mapper;

import com.javaded.model.Data;
import com.javaded.web.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
