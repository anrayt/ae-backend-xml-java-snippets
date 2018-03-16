package com.agileengine.antonratiy.identity.impl;

import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.util.Constants;
import org.jsoup.nodes.Element;

public class TagNameIdentitySign implements IdentitySign<Element> {

    @Override
    public boolean check(Element original, Element diff) {
        return original.tagName().equals(diff.tagName());
    }

    @Override
    public String getDescription() {
        return Constants.IdentityDescriptions.TAG_NAMES;
    }
}
