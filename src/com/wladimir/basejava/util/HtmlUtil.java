package com.wladimir.basejava.util;

import com.wladimir.basejava.model.Organization;

public class HtmlUtil {
    public static boolean isEmpty(String str){
        return str == null || str.trim().length()==0;
    }

    public static String formatDate(Organization.Position positions){
        return DateUtil.format(positions.getStartDate()) + " - " + DateUtil.format(positions.getEndDate());
    }
}
