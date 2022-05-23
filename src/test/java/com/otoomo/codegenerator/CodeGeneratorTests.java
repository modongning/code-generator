package com.otoomo.codegenerator;

import com.otoomo.codegenerator.core.CodeGenerater;
import com.otoomo.codegenerator.core.GenerateConfig;
import com.otoomo.codegenerator.core.MysqlDBInfo;

class CodeGeneratorTests {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String dbHost = "127.0.0.1";
		String dbPort = "";
		String dbName = "test";
		String userName = "root";
		String pwd = "123456";

		GenerateConfig gconf = new GenerateConfig();
//		gconf.genController();
		gconf.genService();
		gconf.genMapper();
//		gconf.genStatic();
//		gconf.genBeanMd();
//		gconf.genTable();

		MysqlDBInfo db = new MysqlDBInfo();
		db.setDriver(driver);
		db.setDbHost(dbHost);
		db.setDbName(dbName);
		db.setDbPort(dbPort);
		db.setUserName(userName);
		db.setPassword(pwd);

		String path = "/Users/modongning/generater/course";

		//开始生成代码
		CodeGenerater cg = new CodeGenerater();
//		cg.generateCode(PEcmsNews.class, gconf, db, path, path);
	}
}
