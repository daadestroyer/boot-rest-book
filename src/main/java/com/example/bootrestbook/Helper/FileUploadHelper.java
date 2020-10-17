package com.example.bootrestbook.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	// public final String UPLOAD_DIR = "D:\\youtube videos\\Learn code with Durgesh\\Spring\\Practical\\bootrestbook\\src\\main\\resources\\static\\Img";
	public final String UPLOAD_DIR = new ClassPathResource("static/Img/").getFile().getAbsolutePath();

	public FileUploadHelper()throws IOException {
		
	}
	public boolean uploadfile(MultipartFile file) {
		boolean status = false;

		try {
//			// READ DATA
//			InputStream inputStream = file.getInputStream();
//			byte[] data = new byte[inputStream.available()];
//			inputStream.read(data);
//
//			// WRITE DATA
//			File file1;
//			FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + "\\" + file.getOriginalFilename());
//			fileOutputStream.write(data);
//			fileOutputStream.flush();
//			fileOutputStream.close();
//			inputStream.close();

			
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+"\\"+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			status = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
