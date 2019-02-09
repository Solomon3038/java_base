package com.wladimir.basejava.model;

public enum ContactType {
    PHONE("Tel."),
    MOBILE("Mobile"),
    HOME_PHONE("Festnetz."),
    SKYPE("Skype"){

        @Override
        public String toHtml0(String value) {
            return getTitle() + ": " + toLink("skype:" + value, value);
        }
    },
    MAIL("Email"){
        @Override
                public String toHtml0(String value){
            return getTitle() + ": "+ toLink("mailto:"+value,value);
        }

    },
    LINKEDIN("Profile LInkedIn"){
        @Override
        public String toHtml0(String value){
            return toLink(value);
        }
    },
    GITHUB ("Github Profile"){
        @Override
        public String toHtml0(String value){
            return toLink(value);
        }
    },
    STACKOVERFLOW("Profile Stackoverflow"){
        @Override
        public String toHtml0(String value){
            return toLink(value);
        }
    },
    HOME_PAGE("Home Page"){
        @Override
        public String toHtml(String value) {
            return toLink(value);
        }
    };
    private final String title;

    ContactType(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    protected String toHtml0(String value){
        return title + ": " + value;
    }

    public String toHtml(String value) {
        return(value == null) ? "" : toHtml0(value);
    }

    public String toLink (String href){
        return toLink(href, title);
    }

    public static String toLink(String href, String title){
        return"<a href='" + href + "'>" + title +"</a";
    }
}
