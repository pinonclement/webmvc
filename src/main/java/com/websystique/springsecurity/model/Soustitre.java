package com.websystique.springsecurity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "soustitre")

public class Soustitre implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
@Column(name="sstitreid")
private int sstitreid;

@Id
@Column(name="videoid")
private int videoid;

@Column(name="nom")
private String nom ;

@Column(name="score")
private int score;





public int getSstitreid() {
	return sstitreid;
}

public void setSstitreid(int sstitreid) {
	this.sstitreid = sstitreid;
}

public int getVideoid() {
	return videoid;
}

public void setVideoid(int videoid) {
	this.videoid = videoid;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public int getScore() {
	return score;
}

public void setPScore(int score) {
	this.score= score;
}


public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (!(obj instanceof Soustitre))
        return false;
    Soustitre other = (Soustitre) obj;
    if (videoid != other.videoid)
        return false;
    if(sstitreid != other.sstitreid)
    	return false;
    return true;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + sstitreid;
    return result;

}

}