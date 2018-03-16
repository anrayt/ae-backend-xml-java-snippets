package com.agileengine.antonratiy.identity.impl;

import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.util.Constants;
import org.jsoup.nodes.Element;


public class ParentClassNameIdentitySign implements IdentitySign<Element> {
    @Override
    public boolean check(Element original, Element diff) {
        if (original.hasParent()) {
            return diff.hasParent() && original.parent().className().equals(diff.parent().className());
        }
        return !diff.hasParent();
    }

    @Override
    public String getDescription() {
        return Constants.IdentityDescriptions.PARENT_CLASS_NAMES;
    }
}
