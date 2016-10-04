/*
 * ClassNational.java
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

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Caique Jhones
 * @version 1
 */
public class ClassNational {
	
	/**
	 * Código da antiga classificação nacional (dois digitos numéricos).
	 */
	private int code;
	/**
	 * Especificação da antiga classe nacional (texto livre).
	 */
	private String specification;
	/**
	 * lista da antiga subclasse nacional, código da antiga subclasse nacional;
	 */
	private List<String> subclasses;
	
	public ClassNational() {
	}

	public ClassNational(int code) {
		this.code = code;
		subclasses = new ArrayList<>();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public List<String> getSubclasses() {
		return subclasses;
	}

	public void setSubclasses(List<String> subclasses) {
		this.subclasses = subclasses;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("code", code)
				.append("specification", specification).append("subclasses", subclasses).toString();
	}
}
