/*
 * MProcess.java
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
package io.jhonesdeveloper.cinova.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Caique Jhones
 * @version 1
 */
public class MProcess {
	
	private static final String pattern = "dd/MM/yyyy";

	/**
	 * Número do processo administrativo de marcas (nove digitos numéricos).
	 */
	private int number;
	/**
	 * Data de depósito ou da apresentação da solicitação do Pedido de Registro
	 * de Marcas (dd/mm/yyyy).
	 */
	private LocalDate deposit;
	/**
	 * Data de concessão de registro de marca (dd/mm/yyyy).
	 */
	private LocalDate concession;
	/**
	 * Data fim de vigencia de registro de marca (dd/mm/yyyy).
	 */
	private LocalDate lifetime;
	/**
	 * Lista de despachos de uma publicação na RPI.
	 */
	private List<Dispatch> dispatches;
	/**
	 * Lista de titulares de um pedido de marcas (texto livre);
	 */
	private List<Holder> holders;
	/**
	 * Marca.
	 */
	private Brand brand;
	/**
	 * Lista de prioridade unionista;
	 */
	private UnionistPriority unionistPriority;
	/**
	 * Lista de classes vienna;
	 */
	private ClassesVienna classesVienna;
	/**
	 * Lista de classificação Nice.
	 */
	private ClassNice classNice;
	/**
	 * Antiga classificação nacional.
	 */
	private ClassNational classNational;
	/**
	 * Texto de apostilamento (texto livre).
	 */
	private String apostille;
	/**
	 * Nome do procurador do pedido, pessoa jurídica ou pessoa física (texto
	 * livre).
	 */
	private String attorney;
	/**
	 * Lista de processos que estão sobrestando o processo do despacho.
	 */
	private List<Sobrestador> sobrestadores;

	public MProcess() {
	}

	public MProcess(int number, String deposit, String concession, String lifetime) {
		this.number = number;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
		this.deposit = LocalDate.parse(deposit, dateFormatter);
		this.concession = LocalDate.parse(concession, dateFormatter);
		this.lifetime = LocalDate.parse(lifetime, dateFormatter);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalDate getDeposit() {
		return deposit;
	}

	public void setDeposit(LocalDate deposit) {
		this.deposit = deposit;
	}

	public LocalDate getConcession() {
		return concession;
	}

	public void setConcession(LocalDate concession) {
		this.concession = concession;
	}

	public LocalDate getLifetime() {
		return lifetime;
	}

	public void setLifetime(LocalDate lifetime) {
		this.lifetime = lifetime;
	}

	public List<Dispatch> getDispatches() {
		return dispatches;
	}

	public void setDispatches(List<Dispatch> dispatches) {
		this.dispatches = dispatches;
	}

	public List<Holder> getHolders() {
		return holders;
	}

	public void setHolders(List<Holder> holders) {
		this.holders = holders;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public UnionistPriority getUnionistPriority() {
		return unionistPriority;
	}

	public void setUnionistPriority(UnionistPriority unionistPriority) {
		this.unionistPriority = unionistPriority;
	}

	public ClassesVienna getClassesVienna() {
		return classesVienna;
	}

	public void setClassesVienna(ClassesVienna classesVienna) {
		this.classesVienna = classesVienna;
	}

	public ClassNice getClassNice() {
		return classNice;
	}

	public void setClassNice(ClassNice classNice) {
		this.classNice = classNice;
	}

	public ClassNational getClassNational() {
		return classNational;
	}

	public void setClassNational(ClassNational classNational) {
		this.classNational = classNational;
	}

	public String getApostille() {
		return apostille;
	}

	public void setApostille(String apostille) {
		this.apostille = apostille;
	}

	public String getAttorney() {
		return attorney;
	}

	public void setAttorney(String attorney) {
		this.attorney = attorney;
	}

	public List<Sobrestador> getSobrestadores() {
		return sobrestadores;
	}

	public void setSobrestadores(List<Sobrestador> sobrestadores) {
		this.sobrestadores = sobrestadores;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("number", number)
				.append("deposit", deposit).append("concession", concession).append("lifetime", lifetime)
				.append("dispatches", dispatches).append("holders", holders).append("brand", brand)
				.append("unionistPriority", unionistPriority).append("classesVienna", classesVienna)
				.append("classNice", classNice).append("classNational", classNational).append("apostille", apostille)
				.append("attorney", attorney).append("sobrestadores", sobrestadores).toString();
	}
}
