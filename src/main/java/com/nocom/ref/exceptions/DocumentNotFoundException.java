package com.nocom.ref.exceptions;

public class DocumentNotFoundException extends RuntimeException {

    public DocumentNotFoundException(String name) {
        super("Document not found : " + name);
    }

}