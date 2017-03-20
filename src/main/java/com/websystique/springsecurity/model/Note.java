package com.websystique.springsecurity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="note")
public class Note implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userid")
	private int userid;
	
	@Id
	@Column(name="sstritreid")
	private int sstritreid;
	
	@Column(name="note")
	private int note;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getSstritreid() {
		return sstritreid;
	}

	public void setSstritreid(int sstritreid) {
		this.sstritreid = sstritreid;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof Note))
	            return false;
	        Note other = (Note) obj;
	        if (userid != other.userid)
	            return false;
	        else
	        	if (sstritreid !=other.sstritreid) 
	        		return false;
	        	else
	        {
	            if (other.note != note)
	                return false;
	        }
	        return true;
	    }
	 
	  @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + userid;
	        return result;
	    
}
}