package com.test.helper;

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
	public final String UPLOAD_DIR= new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	
	
	public FileUploadHelper()  throws IOException{
		
	}
	
	
	
	
	
	public boolean uploadFile(MultipartFile f) {
		boolean t=false;
		
		try {
			
//			InputStream is= f.getInputStream();
//			byte data[]= new byte[is.available()];
//			is.read();
//			
//			FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+File.separator+f.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			Files.copy(f.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			t=true;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
}
