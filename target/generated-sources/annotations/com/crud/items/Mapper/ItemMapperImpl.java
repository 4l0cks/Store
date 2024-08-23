package com.crud.items.Mapper;

import com.crud.items.DTO.ItemDto;
import com.crud.items.Entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-23T04:47:35+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.4 (Azul Systems, Inc.)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemEntity toItemEntity(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        ItemEntity.ItemEntityBuilder itemEntity = ItemEntity.builder();

        itemEntity.id( itemDto.getId() );
        itemEntity.brand( itemDto.getBrand() );
        itemEntity.name( itemDto.getName() );
        itemEntity.description( itemDto.getDescription() );
        itemEntity.price( itemDto.getPrice() );
        itemEntity.type( itemDto.getType() );

        return itemEntity.build();
    }

    @Override
    public ItemDto toItemDto(ItemEntity itemEntity) {
        if ( itemEntity == null ) {
            return null;
        }

        ItemDto.ItemDtoBuilder itemDto = ItemDto.builder();

        itemDto.id( itemEntity.getId() );
        itemDto.brand( itemEntity.getBrand() );
        itemDto.name( itemEntity.getName() );
        itemDto.description( itemEntity.getDescription() );
        itemDto.price( itemEntity.getPrice() );
        itemDto.type( itemEntity.getType() );

        return itemDto.build();
    }

    @Override
    public List<ItemDto> toItemDtos(List<ItemEntity> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>( items.size() );
        for ( ItemEntity itemEntity : items ) {
            list.add( toItemDto( itemEntity ) );
        }

        return list;
    }
}
