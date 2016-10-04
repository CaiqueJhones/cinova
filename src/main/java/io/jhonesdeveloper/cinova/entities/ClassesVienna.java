/*
 * ClassesVienna.java
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
public class ClassesVienna {

	/**
	 * Edição do classificador de Vienna (dois dígitos numéricos).
	 */
	private int edition;
	/**
	 * Descrição da classe vienna (máximo oito digitos numericos).
	 */
	private List<String> codes;

	public ClassesVienna() {
	}

	public ClassesVienna(int edition) {
		this.edition = edition;
		codes = new ArrayList<>();
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public List<String> getCodes() {
		return codes;
	}

	public void setCodes(List<String> codes) {
		this.codes = codes;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("edition", edition)
				.append("codes", codes).toString();
	}
}
