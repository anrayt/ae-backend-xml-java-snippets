package com.agileengine.antonratiy.identity.impl;


import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.util.Constants;
import org.jsoup.nodes.Element;

public class TextIdentitySign implements IdentitySign<Element> {
    @Override
    public boolean check(Element original, Element diff) {
        return original.text().equals(diff.text());
    }

    @Override
    public String getDescription() {
        return Constants.IdentityDescriptions.TEXT;
    }
}
