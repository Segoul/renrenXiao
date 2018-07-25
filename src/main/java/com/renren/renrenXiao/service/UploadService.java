package com.renren.renrenXiao.service;

import org.springframework.web.multipart.MultipartFile;

import com.renren.renrenXiao.bean.vo.file.FileUploadVo;

/**
 * 文件上传Service
 * @author Segoul
 *
 */

public interface UploadService {

	/**
	 * 上传文件（包括图片）
	 * @param file
	 * @return
	 */
	FileUploadVo uploadFile(MultipartFile file);
	
	/**
	 * 上传二进制文件
	 * @param picByte
	 * @return
	 */
	FileUploadVo uploadBinaryFile(byte[] picByte);
}
