package com.spring_ui.springuiapp.urlshortner;

public class ShortCreateRequest {
    private String shortURL;
    private String mainURL;
    public ShortCreateRequest(final String shortURL, final String mainURL) {
        this.shortURL = shortURL;
        this.mainURL = mainURL;
    }
    public String getShortURL() {
        return shortURL;
    }
    public String getMainURL() {
        return mainURL;
    }
    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }
    @Override
    public String toString() {
        return "ShortCreateRequest [mainURL=" + mainURL + ", shortURL=" + shortURL + "]";
    }

    
    
}
