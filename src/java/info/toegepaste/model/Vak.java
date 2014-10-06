/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.model;

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
 * @author Tim
 */
@Entity
@Table(name = "vak")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vak.findAll", query = "SELECT v FROM Vak v"),
    @NamedQuery(name = "Vak.findByVakid", query = "SELECT v FROM Vak v WHERE v.vakid = :vakid"),
    @NamedQuery(name = "Vak.findByNaam", query = "SELECT v FROM Vak v WHERE v.naam = :naam")})
public class Vak implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vakid")
    private Collection<Test> testCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vakid")
    private Integer vakid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "naam")
    private String naam;

    public Vak() {
    }

    public Vak(Integer vakid) {
        this.vakid = vakid;
    }

    public Vak(Integer vakid, String naam) {
        this.vakid = vakid;
        this.naam = naam;
    }

    public Integer getVakid() {
        return vakid;
    }

    public void setVakid(Integer vakid) {
        this.vakid = vakid;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vakid != null ? vakid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vak)) {
            return false;
        }
        Vak other = (Vak) object;
        if ((this.vakid == null && other.vakid != null) || (this.vakid != null && !this.vakid.equals(other.vakid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.toegepaste.db.Vak[ vakid=" + vakid + " ]";
    }

    @XmlTransient
    public Collection<Test> getTestCollection() {
        return testCollection;
    }

    public void setTestCollection(Collection<Test> testCollection) {
        this.testCollection = testCollection;
    }
    
}
