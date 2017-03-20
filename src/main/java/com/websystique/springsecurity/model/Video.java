package com.websystique.springsecurity.model;




import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "video")

public class Video implements Serializable  {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
@Column(name="videoid")
private int videoid;

@Column(name="nom")
private String nom;

@Column(name="durée")
private int durée;

@Column(name="datediffusion")
private String datediffusion;

@Column(name="issubtitled")
private boolean issubtitled;

@Column(name="videoname")
private String videoname;

@Column(name="arc")
private String arc;


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

public int getDurée() {
	return durée;
}

public void setDurée(int durée) {
	this.durée = durée;
}

public String getDatediffusion() {
	return datediffusion;
}

public void setDatediffusion(String datediffusion) {
	this.datediffusion = datediffusion;
}

public boolean isIssubtitled() {
	return issubtitled;
}

public void setIssubtitled(boolean issubtitled) {
	this.issubtitled = issubtitled;
}

public String getVideoname() {
	return videoname;
}

public void setVideoname(String videoname) {
	this.videoname = videoname;
}

public String getArc() {
	return arc;
}

public void setArc(String arc) {
	this.arc = arc;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (!(obj instanceof User))
        return false;
    Video other = (Video) obj;
    if (videoid != other.videoid)
        return false;
    return true;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + videoid;
    return result;

}
}
