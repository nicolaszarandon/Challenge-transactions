package com.rest.transactions.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.rest.transactions.dto.TransactionDto;
import com.rest.transactions.entity.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	@Mappings({
	      @Mapping(target="sum", ignore = true)     
	      
	         })
	TransactionDto toDto(Transaction transaction);

}
