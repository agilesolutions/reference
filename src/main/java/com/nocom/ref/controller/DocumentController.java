package com.nocom.ref.controller;


import com.nocom.ref.exceptions.DocumentNotFoundException;
import com.nocom.ref.exceptions.DocumentNotUploadedException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class DocumentController {

    // Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/user1/uploads/";

    // Single file upload
    @PostMapping("/rest/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {

        if (uploadfile.isEmpty()) {
            return new ResponseEntity("You must select a file!", HttpStatus.OK);
        }

        try {

            saveUploadedFile(uploadfile);

        } catch (IOException e) {
            throw new DocumentNotUploadedException(uploadfile.getName());
        }

        return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
                HttpStatus.OK);

    }

    // file download
    @RequestMapping(path = "/rest/download", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(String param) throws IOException {

        File file = new File(param);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok().headers(headers).contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
    }

    // save file
    private void saveUploadedFile(MultipartFile file) throws IOException {


        if (file.isEmpty()) {
            throw new DocumentNotFoundException(file.getName());
        }

        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);


    }

}
