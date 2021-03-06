package com.wladimir.basejava.model;

import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {
    public static final long serialVersionUID = 1L;

    private String name;
    private String url;

    public Link(String name, String url){
        Objects.requireNonNull(name,"name must be not null");
        this.name = name;
        this.url = url == null ? "" : url;
    }

    public Link () {

    }
    public String getName(){
        return name;
    }


    public String getUrl() {
        return url;
    }
    @Override
    public String toString(){;
        return "Link(" + name +"," + url +")";
    }

    @Override
    public boolean equals(Object o) {  // sdes url pri generacii null
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!name.equals(link.name)) return false;
        return url != null ? url.equals(link.url) : link.url == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
