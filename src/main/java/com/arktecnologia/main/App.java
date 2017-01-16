package com.arktecnologia.main;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.arktecnologia.Siram.Siram;
import com.arktecnologia.Siram.SiramConst;
import com.arktecnologia.Siram.SiramKeepAlive;
import com.arktecnologia.Siram.SiramLpr;
import com.arktecnologia.Siram.SiramOcrVersion;
import com.arktecnologia.Siram.SiramStatus;
import com.arktecnologia.SiramModel.SiramResult;
import com.arktecnologia.SiramProtocol.SiramProtocol;
import com.arktecnologia.SiramUtils.Utils;

public class App {

	public static void main(String[] args) {

		// Lpr
		SiramProtocol protocol = new SiramProtocol(1, 1, "1090F");
		Siram siram = new SiramLpr(protocol);

		String data = siram.stringfy();

		try {
			Socket clientSocket = new Socket("192.168.0.67", 27001);

			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(data);

			BufferedInputStream inputFromServerSocket = new BufferedInputStream(clientSocket.getInputStream());

			byte[] aux = new byte[1024 * 512];
			int size = inputFromServerSocket.read(aux);
			
			String result = new String(aux);
			String[] header = result.substring(result.indexOf('[') + 1, result.indexOf(']')).split(";");			
			
			SiramResult siramResult = new SiramResult(Integer.valueOf(header[1]), header[0], Integer.valueOf(header[2]),
					Integer.valueOf(header[3]), header[4], header[5], header[6], Integer.valueOf(header[7]),
					Integer.valueOf(header[8]), null, null);
			
			System.out.println(siramResult);
			
			int beginImg = result.indexOf(']') + 1;
			
			byte[] img = new byte[size - beginImg];
			
			System.arraycopy(aux, beginImg, img, 0, size - beginImg);
			
			FileOutputStream fileOuputStream = new FileOutputStream(new File(SiramConst.DIR_IMG + "/" + siramResult.getPlate() + "." + SiramConst.FILE_EXT));
			fileOuputStream.write(img);
			fileOuputStream.close();
			
			// Status
			 protocol = new SiramProtocol(1);
			 siram = new SiramStatus(protocol);

			 data = siram.stringfy();
			 System.out.println(data);

			 // Keep alive
			 protocol = new SiramProtocol(1);
			 siram = new SiramKeepAlive(protocol);

			 data = siram.stringfy();
			 System.out.println(data);

			 // OCR version
			 protocol = new SiramProtocol(1);
			 siram = new SiramOcrVersion(protocol);

			 data = siram.stringfy();
			 System.out.println(data);

			clientSocket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
