package com.agileengine.antonratiy.identity;

public interface IdentitySign<Type> {

    boolean check(Type original, Type diff);

    String getDescription();
}
