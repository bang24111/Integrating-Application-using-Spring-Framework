package com.example.thith_iasf.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@SuperBuilder
public class PageDto {
    private Integer pageSize;
    private Integer pageNumber;
}
