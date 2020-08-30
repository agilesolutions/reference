package com.nocom.ref.exceptions;

public class DocumentNotUploadedException extends RuntimeException {

    public DocumentNotUploadedException(String name) {
        super("Document not uploaded : " + name);
    }

}