/*
 * RpiSAX.java
 *
 * Copyright 2016 Caique Jhones
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jhonesdeveloper.cinova.xml;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import io.jhonesdeveloper.cinova.entities.Brand;
import io.jhonesdeveloper.cinova.entities.ClassNational;
import io.jhonesdeveloper.cinova.entities.ClassNice;
import io.jhonesdeveloper.cinova.entities.ClassesVienna;
import io.jhonesdeveloper.cinova.entities.Dispatch;
import io.jhonesdeveloper.cinova.entities.Holder;
import io.jhonesdeveloper.cinova.entities.MProcess;
import io.jhonesdeveloper.cinova.entities.Magazine;
import io.jhonesdeveloper.cinova.entities.Sobrestador;
import io.jhonesdeveloper.cinova.entities.UnionistPriority;

/**
 * Classe responsável por ler as informações do arquivo XML e converter para
 * objetos Java.
 * 
 * @author Caique Jhones
 * @version 1
 */
public class RpiSAX extends DefaultHandler {

	private static final Logger log = LoggerFactory.getLogger(RpiSAX.class);

	private String lastTag = "";
	private String currentTag = "";
	
	private Magazine magazine;
	private MProcess process;
	private Dispatch dispatch;
	private ClassesVienna classesVienna;
	private ClassNice classNice;
	private ClassNational classNational;

	public RpiSAX() {
		super();
	}

	@Override
	public void startDocument() throws SAXException {
		log.info("Início da leitura do documento.");
	}

	@Override
	public void endDocument() throws SAXException {
		log.info("Fim da leitura do documento.");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		lastTag = currentTag;
		currentTag = qName;
		
		if (qName.equalsIgnoreCase("revista")) {
			String numberString = attributes.getValue("numero");
			String date = attributes.getValue("data");
			if (numberString == null || date == null)
				throw new SAXException("Número ou data não existem na criação da revista");
			magazine = new Magazine(Integer.parseInt(numberString), date);
		} 
		
		else if (qName.equalsIgnoreCase("processo")) {
			String number = attributes.getValue("numero");
			String dd = attributes.getValue("data-deposito");
			String dc = attributes.getValue("data-concessao");
			String dv = attributes.getValue("data-vigencia");
			process = new MProcess(Integer.parseInt(number), dd, dc, dv);
			magazine.getProcesses().add(process);
		} 
		
		else if (qName.equalsIgnoreCase("despachos") && process != null) {
			List<Dispatch> dispatches = new ArrayList<>();
			process.setDispatches(dispatches);
		} 
		
		else if (qName.equalsIgnoreCase("despacho") && process != null) {
			String cod = attributes.getValue("codigo");
			String name = attributes.getValue("nome");
			dispatch = new Dispatch(cod, name);
			process.getDispatches().add(dispatch);
		} 
		
		else if (qName.equalsIgnoreCase("titulares") && process != null) {
			process.setHolders(new ArrayList<>());
		} 
		
		else if (qName.equalsIgnoreCase("titular") && process != null) {
			String nrz = attributes.getValue("nome-razao-social");
			String p = attributes.getValue("pais");
			String uf = attributes.getValue("uf");
			process.getHolders().add(new Holder(nrz, p, uf));
		} 
		
		else if (qName.equalsIgnoreCase("marca") && process != null) {
			String ap = attributes.getValue("apresentacao");
			String n = attributes.getValue("natureza");
			Brand brand = new Brand(ap, n);
			process.setBrand(brand);
		} 
		
		else if (qName.equalsIgnoreCase("prioridade") && process != null) {
			String d = attributes.getValue("data");
			String n = attributes.getValue("numero");
			String p = attributes.getValue("pais");
			UnionistPriority u = new UnionistPriority(d, n, p);
			process.setUnionistPriority(u);
		} 
		
		else if (qName.equalsIgnoreCase("classes-vienna") && process != null) {
			String e = attributes.getValue("edicao");
			classesVienna = new ClassesVienna(Integer.parseInt(e));
			process.setClassesVienna(classesVienna);
		} 
		
		else if (qName.equalsIgnoreCase("classe-vienna") && classesVienna != null) {
			String c = attributes.getValue("codigo");
			classesVienna.getCodes().add(c);
		} 
		
		else if (qName.equalsIgnoreCase("classe-nice") && process != null) {
			String c = attributes.getValue("codigo");
			String e = attributes.getValue("edicao");
			classNice = new ClassNice(Integer.parseInt(c), Integer.parseInt(e));
			process.setClassNice(classNice);
		} 
		
		else if (qName.equalsIgnoreCase("classe-nacional") && process != null) {
			String c = attributes.getValue("codigo");
			classNational = new ClassNational(Integer.parseInt(c));
			process.setClassNational(classNational);
		} 
		
		else if (qName.equalsIgnoreCase("sub-classe-nacional") && classNational != null) {
			String c = attributes.getValue("codigo");
			classNational.getSubclasses().add(c);
		} 
		
		else if (qName.equalsIgnoreCase("sobrestadores") && process != null) {
			process.setSobrestadores(new ArrayList<>());
		} 
		
		else if (qName.equalsIgnoreCase("sobrestador") && process != null) {
			String p = attributes.getValue("processo");
			String m = attributes.getValue("marca");
			Sobrestador sobrestador = new Sobrestador(Integer.parseInt(p), m);
			process.getSobrestadores().add(sobrestador);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		lastTag = qName;
		currentTag = "";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentTag.isEmpty()) return;
		
		String text = new String(ch, start, length);
		log.info("Texto na Tag["+currentTag+"]["+lastTag+"] = "+text);
		
		if (currentTag.equalsIgnoreCase("texto-complementar") && dispatch != null) {
			dispatch.setText(text);
		} else if (currentTag.equalsIgnoreCase("nome")) {
			process.getBrand().setName(text);
		} else if (currentTag.equalsIgnoreCase("traducao")) {
			process.getBrand().setTradution(text);
		} else if (currentTag.equalsIgnoreCase("especificacao") && lastTag.equalsIgnoreCase("classe-nice")) {
			classNice.setSpecification(text);
		} else if (currentTag.equalsIgnoreCase("especificacao") && lastTag.equalsIgnoreCase("classe-nacional")) {
			classNational.setSpecification(text);
		} else if (currentTag.equalsIgnoreCase("apostila")) {
			process.setApostille(text);
		} else if (currentTag.equalsIgnoreCase("procurador")) {
			process.setAttorney(text);
		}
	}
	
	public Magazine getMagazine() {
		return magazine;
	}
}
