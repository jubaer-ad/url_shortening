package com.spring_ui.springuiapp.urlshortner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Short {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @JsonIgnore
    private int urlId;

    @NaturalId
    @Column(unique = true, nullable = false)
    private String shortURL;

    @Column(nullable = false)
    private String mainURL;

    public int getUrlId() {
         return urlId;
    }

    public String getShortURL() {
        return shortURL;
    }

    public String getMainURL() {
        return mainURL;
    }

    public Short(final String shortURL, final String mainURL) {
        this.shortURL = shortURL;
        this.mainURL = mainURL;
    }

    public Short() {
    }

    @Override
    public String toString() {
        return "Short [mainURL=" + mainURL + ", shortURL=" + shortURL + ", urlId=" + urlId + "]";
    }

    
}
