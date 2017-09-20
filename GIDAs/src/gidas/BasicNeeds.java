/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gidas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author ITCDD
 */
@Entity
@Table(name = "basic_needs", catalog = "gida", schema = "")
@NamedQueries({
    @NamedQuery(name = "BasicNeeds.findAll", query = "SELECT b FROM BasicNeeds b")
    , @NamedQuery(name = "BasicNeeds.findById", query = "SELECT b FROM BasicNeeds b WHERE b.id = :id")
    , @NamedQuery(name = "BasicNeeds.findByType", query = "SELECT b FROM BasicNeeds b WHERE b.type = :type")
    , @NamedQuery(name = "BasicNeeds.findByCreatedAt", query = "SELECT b FROM BasicNeeds b WHERE b.createdAt = :createdAt")
    , @NamedQuery(name = "BasicNeeds.findByUpdatedAt", query = "SELECT b FROM BasicNeeds b WHERE b.updatedAt = :updatedAt")})
public class BasicNeeds implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "need")
    private String need;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public BasicNeeds() {
    }

    public BasicNeeds(Integer id) {
        this.id = id;
    }

    public BasicNeeds(Integer id, String need, String type, Date createdAt, Date updatedAt) {
        this.id = id;
        this.need = need;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        String oldNeed = this.need;
        this.need = need;
        changeSupport.firePropertyChange("need", oldNeed, need);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        Date oldCreatedAt = this.createdAt;
        this.createdAt = createdAt;
        changeSupport.firePropertyChange("createdAt", oldCreatedAt, createdAt);
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        Date oldUpdatedAt = this.updatedAt;
        this.updatedAt = updatedAt;
        changeSupport.firePropertyChange("updatedAt", oldUpdatedAt, updatedAt);
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
        if (!(object instanceof BasicNeeds)) {
            return false;
        }
        BasicNeeds other = (BasicNeeds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gidas.BasicNeeds[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
