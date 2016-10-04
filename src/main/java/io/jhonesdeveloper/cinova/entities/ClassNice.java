/*
 * ClassNice.java
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
 * @author Caique Jhones
 * @version 1
 */
public class ClassNice {
	
	/**
	 * Código da classificação Nice.
	 */
	private int code;
	/**
	 * Edição da classificação Nice.
	 */
	private int edition;
	/**
	 * Especificação de produtos e serviços da classificação de Nice(texto livre).
	 */
	private String specification;
	
	public ClassNice() {
	}

	public ClassNice(int code, int edition) {
		this.code = code;
		this.edition = edition;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("code", code)
				.append("edition", edition).append("specification", specification).toString();
	}

}
