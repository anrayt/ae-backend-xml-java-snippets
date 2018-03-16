package com.agileengine.antonratiy.util;


import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.identity.impl.*;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public final class IdentitySignUtils {

    public static List<IdentitySign<Element>> getDefaultIdentitySignsList() {
        List<IdentitySign<Element>> identitySigns = new ArrayList<>();
        IdentitySign<Element> tagIdentitySign = new TagNameIdentitySign();
        IdentitySign<Element> classNameIdentitySign = new ClassNameIdentitySign();
        IdentitySign<Element> textIdentitySign = new TextIdentitySign();

        IdentitySign<Element> hrefIdentitySign = new AttributeIdentitySign(Constants.Attributes.HREF);
        IdentitySign<Element> titleIdentitySign = new AttributeIdentitySign(Constants.Attributes.TITLE);
        IdentitySign<Element> onClickIdentitySign = new AttributeIdentitySign(Constants.Attributes.ON_CLICK);

        IdentitySign<Element> parentClassNameIdentitySign = new ParentClassNameIdentitySign();
        IdentitySign<Element> parentTagNameIdentitySign = new ParentTagNameIdentitySign();

        identitySigns.add(tagIdentitySign);
        identitySigns.add(classNameIdentitySign);
        identitySigns.add(textIdentitySign);
        identitySigns.add(hrefIdentitySign);
        identitySigns.add(titleIdentitySign);
        identitySigns.add(onClickIdentitySign);
        identitySigns.add(parentClassNameIdentitySign);
        identitySigns.add(parentTagNameIdentitySign);

        return identitySigns;
    }
}
