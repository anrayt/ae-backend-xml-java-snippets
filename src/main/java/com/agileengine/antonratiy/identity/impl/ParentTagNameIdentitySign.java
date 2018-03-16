package com.agileengine.antonratiy.identity.impl;

import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.util.Constants;
import org.jsoup.nodes.Element;

public class ParentTagNameIdentitySign implements IdentitySign<Element> {
    @Override
    public boolean check(Element original, Element diff) {
        if (original.hasParent()) {
            return diff.hasParent() && original.parent().tagName().equals(diff.parent().tagName());
        }
        return !diff.hasParent();
    }

    @Override
    public String getDescription() {
        return Constants.IdentityDescriptions.PARENT_TAG_NAMES;
    }
}
