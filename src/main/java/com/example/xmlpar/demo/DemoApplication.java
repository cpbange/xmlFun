package com.example.xmlpar.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Running Spring Boot Application");

		try {
			String xml = null;
			File file = new File("simple_bean.xml");

			XmlMapper xmlMapper = new XmlMapper();
			xml = inputStreamToString(new FileInputStream(file));

			User value = xmlMapper.readValue(xml, User.class);


			//Make modifications to data
			value.setFirstName(value.getFirstName().toUpperCase());

			if(value.getGender().equalsIgnoreCase("male")){
				value.setGender("MALE");
			} else if(value.getGender().equalsIgnoreCase("female")){
				value.setGender("FEMALE");
			}

			value.setAge(value.getAge()+5);

			//File file = new File("simple_bean.xml");
			xmlMapper.writeValue(new File("simple_bean.xml"), value);
			System.out.println(xmlMapper.writeValueAsString(value));

			/*
			XPath solution
				FileInputStream fileIS = new FileInputStream(new File("simple_bean.xml"));
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = builderFactory.newDocumentBuilder();
				Document xmlDocument = builder.parse(fileIS);
				XPath xPath = XPathFactory.newInstance().newXPath();
				String expression = "/Users/User";
				nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			 */

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}


	}
	public String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

}
