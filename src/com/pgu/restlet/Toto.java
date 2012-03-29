package com.pgu.restlet;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("toto")
public class Toto implements IsChild {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toto [name=" + name + "]";
    }

}
