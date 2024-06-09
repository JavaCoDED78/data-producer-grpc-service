package com.javaded.web.mapper;

import com.javaded.model.test.DataTestOptions;
import com.javaded.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
