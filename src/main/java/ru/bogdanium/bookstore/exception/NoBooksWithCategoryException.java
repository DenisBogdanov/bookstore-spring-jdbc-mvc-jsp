package ru.bogdanium.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No books found with this category")
public class NoBooksWithCategoryException extends RuntimeException {
    private static final long serialVersionUID = -5934780258506149395L;
}
