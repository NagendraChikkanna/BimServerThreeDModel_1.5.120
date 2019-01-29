package org.bimserver;

import com.fasterxml.jackson.databind.node.ObjectNode;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

public class TemporaryGeometryData {

	private long oid;
	private int nrPrimitives;
	private long size;
	private double[] mibu;
	private double[] mabu;
	private int[] indices;
	private float[] vertices;
	private ObjectNode additionalData;
	private boolean hasTransparancy;
	private int nrVertices;
	private int nrColors;

	public TemporaryGeometryData(long oid, ObjectNode additionalData, int nrPrimitives, long size, double[] mibu, double[] mabu, int[] indices, float[] vertices, boolean hasTransparancy, int nrColors) {
		this.oid = oid;
		this.additionalData = additionalData;
		this.nrPrimitives = nrPrimitives;
		this.size = size;
		this.mibu = mibu;
		this.mabu = mabu;
		this.indices = indices;
		this.vertices = vertices;
		this.hasTransparancy = hasTransparancy;
		this.nrVertices = vertices.length;
		this.nrColors = nrColors;
	}
	
	public int[] getIndices() {
		return indices;
	}
	
	public float[] getVertices() {
		return vertices;
	}
	
	public double[] getMibu() {
		return mibu;
	}

	public double[] getMabu() {
		return mabu;
	}
	
	public long getSize() {
		return size;
	}
	
	public ObjectNode getAdditionalData() {
		return additionalData;
	}
	
	public int getNrPrimitives() {
		return nrPrimitives;
	}
	
	public long getOid() {
		return oid;
	}

	public boolean hasTransparancy() {
		return hasTransparancy;
	}

	public int getNrVertices() {
		return nrVertices;
	}

	public int getNrColors() {
		return nrColors;
	}
}
