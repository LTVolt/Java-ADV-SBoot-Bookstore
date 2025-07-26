package com.cptvolt.bookapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDTO {
    private Long id;
    private String bookTitle;
    private String author;
    private String isbn;
}
