package com.arktecnologia.Siram;

import com.arktecnologia.SiramProtocol.SiramProtocol;

public class SiramStatus implements Siram {

	private SiramProtocol protocol;

	public SiramStatus(SiramProtocol protocol) {
		this.protocol = protocol;
	}

	public String stringfy() {
		StringBuilder sb = new StringBuilder();

		sb.append("[").append(SiramConst.STATUS).append(";").append(protocol.getCameraId()).append("]")
				.append("\n");

		return sb.toString();
	}

}
