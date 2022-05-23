package com.otoomo.codegenerator.support;

import com.otoomo.codegenerator.core.IGenerater;
import com.otoomo.codegenerator.core.XGenCollection;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

/**
 * 实体字段markdown说明文件
 */
public class BeanMdGenerater implements IGenerater {
	private XGenCollection collection;
	private String className; // 类名
	private String handleName;// 参数名
	private String targetFilePath;
	private static final String TEMPLATE_PATH = "template/TBeanMD.vm";

	public BeanMdGenerater(XGenCollection collection) {
		this.collection = collection;
		this.className = (String) collection.getClassInfo().get("className");
		this.handleName = (String) collection.getClassInfo().get("handleName");
		this.targetFilePath = this.getClass().getClassLoader().getResource("").getPath() + this.className + ".md";
	}

	@Override
	public void generate() {
		Properties prop = new Properties();
		String key = "file.resource.loader.class";
		String value = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";
		prop.put(key, value);
		VelocityEngine ve = new VelocityEngine();
		ve.init(prop);
		VelocityContext context = new VelocityContext();
		context.put("collection", this.collection);

		generate(ve, context);
	}

	private void generate(VelocityEngine ve, VelocityContext context) {
		Template t = ve.getTemplate(TEMPLATE_PATH, "UTF-8");
		Writer writer;
		try {
			writer = new FileWriterWithEncoding(this.targetFilePath, "UTF-8");
			t.merge(context, writer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
