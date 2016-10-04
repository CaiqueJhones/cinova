/*
 * UnionistPriority.java
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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Caique Jhones
 * @version 1
 */
public class UnionistPriority {
	
	private static final String pattern = "dd/MM/yyyy";
	
	/**
	 * Data da prioridade unionista (dd/mm/yyyy).
	 */
	private LocalDate date;
	/**
	 * Número da prioridade unionista.
	 */
	private String number;
	/**
	 * Pais da prioridade unionista (dois digitos alfabeticos).
	 */
	private String country;

	public UnionistPriority() {
	}

	public UnionistPriority(String date, String number, String country) {
		this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
		this.number = number;
		this.country = country;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("date", date).append("number", number)
				.append("country", country).toString();
	}

}
