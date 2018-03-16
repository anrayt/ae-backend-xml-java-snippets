package com.agileengine.antonratiy.processors.impl;

import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.entity.SearchResult;
import com.agileengine.antonratiy.processors.IdentityCheckProcessor;

import java.util.List;

public class IdentityCheckProcessorImpl<T> implements IdentityCheckProcessor<T> {
    private final T original;

    public IdentityCheckProcessorImpl(T original) {
        this.original = original;
    }

    public SearchResult<T> identify(T another, List<IdentitySign<T>> identitySigns) {
        SearchResult<T> searchResult = new SearchResult<>(another);
        for (IdentitySign<T> identitySign : identitySigns) {
            boolean result = identitySign.check(original, another);
            if (result) {
                searchResult.incrementIdentityLevel();
                searchResult.addIdentityDescription(identitySign.getDescription());
            }
        }
        return searchResult;
    }
}
