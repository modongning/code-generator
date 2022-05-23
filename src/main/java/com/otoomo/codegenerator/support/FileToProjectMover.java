package com.otoomo.codegenerator.support;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileToProjectMover {
	// 服务端工程绝对路径，到包目录
	private String backendProjectPath;
	// 前端功能绝对路径
	private String frontendProjectPath;
	// POJO类的包路径
	private Class<?> pojoClass;

	public FileToProjectMover() {

	}

	public FileToProjectMover(Class<?> pojoClass, String backendProjectPath, String frontendProjectPath) {
		this.pojoClass = pojoClass;
		this.backendProjectPath = backendProjectPath;
		this.frontendProjectPath = frontendProjectPath;
	}

	public void copyFiles() {
		// 服务端各种文件的目录明细
		String mapperPath = this.backendProjectPath + "/dao/";
		String servicePath = this.backendProjectPath + "/service/";
		String serviceImplPath = this.backendProjectPath + "/service/impl/";
		String controllerPath = this.backendProjectPath + "/controller/";
		// 根目录
		String baseFilePath = this.frontendProjectPath + "/";

		String className = pojoClass.getSimpleName();
		String handleName = GenerateUtil.getClassHandleName(className);
		// 已经生成的服务端文件名
		String mapperXmlFileSource = className + "Mapper.xml";
		String mapperJavaFileSource = className + "Mapper.java";
		String serviceFileSource = className + "Service.java";
		String serviceImplFileSource = className + "ServiceImpl.java";
		String controllerFileSource = className + "Controller.java";
		// 已经生成的前端文件名
		String listHtmlFileSource = className + ".vue";
		String listJSFileSource = className + "Api.js";
		//已生成的markdown文件
		String markdownFileSource = className + ".md";

		try {
			// 复制Mapper
			mkNotExistsDir(mapperPath);
			copyFilesToTargetDir(mapperXmlFileSource, mapperPath);
			copyFilesToTargetDir(mapperJavaFileSource, mapperPath);
			// 复制Service
			mkNotExistsDir(servicePath);
			mkNotExistsDir(serviceImplPath);
			copyFilesToTargetDir(serviceFileSource, servicePath);
			copyFilesToTargetDir(serviceImplFileSource, serviceImplPath);
			// 复制Controller
			mkNotExistsDir(controllerPath);
			copyFilesToTargetDir(controllerFileSource, controllerPath);
			// 复制静态文件
			mkNotExistsDir(baseFilePath);
			copyFilesToTargetDir(listHtmlFileSource, baseFilePath);
			copyFilesToTargetDir(listJSFileSource, baseFilePath);

			//复制markdown文件
			copyFilesToTargetDir(markdownFileSource, baseFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mkNotExistsDir(String path) throws IOException {
		if (!(new File(path).exists())) {
			FileUtils.forceMkdir(new File(path));
		}
	}

	private void copyFilesToTargetDir(String fileSoure, String to) throws IOException {
		String sourceDir = this.getClass().getClassLoader().getResource("").getPath();
		String toFile = to + fileSoure;
		fileSoure = sourceDir + fileSoure;
		if (new File(fileSoure).exists()) {
			if (!new File(toFile).exists()) {
				FileUtils.copyFileToDirectory(new File(fileSoure), new File(to), true);
				System.out.println("复制成功:" + toFile);
			} else {
				System.err.println("文件已存在:" + toFile);
			}
		}
	}
}
