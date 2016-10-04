/*
 * Magazine.java
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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Revista RPI.
 * 
 * @author Caique Jhones
 * @version 1
 */
public class Magazine {
	
	private static final String patternDate = "dd/MM/yyyy";
	
	/**
	 * Número da Revista da Propriedade Industrial Volume II – Diretoria de Marcas (quatro digitos numéricos);
	 */
	private int number;
	/**
	 * Data de publicação.
	 */
	private LocalDate date;
	/**
	 * Lista de processos.
	 */
	private List<MProcess> processes;
	
	public Magazine() {
	}

	public Magazine(int number, String date) {
		this.number = number;
		this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern(patternDate));
		processes = new ArrayList<>();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<MProcess> getProcesses() {
		return processes;
	}

	public void setProcesses(List<MProcess> processes) {
		this.processes = processes;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("number", number).append("date", date)
				.toString();
	}
}
