/*
 * Sobrestador.java
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
public class Sobrestador {
	
	/**
	 * Identificação do processo sobrestador (nove digitos numéricos);
	 */
	private int process;
	/**
	 * Nome da marca do processo sobrestador (texto livre);
	 */
	private String brand;
	
	public Sobrestador() {
	}

	public Sobrestador(int process, String brand) {
		this.process = process;
		this.brand = brand;
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		this.process = process;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("process", process)
				.append("brand", brand).toString();
	}
}
