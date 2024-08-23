package com.crud.items.Service;

import com.crud.items.DTO.ItemDto;
import com.crud.items.Entity.ItemEntity;
import com.crud.items.Exception.AppException;
import com.crud.items.Mapper.ItemMapper;
import com.crud.items.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;


    public List<ItemDto> getAllItems() {
        List<ItemEntity> items = itemRepository.findAll();
        return itemMapper.toItemDtos(items);
    }


    public ItemDto getItem(Long id) {
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new AppException("Item not found", HttpStatus.NOT_FOUND));
        return itemMapper.toItemDto(item);
    }

    public ItemDto createItem(ItemDto itemDto) {
        ItemEntity newItem = itemMapper.toItemEntity(itemDto);

        ItemEntity createdItem = itemRepository.save(newItem);
        return itemMapper.toItemDto(createdItem);
    }

    public ItemDto deleteItem(Long id){
        ItemEntity itemEntity = itemRepository.findById(id)
                .orElseThrow(() -> new AppException("Item not found", HttpStatus.NOT_FOUND));
        ItemDto itemDto = itemMapper.toItemDto(itemEntity);

        itemRepository.deleteById(id);

        return itemDto;
    }

    public ItemDto patchItem(Long id, ItemDto itemDto) {
        ItemEntity itemEntity= itemRepository.findById(id)
                .orElseThrow(() -> new AppException("Item not found", HttpStatus.NOT_FOUND));

        if (itemDto.getBrand() != null) {
            itemEntity.setBrand(itemDto.getBrand());
        }
        if (itemDto.getName() != null) {
            itemEntity.setName(itemDto.getName());
        }
        if (itemDto.getDescription() != null) {
            itemEntity.setDescription(itemDto.getDescription());
        }
        if (itemDto.getType() != null) {
            itemEntity.setType(itemDto.getType());
        }
        if (itemDto.getPrice() != 0) {
            itemEntity.setPrice(itemDto.getPrice());
        }

        ItemEntity savedItem = itemRepository.save(itemEntity);

        return itemMapper.toItemDto(savedItem);
    }

}
