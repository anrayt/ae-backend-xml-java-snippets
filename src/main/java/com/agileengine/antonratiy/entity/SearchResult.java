package com.agileengine.antonratiy.entity;

import java.util.ArrayList;
import java.util.List;

public class SearchResult<K> {
    private K element;
    private int identityLevel;
    private List<String> identityDescriptions;

    public SearchResult(K element) {
        this.element = element;
        this.identityLevel = 0;
        this.identityDescriptions = new ArrayList<>();
    }

    public int getIdentityLevel() {
        return identityLevel;
    }

    public K getElement() {
        return element;
    }

    public List<String> getIdentityDescriptions() {
        return new ArrayList<>(identityDescriptions);
    }

    public void incrementIdentityLevel() {
        this.identityLevel++;
    }

    public void addIdentityDescription(String description) {
        identityDescriptions.add(description);
    }
}
