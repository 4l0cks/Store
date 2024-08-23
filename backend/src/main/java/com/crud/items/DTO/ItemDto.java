package com.crud.items.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
//todo : enlever getter et setter si data fonctionnent
@Getter
@Setter
public class ItemDto {

    private Long id;

    @NotNull
    private String brand;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private float price;

    @NotNull
    private String type;
}
