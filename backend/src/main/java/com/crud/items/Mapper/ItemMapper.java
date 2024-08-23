package com.crud.items.Mapper;

import com.crud.items.DTO.ItemDto;
import com.crud.items.Entity.ItemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemEntity toItemEntity(ItemDto itemDto);

    ItemDto toItemDto(ItemEntity itemEntity);

    List<ItemDto> toItemDtos(List<ItemEntity> items);
}
