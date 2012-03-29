package com.pgu.restlet;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("titi")
public class Titi implements IsChild {

    private String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(final String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Titi [reference=" + reference + "]";
    }

}
