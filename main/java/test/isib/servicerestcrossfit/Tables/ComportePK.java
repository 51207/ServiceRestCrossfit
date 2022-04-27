/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.isib.servicerestcrossfit.Tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author aliou
 */
@Embeddable
public class ComportePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cncompetition")
    private int cncompetition;
    @Basic(optional = false)
    @Column(name = "cnie")
    private int cnie;

    public ComportePK() {
    }

    public ComportePK(int cncompetition, int cnie) {
        this.cncompetition = cncompetition;
        this.cnie = cnie;
    }

    public int getCncompetition() {
        return cncompetition;
    }

    public void setCncompetition(int cncompetition) {
        this.cncompetition = cncompetition;
    }

    public int getCnie() {
        return cnie;
    }

    public void setCnie(int cnie) {
        this.cnie = cnie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cncompetition;
        hash += (int) cnie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComportePK)) {
            return false;
        }
        ComportePK other = (ComportePK) object;
        if (this.cncompetition != other.cncompetition) {
            return false;
        }
        if (this.cnie != other.cnie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.isib.servicerestcrossfit.Tables.ComportePK[ cncompetition=" + cncompetition + ", cnie=" + cnie + " ]";
    }
    
}
