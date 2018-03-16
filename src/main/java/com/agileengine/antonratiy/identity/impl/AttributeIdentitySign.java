package com.agileengine.antonratiy.identity.impl;

import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.util.Constants;
import org.jsoup.nodes.Element;

public class AttributeIdentitySign implements IdentitySign<Element> {
    private final String attributeName;

    public AttributeIdentitySign(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public boolean check(Element original, Element diff) {
        return original.attr(attributeName).equals(diff.attr(attributeName));
    }

    @Override
    public String getDescription() {
        return Constants.IdentityDescriptions.ATTRIBUTE_NAME + attributeName;
    }
}
