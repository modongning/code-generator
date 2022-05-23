package com.otoomo.codegenerator.core;


import com.otoomo.codegenerator.support.*;

public class CodeGenerater {
	public void generateCode(Class<?> pojoClass, GenerateConfig config, MysqlDBInfo mdb, String bPath, String fPath) {
		XGenCollection xc = new XGenCollection();
		new XGenCollectionParser1(pojoClass, xc).parse();
		if (config.genAll) {
			new MysqlDDLGenerater(xc, mdb).generate();
			new MybatisMapperGenerater(xc).generate();
			new ServiceGenerater(xc).generate();
			new com.otoomo.codegenerator.support.ControllerGenerater(xc).generate();
			new StaticGenerater(xc).generate();
		} else {
			if (config.genTable) {
				new MysqlDDLGenerater(xc, mdb).generate();
			}
			if (config.genMapper) {
				new MybatisMapperGenerater(xc).generate();
			}
			if (config.genService) {
				new ServiceGenerater(xc).generate();
			}
			if (config.genController) {
				new ControllerGenerater(xc).generate();
			}
			if (config.genStatic) {
				new StaticGenerater(xc).generate();
			}
			if (config.genBeanMd) {
				new BeanMdGenerater(xc).generate();
			}
		}
		
		// 复制文件
		FileToProjectMover ftpm = new FileToProjectMover(pojoClass, bPath, fPath);
		ftpm.copyFiles();
		
		System.out.println("代码生成完毕...");
	}
}
