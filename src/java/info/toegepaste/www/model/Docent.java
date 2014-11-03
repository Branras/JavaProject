/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tim
 */
@Entity
        @Table(name = "docent")
        @XmlRootElement
        @NamedQueries({
            @NamedQuery(name = "Docent.findAll", query = "SELECT d FROM Docent d"),
            @NamedQuery(name = "Docent.findById", query = "SELECT d FROM Docent d WHERE d.id = :id"),
            @NamedQuery(name = "Docent.findByNaam", query = "SELECT d FROM Docent d WHERE d.naam = :naam"),
            @NamedQuery(name = "Docent.findByFamilienaam", query = "SELECT d FROM Docent d WHERE d.familienaam = :familienaam"),
            @NamedQuery(name = "Docent.findByLogin", query = "SELECT d FROM Docent d WHERE d.login = :login"),
            @NamedQuery(name = "Docent.findByPass", query = "SELECT d FROM Docent d WHERE d.pass = :pass"),
            @NamedQuery(name = "Docent.login", query = "SELECT d FROM Docent d WHERE d.pass = :pass AND d.login = :login") })

public class Docent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Naam")
    private String naam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Familienaam")
    private String familienaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Pass")
    private String pass;

    public Docent() {
    }

    public Docent(Integer id) {
        this.id = id;
    }

    public Docent(Integer id, String naam, String familienaam, String login, String pass) {
        this.id = id;
        this.naam = naam;
        this.familienaam = familienaam;
        this.login = login;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docent)) {
            return false;
        }
        Docent other = (Docent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.toegepaste.model.Docent[ id=" + id + " ]";
    }

}
