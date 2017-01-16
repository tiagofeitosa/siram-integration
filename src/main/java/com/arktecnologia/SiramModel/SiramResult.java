package com.arktecnologia.SiramModel;

public class SiramResult {

	private Integer cameraId;

	private String command;
	private Integer transactionId;
	private Integer errorCode;
	private String plate;
	private String date;
	private String time;
	private Integer pictureType;
	private Integer pictureLength;
	private Integer statusCode;
	private String versionNumber;

	public SiramResult(Integer cameraId, String command, Integer transactionId, Integer errorCode, String plate,
			String date, String time, Integer pictureType, Integer pictureLength, Integer statusCode,
			String versionNumber) {

		this.cameraId = cameraId;
		this.command = command;
		this.transactionId = transactionId;
		this.errorCode = errorCode;
		this.plate = plate;
		this.date = date;
		this.time = time;
		this.pictureType = pictureType;
		this.pictureLength = pictureLength;
		this.statusCode = statusCode;
		this.versionNumber = versionNumber;
	}

	public SiramResult(String[] header) {
		if (header[0].matches("lpr-result")) {
			new SiramResult(Integer.valueOf(header[1]), header[0], Integer.valueOf(header[2]),
					Integer.valueOf(header[3]), header[4], header[5], header[6], Integer.valueOf(header[7]),
					Integer.valueOf(header[8]), null, null);
		} else if (header[0] == "status-result") {
			new SiramResult(Integer.valueOf(header[1]), header[0], null, null, null, null, null, null, null,
					Integer.valueOf(header[2]), null);
		} else if (header[0] == "keep-alive-response") {
			new SiramResult(Integer.valueOf(header[1]), header[0], null, null, null, null, null, null, null, null,
					null);
		} else if (header[0] == "ocr-version-result") {
			new SiramResult(Integer.valueOf(header[1]), header[0], null, null, null, null, null, null, null, null,
					header[2]);
		}
	}

	public Integer getCameraId() {
		return cameraId;
	}

	public void setCameraId(Integer cameraId) {
		this.cameraId = cameraId;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getPictureType() {
		return pictureType;
	}

	public void setPictureType(Integer pictureType) {
		this.pictureType = pictureType;
	}

	public Integer getPictureLength() {
		return pictureLength;
	}

	public void setPictureLength(Integer pictureLength) {
		this.pictureLength = pictureLength;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	@Override
	public String toString() {
		return "SiramResult [cameraId=" + cameraId + ", command=" + command + ", transactionId=" + transactionId
				+ ", errorCode=" + errorCode + ", plate=" + plate + ", date=" + date + ", time=" + time
				+ ", pictureType=" + pictureType + ", pictureLength=" + pictureLength + ", statusCode=" + statusCode
				+ ", versionNumber=" + versionNumber + "]";
	}

}
