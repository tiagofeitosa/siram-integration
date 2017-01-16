package com.arktecnologia.SiramUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.arktecnologia.Siram.SiramConst;
import com.arktecnologia.SiramModel.SiramResult;

public class Utils {

	public static SiramResult getInfoSiramResult (BufferedInputStream stream){
		
		SiramResult siramResult = null;
		
		byte[] aux = new byte[1024 * 512];
		int size = 0;
		
		try {
			size = stream.read(aux);
			String result = new String(aux);
			String[] header = result.substring(result.indexOf('[') + 1, result.indexOf(']')).split(";");			
			
			siramResult = new SiramResult(header);
			
			int beginImg = result.indexOf(']') + 1;
			
			byte[] img = new byte[size - beginImg];
			
			System.arraycopy(aux, beginImg, img, 0, size - beginImg);
			
			FileOutputStream fileOuputStream = new FileOutputStream(new File(SiramConst.DIR_IMG + "/" + siramResult.getPlate() + "." + SiramConst.FILE_EXT));
			fileOuputStream.write(img);
			fileOuputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return siramResult;
	}
}
