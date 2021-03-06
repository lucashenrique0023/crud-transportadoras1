package br.com.lucaslab.transportadoras.application.service;

import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.lucaslab.transportadoras.util.IOUtils;

@Service
public class ImageService {
	
	@Value("${transportadora.files.logotipo}")
	private String logotiposDir;
	

	public void uploadLogotipo(MultipartFile multipartFile, String fileName) {
		try {
			IOUtils.copy(multipartFile.getInputStream(), fileName, logotiposDir);
		} catch (IOException e) {
			throw new ApplicationServiceException(e);
		}
	}
	
	
	public byte[] getBytes(String type, String imgName) {
		try {
			String dir;
			
			if ("logotipo".equals(type)) {
				dir = logotiposDir;
			} else {
				throw new Exception(type + "nao e um tipo de imagem valido");
			}
			
			return IOUtils.getBytes(Paths.get(dir, imgName));
		} catch (Exception e) {
			throw new ApplicationServiceException(e);
		}
	}
}
