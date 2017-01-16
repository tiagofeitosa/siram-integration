package com.arktecnologia.Siram;

import com.arktecnologia.SiramProtocol.SiramProtocol;

public class SiramLpr implements Siram {

	private SiramProtocol protocol;

	public SiramLpr(SiramProtocol protocol) {
		this.protocol = protocol;
	}

	public String stringfy() {

		StringBuilder sb = new StringBuilder();

		sb.append("[").append(SiramConst.LPR).append(";").append(protocol.getCameraId()).append(";")
				.append(protocol.getTransactionId()).append(";").append(protocol.getSecurityCode()).append("]")
				.append("\n");

		return sb.toString();
	}

}
