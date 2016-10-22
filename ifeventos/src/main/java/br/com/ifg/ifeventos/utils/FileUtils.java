package br.com.ifg.ifeventos.utils;

import java.io.File;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class FileUtils {
	
	
	public static void save(UploadedFile imagem, String path, String filename) throws Exception{
		File imageFile = new File(path, filename);
		imagem.writeTo(imageFile);
	}
	
	public static void delete(String path, String filename){
		File file = new File(path, filename);
		if (file.exists()){
			file.delete();
		}  		
	}
}
