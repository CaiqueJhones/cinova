/*
 * Holder.java
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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Titular 
 * @author Caique Jhones
 * @version 1
 */
public class Holder {
	
	/**
	 * Nome do requerente (pessoa física) ou da razão social (pessoa jurídica) (texto livre).
	 */
	private String name;
	/**
	 * país de residência do requerente ou do titular da marca (dois digitos alfabeticos);
	 */
	private String country;
	/**
	 * Estado de residência, caso o requerente reside no Brasil (dos digitos alfabeticos);
	 */
	private String uf;
	
	public Holder() {
	}

	public Holder(String name, String country, String uf) {
		this.name = name;
		this.country = country;
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("name", name)
				.append("country", country).append("uf", uf).toString();
	}

}
