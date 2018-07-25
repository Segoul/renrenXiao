package com.renren.renrenXiao.bean.vo.file;

/**
 * 文件上传出参
 * @author Segoul
 *
 */

public class FileUploadVo {

	private String mappingUrl;  //映射地址
	
	private String storeUrl;  //存储地址
	
	private String fileName;  //文件名称
	
	private String fileType;  //文件类型

	public String getMappingUrl() {
		return mappingUrl;
	}

	public void setMappingUrl(String mappingUrl) {
		this.mappingUrl = mappingUrl;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
