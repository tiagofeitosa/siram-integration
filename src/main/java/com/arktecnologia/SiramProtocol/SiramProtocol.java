package com.arktecnologia.SiramProtocol;

public class SiramProtocol {

	private int cameraId;
	private int transactionId;
	private String securityCode;

	public SiramProtocol(int cameraId) {
		this.cameraId = cameraId;
	}

	public SiramProtocol(int cameraId, int transactionId, String securityCode) {
		new SiramProtocol(cameraId);
		this.transactionId = transactionId;
		this.securityCode = securityCode;
	}

	public int getCameraId() {
		return cameraId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;

	}
}
