package com.websystique.springsecurity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fav")

public class Fav implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userid")
	private int userid;
	
	@Id
	@Column(name="videoid")
	private int videoid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getVideoid() {
		return videoid;
	}

	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (!(obj instanceof Fav))
	        return false;
	    Fav other = (Fav) obj;
	    if (videoid != other.videoid)
	        return false;
	    if (userid !=other.userid)
	    	return false;
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

