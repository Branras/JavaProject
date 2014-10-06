/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author brams
 */
@Entity
@Table(name = "klas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klas.findAll", query = "SELECT k FROM Klas k"),
    @NamedQuery(name = "Klas.findByKlasid", query = "SELECT k FROM Klas k WHERE k.klasid = :klasid"),
    @NamedQuery(name = "Klas.findByNaam", query = "SELECT k FROM Klas k WHERE k.naam = :naam")})
public class Klas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "klasid")
    private Integer klasid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "naam")
    private String naam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klasid")
    private Collection<Student> studentCollection;

    public Klas() {
    }

    public Klas(Integer klasid) {
        this.klasid = klasid;
    }

    public Klas(Integer klasid, String naam) {
        this.klasid = klasid;
        this.naam = naam;
    }

    public Integer getKlasid() {
        return klasid;
    }

    public void setKlasid(Integer klasid) {
        this.klasid = klasid;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klasid != null ? klasid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klas)) {
            return false;
        }
        Klas other = (Klas) object;
        if ((this.klasid == null && other.klasid != null) || (this.klasid != null && !this.klasid.equals(other.klasid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.toegepaste.db.Klas[ klasid=" + klasid + " ]";
    }
    
}
