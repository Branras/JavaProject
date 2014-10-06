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
 * @author brams
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid"),
    @NamedQuery(name = "Student.findByFamilienaam", query = "SELECT s FROM Student s WHERE s.familienaam = :familienaam"),
    @NamedQuery(name = "Student.findByVoornaam", query = "SELECT s FROM Student s WHERE s.voornaam = :voornaam"),
    @NamedQuery(name = "Student.findByNummer", query = "SELECT s FROM Student s WHERE s.nummer = :nummer"),
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")})
public class Student implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentid")
    private Collection<Score> scoreCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentid")
    private Integer studentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "familienaam")
    private String familienaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "voornaam")
    private String voornaam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nummer")
    private int nummer;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "klasid", referencedColumnName = "klasid")
    @ManyToOne(optional = false)
    private Klas klasid;

    public Student() {
    }

    public Student(Integer studentid) {
        this.studentid = studentid;
    }

    public Student(Integer studentid, String familienaam, String voornaam, int nummer, String email) {
        this.studentid = studentid;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.nummer = nummer;
        this.email = email;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Klas getKlasid() {
        return klasid;
    }

    public void setKlasid(Klas klasid) {
        this.klasid = klasid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.toegepaste.db.Student[ studentid=" + studentid + " ]";
    }

    @XmlTransient
    public Collection<Score> getScoreCollection() {
        return scoreCollection;
    }

    public void setScoreCollection(Collection<Score> scoreCollection) {
        this.scoreCollection = scoreCollection;
    }
    
}
