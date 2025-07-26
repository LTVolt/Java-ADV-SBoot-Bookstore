package com.cptvolt.bookapi.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookRequestDTO {

    @NotBlank(message = "The book title is required. Please...")
    @Size(min = 1, max = 255, message = "Title must be between 1-255 characters long. How'd you mess that up?")
    private String bookTitle;

    @NotBlank(message = "Book requires an Author. Who wrote it?")
    @Size(min = 1, max = 255, message = "Author must be between 1-255 characters long. How'd you mess that up?")
    private String author;

    @NotBlank(message = "ISBN is required, cause that's a big number that identifies a unique book.")
    private String isbn;
}
