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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tim
 */
@Entity
@Table(name = "score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Score.findAll", query = "SELECT s FROM Score s"),
    @NamedQuery(name = "Score.findScoresByTest", query = "SELECT s FROM Score s WHERE s.testid = :testid"),
    @NamedQuery(name = "Score.findScoresByKlas", query = "SELECT s FROM Score s WHERE s.studentid.klasid.klasid = :klasid"),
    @NamedQuery(name = "Score.findScoresByVak", query = "SELECT s FROM Score s WHERE s.testid.vakid = :vakid"),
    @NamedQuery(name = "Score.findScoresByStudent", query = "SELECT s FROM Score s WHERE s.studentid = :studentid"),
    @NamedQuery(name = "Score.findByScoreid", query = "SELECT s FROM Score s WHERE s.scoreid = :scoreid"),
    @NamedQuery(name = "Score.findByScore", query = "SELECT s FROM Score s WHERE s.score = :score"),
    @NamedQuery(name = "Score.findByMaxaantalpunten", query = "SELECT s FROM Score s WHERE s.maxaantalpunten = :maxaantalpunten")})
    
public class Score implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scoreid")
    private Integer scoreid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private int score;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxaantalpunten")
    private int maxaantalpunten;
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    @ManyToOne(optional = false)
    private Student studentid;
    @JoinColumn(name = "testid", referencedColumnName = "testid")
    @ManyToOne(optional = false)
    private Test testid;
    
    @Transient
    boolean editable = false;
    
    public boolean isEditable(){
        return editable;
    }
    
    public void setEditable(boolean editable){
        this.editable = editable;
    }
    
    public String editAction(Score score){
        score.setEditable(true);
        return null;
    }
    
    
    public Score() {
    }

    public Score(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public Score(Integer scoreid, int score, int maxaantalpunten) {
        this.scoreid = scoreid;
        this.score = score;
        this.maxaantalpunten = maxaantalpunten;
    }

    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxaantalpunten() {
        return maxaantalpunten;
    }

    public void setMaxaantalpunten(int maxaantalpunten) {
        this.maxaantalpunten = maxaantalpunten;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Test getTestid() {
        return testid;
    }

    public void setTestid(Test testid) {
        this.testid = testid;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scoreid != null ? scoreid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Score)) {
            return false;
        }
        Score other = (Score) object;
        if ((this.scoreid == null && other.scoreid != null) || (this.scoreid != null && !this.scoreid.equals(other.scoreid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.toegepaste.model.Score[ scoreid=" + scoreid + " ]";
    }
    
}
