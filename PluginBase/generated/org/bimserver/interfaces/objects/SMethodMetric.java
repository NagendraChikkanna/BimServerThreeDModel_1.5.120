package org.bimserver.interfaces.objects;

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
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SMethodMetric implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.Long nrCalls;
	private java.util.Date lastCall;
	private java.lang.Long averageMs;
	private java.lang.Long shortestMs;
	private java.lang.Long longestMs;

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public int getRid() {
		return rid;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SMethodMetric.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("nrCalls")) {
			return getNrCalls();
		}
		if (sField.getName().equals("lastCall")) {
			return getLastCall();
		}
		if (sField.getName().equals("averageMs")) {
			return getAverageMs();
		}
		if (sField.getName().equals("shortestMs")) {
			return getShortestMs();
		}
		if (sField.getName().equals("longestMs")) {
			return getLongestMs();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("nrCalls")) {
			setNrCalls((Long)val);
			return;
		}
		if (sField.getName().equals("lastCall")) {
			setLastCall((Date)val);
			return;
		}
		if (sField.getName().equals("averageMs")) {
			setAverageMs((Long)val);
			return;
		}
		if (sField.getName().equals("shortestMs")) {
			setShortestMs((Long)val);
			return;
		}
		if (sField.getName().equals("longestMs")) {
			setLongestMs((Long)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		if (sField.getName().equals("rid")) {
			setRid((Integer)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.Long getNrCalls() {
		return nrCalls;
	}

	public void setNrCalls(java.lang.Long nrCalls) {
		this.nrCalls = nrCalls;
	}
	
	public java.util.Date getLastCall() {
		return lastCall;
	}

	public void setLastCall(java.util.Date lastCall) {
		this.lastCall = lastCall;
	}
	
	public java.lang.Long getAverageMs() {
		return averageMs;
	}

	public void setAverageMs(java.lang.Long averageMs) {
		this.averageMs = averageMs;
	}
	
	public java.lang.Long getShortestMs() {
		return shortestMs;
	}

	public void setShortestMs(java.lang.Long shortestMs) {
		this.shortestMs = shortestMs;
	}
	
	public java.lang.Long getLongestMs() {
		return longestMs;
	}

	public void setLongestMs(java.lang.Long longestMs) {
		this.longestMs = longestMs;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SMethodMetric other = (SMethodMetric) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}