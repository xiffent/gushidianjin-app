package com.yijiaersan.webapp.utils.result;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * 基础类
 * @author lipan
 */
public class BaseEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 258829509295036690L;

	public BaseEntity() {
		super();
	}
	
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(obj, this);
	}
	
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
