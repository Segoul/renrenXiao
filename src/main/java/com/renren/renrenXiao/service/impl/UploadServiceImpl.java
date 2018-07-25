package com.renren.renrenXiao.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.renren.renrenXiao.bean.vo.file.FileUploadVo;
import com.renren.renrenXiao.common.exception.CommonException;
import com.renren.renrenXiao.config.properties.UploadProperties;
import com.renren.renrenXiao.service.UploadService;

/**
 * 文件上传ServiceImpl
 * @author Segoul
 *
 */

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadProperties uploadProperties;
	
	/**
	 * 24小时换一次
	 * @return
	 */
	private static String changeFilesDri(){
		return System.currentTimeMillis()/100000000+"/";
	}
	
	/**
	 * 上传文件（包括图片）
	 * @param file
	 * @return
	 */
	public FileUploadVo uploadFile(MultipartFile file){
		FileUploadVo returnInfo = new FileUploadVo();
		
		String changeFilesDri = changeFilesDri();
		String oldname = file.getOriginalFilename();  //源文件名称
		String ext = oldname.substring(oldname.lastIndexOf(".")+1);  //文件后缀名
		ext = ext.toLowerCase();
		returnInfo.setFileName(oldname);
		returnInfo.setFileType(ext);
		long timeMillis = System.currentTimeMillis();
		String storePath = uploadProperties.getDomainPath() + uploadProperties.getFilePath() + "/" + changeFilesDri;  //存储地址目录
		File saveFile = new File(storePath);
		if(!saveFile.exists()){  //创建目录
			saveFile.mkdirs();
		}
		
		String newName = oldname.substring(0,oldname.lastIndexOf(".")) + "-" + timeMillis;//文件名称，
		newName = newName.substring(newName.lastIndexOf("\\")+1);//ie上传会带盘符，需要去掉
		
		storePath = storePath + newName + "."+ext;  //存储地址
		returnInfo.setStoreUrl(storePath);  //存储地址
		
		try {
			file.transferTo(new File(storePath));  //存储当前文件
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new CommonException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new CommonException(e);
		}
		
		String mappingPath = uploadProperties.getDomain() + uploadProperties.getFilePath() + "/" + changeFilesDri + newName + "."+ext;
		returnInfo.setMappingUrl(mappingPath);  //映射地址
		
		return returnInfo;
	}
	
	/**
	 * 上传二进制文件
	 * @param picByte
	 * @return
	 */
	public FileUploadVo uploadBinaryFile(byte[] picByte){
		FileUploadVo returnInfo = new FileUploadVo();
		
		String changeFilesDri = changeFilesDri();
		String oldname = String.valueOf((int)((Math.random()*9+1)*1000000))+".jpg";  //源文件名称
		/*String ext = oldname.substring(oldname.lastIndexOf(".")+1);  //文件后缀名
		ext = ext.toLowerCase();*/
		String ext = "jpg";
		returnInfo.setFileName(oldname);
		returnInfo.setFileType(ext);
		long timeMillis = System.currentTimeMillis();
		String storePath = uploadProperties.getDomainPath() + uploadProperties.getFilePath() + "/" + changeFilesDri;  //存储地址目录
		File saveFile = new File(storePath);
		if(!saveFile.exists()){  //创建目录
			saveFile.mkdirs();
		}
		
		String newName = oldname.substring(0,oldname.lastIndexOf(".")) + "-" + timeMillis;
		storePath = storePath + newName + "."+ext;  //存储地址
		returnInfo.setStoreUrl(storePath);  //存储地址
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			//file.transferTo(new File(storePath));  //存储当前文件
			File endFile = new File(storePath);
	        fos = new FileOutputStream(endFile);
	        bos = new BufferedOutputStream(fos);
	        bos.write(picByte);
	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bos != null){
				try{
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if(fos != null){
				try{
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		String mappingPath = uploadProperties.getDomain() + uploadProperties.getFilePath() + "/" + changeFilesDri + newName + "."+ext;
		returnInfo.setMappingUrl(mappingPath);  //映射地址
		
		return returnInfo;
	}
	
	/**
	 * 获取可上传的文件类型
	 * @param allowFiles
	 * @return
	 */
	public static List getAllowFiles(String allowFiles){
		List fileTypes = new ArrayList();
		String types[] = allowFiles.split(",");
		for(int i = 0;i<types.length;i++){
			fileTypes.add(types[i]);
		}
		
		return fileTypes;
	}
}
