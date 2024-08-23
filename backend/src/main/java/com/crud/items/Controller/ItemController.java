package com.crud.items.Controller;

import com.crud.items.DTO.ItemDto;
import com.crud.items.Service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> allItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

    @PostMapping("/items")
    public ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto itemDto) {
        ItemDto createdItem = itemService.createItem(itemDto);
        return ResponseEntity.created(URI.create("/items/" + createdItem.getId())).body(createdItem);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable Long id){
        return ResponseEntity.ok(itemService.deleteItem(id));
    }

    @PatchMapping("/items/{id}")
    public ResponseEntity<ItemDto> patchItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.patchItem(id, itemDto));
    }
}
