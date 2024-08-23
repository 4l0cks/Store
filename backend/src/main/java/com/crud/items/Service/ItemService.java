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
}
