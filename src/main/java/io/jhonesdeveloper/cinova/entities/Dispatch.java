/*
 * Dispatch.java
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
 * Despachos de Publicação de Pedido e Registro.
 * 
 * @author Caique Jhones
 * @version 1
 */
public class Dispatch {
	
	/**
	 * Código interno representativo da publicação do despacho publicado na RPI (“IPAS” + três digitos numericos).
	 */
	private String code;
	/**
	 * Nome do dispacho.
	 */
	private String name;
	/**
	 * Texto complementar do despacho publicado de pedido na RPI (texto livre).
	 */
	private String text;
	
	public Dispatch() {
	}

	public Dispatch(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("code", code).append("name", name)
				.append("text", text).toString();
	}
	
}
