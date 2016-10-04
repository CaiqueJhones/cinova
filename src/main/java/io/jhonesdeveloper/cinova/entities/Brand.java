/*
 * Brand.java
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
 * Marca NPI
 * 
 * @author Caique Jhones
 * @version 1
 */
public class Brand {

	/**
	 * Apresentação da marca.
	 */
	private String apresentation;
	/**
	 * Natureza da marca.
	 */
	private String nature;
	/**
	 * Nome da marca.
	 */
	private String name;
	/**
	 * Tradução da marca.
	 */
	private String tradution;

	public Brand() {
	}

	public Brand(String apresentation, String nature) {
		this.apresentation = apresentation;
		this.nature = nature;
	}

	public String getApresentation() {
		return apresentation;
	}

	public void setApresentation(String apresentation) {
		this.apresentation = apresentation;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTradution() {
		return tradution;
	}

	public void setTradution(String tradution) {
		this.tradution = tradution;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("apresentation", apresentation)
				.append("nature", nature).append("name", name).append("tradution", tradution).toString();
	}

}
