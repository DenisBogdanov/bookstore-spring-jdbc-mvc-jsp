package ru.bogdanium.bookstore.exception;

public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 491636035602981400L;

    private Long bookId;

    public BookNotFoundException(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }
}
