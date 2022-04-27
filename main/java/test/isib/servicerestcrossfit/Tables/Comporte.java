/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.isib.servicerestcrossfit.Tables;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aliou
 */
@Entity
@Table(name = "comporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comporte.findAll", query = "SELECT c FROM Comporte c"),
    @NamedQuery(name = "Comporte.findByCncompetition", query = "SELECT c FROM Comporte c WHERE c.comportePK.cncompetition = :cncompetition"),
    @NamedQuery(name = "Comporte.findByCnie", query = "SELECT c FROM Comporte c WHERE c.comportePK.cnie = :cnie")})
public class Comporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComportePK comportePK;
    @JoinColumns({
        @JoinColumn(name = "cncompetition", referencedColumnName = "NCompetition", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Competition competition;
    @JoinColumns({
        @JoinColumn(name = "cnie", referencedColumnName = "NIE", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Epreuve epreuve;

    public Comporte() {
    }

    public Comporte(ComportePK comportePK) {
        this.comportePK = comportePK;
    }

    public Comporte(int cncompetition, int cnie) {
        this.comportePK = new ComportePK(cncompetition, cnie);
    }

    public ComportePK getComportePK() {
        return comportePK;
    }

    public void setComportePK(ComportePK comportePK) {
        this.comportePK = comportePK;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comportePK != null ? comportePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comporte)) {
            return false;
        }
        Comporte other = (Comporte) object;
        if ((this.comportePK == null && other.comportePK != null) || (this.comportePK != null && !this.comportePK.equals(other.comportePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.isib.servicerestcrossfit.Tables.Comporte[ comportePK=" + comportePK + " ]";
    }
    
}
