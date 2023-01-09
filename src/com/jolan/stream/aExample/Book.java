package com.jolan.stream.aExample;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private Long id;
    private String name;
    private String category;
    private Integer score;
    private String intro;
}
