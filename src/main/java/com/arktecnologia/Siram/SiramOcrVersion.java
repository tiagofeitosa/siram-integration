package com.arktecnologia.Siram;

import com.arktecnologia.SiramProtocol.SiramProtocol;

public class SiramOcrVersion implements Siram {

	private SiramProtocol protocol;

	public SiramOcrVersion(SiramProtocol protocol) {
		this.protocol = protocol;
	}

	public String stringfy() {
		StringBuilder sb = new StringBuilder();

		sb.append("[").append(SiramConst.OCR_VERSION).append(";").append(protocol.getCameraId()).append("]")
				.append("\n");

		return sb.toString();
	}

}
