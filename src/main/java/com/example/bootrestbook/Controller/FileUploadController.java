package com.example.bootrestbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.bootrestbook.Helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("pic1") MultipartFile file) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());

		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image must be of jpeg type");
			}
			// Now file upload code...

			boolean uploadfile = fileUploadHelper.uploadfile(file);
			if (uploadfile) {
//				return ResponseEntity.ok("File is uploaded");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Img/")
						.path(file.getOriginalFilename()).toUriString()); // Ye hame path return karega jaha file serve hui hgi
			}
/*
ServletUriComponentsBuilder.fromCurrentContextPath() = localhost:8080
.path("Img") = /Img
.path(file.getOriginalName) = file_name;

localhost:8080/Image/pic1.jpeg
*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ! try again ...");
	}
}
