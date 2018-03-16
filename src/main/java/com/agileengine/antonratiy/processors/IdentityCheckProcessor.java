package com.agileengine.antonratiy.processors;

import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.entity.SearchResult;

import java.util.List;

public interface IdentityCheckProcessor<T> {
    SearchResult<T> identify(T another, List<IdentitySign<T>> identitySigns);
}
