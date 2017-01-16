package com.arktecnologia.Siram;

public enum SiramConst {
	LPR("lpr"), 
	STATUS("status"), 
	KEEP_ALIVE("keep-alive"), 
	OCR_VERSION("ocr-version"), 
	QUIT("quit"), 
	
	DIR_IMG("/home/tiago/Imagens"), 
	FILE_EXT("jpg");

	private String command;

	private SiramConst(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return command;
	}
}
