/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.childcare.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author New User
 */
@Entity
@Table(name = "anchorgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anchorgroup.findAll", query = "SELECT a FROM Anchorgroup a")
    , @NamedQuery(name = "Anchorgroup.findByGid", query = "SELECT a FROM Anchorgroup a WHERE a.gid = :gid")
    , @NamedQuery(name = "Anchorgroup.findByGroupName", query = "SELECT a FROM Anchorgroup a WHERE a.groupName = :groupName")})
public class Anchorgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GID")
    private Integer gid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "GroupName")
    private String groupName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anchorgroup")
    private Collection<Anchor> anchorCollection;
    @JoinColumn(name = "UID", referencedColumnName = "UID")
    @ManyToOne(optional = false)
    private Account uid;

    public Anchorgroup() {
    }

    public Anchorgroup(Integer gid) {
        this.gid = gid;
    }

    public Anchorgroup(Integer gid, String groupName) {
        this.gid = gid;
        this.groupName = groupName;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlTransient
    public Collection<Anchor> getAnchorCollection() {
        return anchorCollection;
    }

    public void setAnchorCollection(Collection<Anchor> anchorCollection) {
        this.anchorCollection = anchorCollection;
    }

    public Account getUid() {
        return uid;
    }

    public void setUid(Account uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anchorgroup)) {
            return false;
        }
        Anchorgroup other = (Anchorgroup) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.childcare.entity.Anchorgroup[ gid=" + gid + " ]";
    }
    
}
