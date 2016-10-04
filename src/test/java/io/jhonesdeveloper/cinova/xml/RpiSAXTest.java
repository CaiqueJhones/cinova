package io.jhonesdeveloper.cinova.xml;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.jhonesdeveloper.cinova.entities.Dispatch;
import io.jhonesdeveloper.cinova.entities.MProcess;
import io.jhonesdeveloper.cinova.entities.Magazine;

public class RpiSAXTest {
	
	static RpiSAX rpi;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {	
	         InputStream inputStream = RpiSAXTest.class.getResourceAsStream("magazine.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         rpi = new RpiSAX();
	         saxParser.parse(inputStream, rpi);   
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Magazine magazine = rpi.getMagazine();
		assertNotNull(magazine);
		List<MProcess> processes = magazine.getProcesses();
		assertNotNull(processes);
		MProcess mProcess = processes.get(0);
		assertNotNull(mProcess);
		List<Dispatch> dispatches = mProcess.getDispatches();
		assertNotNull(dispatches);
		System.out.println(dispatches);
		System.out.println();
		System.out.println(mProcess);
	}

}
