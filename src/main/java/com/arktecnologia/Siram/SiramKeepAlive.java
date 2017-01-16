package com.arktecnologia.Siram;

import com.arktecnologia.SiramProtocol.SiramProtocol;

public class SiramKeepAlive implements Siram {

	private SiramProtocol protocol;

	public SiramKeepAlive(SiramProtocol protocol) {
		this.protocol = protocol;
	}

	public String stringfy() {
		StringBuilder sb = new StringBuilder();

		sb.append("[").append(SiramConst.KEEP_ALIVE).append(";").append(protocol.getCameraId()).append("]")
				.append("\n");

		return sb.toString();
	}

}
