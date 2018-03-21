package com.harold.struts;

import java.io.File;
import java.io.IOException;

import org.apache.*;
import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.*;

public class UploadAction {
	private static final long serialVersionUID = 1L;

	private String uploader;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String execute() throws Exception {
		String realpath = getSavePath();
		if (upload != null) {
			File saveFile = new File(realpath, getUploadFileName());
			if (!saveFile.getParentFile().exists())
				saveFile.getParentFile().mkdirs();
			FileUtils.copyFile(upload, saveFile);
			ActionContext.getContext().put("message", "upload succeed!");
			return "success";
		}
		return "error";
	}
}
