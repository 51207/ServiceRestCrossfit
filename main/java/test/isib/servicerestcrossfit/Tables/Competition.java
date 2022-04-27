/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.isib.servicerestcrossfit.Tables;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aliou
 */
@Entity
@Table(name = "competition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competition.findAll", query = "SELECT c FROM Competition c"),
    @NamedQuery(name = "Competition.findByNCompetition", query = "SELECT c FROM Competition c WHERE c.nCompetition = :nCompetition"),
    @NamedQuery(name = "Competition.findByNomOrganisateur", query = "SELECT c FROM Competition c WHERE c.nomOrganisateur = :nomOrganisateur"),
    @NamedQuery(name = "Competition.findByPrenomOrganisateur", query = "SELECT c FROM Competition c WHERE c.prenomOrganisateur = :prenomOrganisateur"),
    @NamedQuery(name = "Competition.findByNomcompetition", query = "SELECT c FROM Competition c WHERE c.nomcompetition = :nomcompetition"),
    @NamedQuery(name = "Competition.findByUser", query = "SELECT c FROM Competition c WHERE c.user = :user"),
    @NamedQuery(name = "Competition.findByPassword", query = "SELECT c FROM Competition c WHERE c.password = :password")})
public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NCompetition")
    private Integer nCompetition;
    @Basic(optional = false)
    @Column(name = "Nom_Organisateur")
    private String nomOrganisateur;
    @Basic(optional = false)
    @Column(name = "Prenom_Organisateur")
    private String prenomOrganisateur;
    @Basic(optional = false)
    @Column(name = "Nom_competition")
    private String nomcompetition;
    @Basic(optional = false)
    @Column(name = "user_")
    private String user;
    @Basic(optional = false)
    @Column(name = "password_")
    private String password;
    @JoinTable(name = "inscrit", joinColumns = {
        @JoinColumn(name = "I_NCompetition", referencedColumnName = "NCompetition")}, inverseJoinColumns = {
        @JoinColumn(name = "I_NIC", referencedColumnName = "NIC")})
    @ManyToMany
    private Collection<Clients> clientsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "competition")
    private Comporte comporte;
    @OneToMany(mappedBy = "competition")
    private Collection<Sites> sitesCollection;

    public Competition() {
    }

    public Competition(Integer nCompetition) {
        this.nCompetition = nCompetition;
    }

    public Competition(Integer nCompetition, String nomOrganisateur, String prenomOrganisateur, String nomcompetition, String user, String password) {
        this.nCompetition = nCompetition;
        this.nomOrganisateur = nomOrganisateur;
        this.prenomOrganisateur = prenomOrganisateur;
        this.nomcompetition = nomcompetition;
        this.user = user;
        this.password = password;
    }

    public Integer getNCompetition() {
        return nCompetition;
    }

    public void setNCompetition(Integer nCompetition) {
        this.nCompetition = nCompetition;
    }

    public String getNomOrganisateur() {
        return nomOrganisateur;
    }

    public void setNomOrganisateur(String nomOrganisateur) {
        this.nomOrganisateur = nomOrganisateur;
    }

    public String getPrenomOrganisateur() {
        return prenomOrganisateur;
    }

    public void setPrenomOrganisateur(String prenomOrganisateur) {
        this.prenomOrganisateur = prenomOrganisateur;
    }

    public String getNomcompetition() {
        return nomcompetition;
    }

    public void setNomcompetition(String nomcompetition) {
        this.nomcompetition = nomcompetition;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Clients> getClientsCollection() {
        return clientsCollection;
    }

    public void setClientsCollection(Collection<Clients> clientsCollection) {
        this.clientsCollection = clientsCollection;
    }

    public Comporte getComporte() {
        return comporte;
    }

    public void setComporte(Comporte comporte) {
        this.comporte = comporte;
    }

    @XmlTransient
    public Collection<Sites> getSitesCollection() {
        return sitesCollection;
    }

    public void setSitesCollection(Collection<Sites> sitesCollection) {
        this.sitesCollection = sitesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nCompetition != null ? nCompetition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competition)) {
            return false;
        }
        Competition other = (Competition) object;
        if ((this.nCompetition == null && other.nCompetition != null) || (this.nCompetition != null && !this.nCompetition.equals(other.nCompetition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.isib.servicerestcrossfit.Tables.Competition[ nCompetition=" + nCompetition + " ]";
    }
    
}
