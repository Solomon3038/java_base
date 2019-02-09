package com.wladimir.basejava;

import com.wladimir.basejava.model.*;

import java.time.Month;
import java.util.UUID;

public class TestData {
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_2, "Name3");
        R4 = new Resume(UUID_2, "Name4");

        R1.setContact(ContactType.MAIL, "mail@ya.ru");
        R1.setContact(ContactType.PHONE, "11111");

        R4.setContact(ContactType.PHONE, "44444");
        R4.setContact(ContactType.SKYPE, "SKYPE");

        R1.setSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.setSection(SectionType.PERSONAL, new TextSection("Objective1"));
        R1.setSection(SectionType.ACHIEVEMENT, new TextSection("Objective1"));
        R1.setSection(SectionType.QUALIFICATIONS, new TextSection("Objective1"));
        R1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "contents1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "contents2")),
                        new Organization("Organization12", "http://Organization12.ru",
                                new Organization.Position(2005, Month.JANUARY, "position21", "content21"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position22", "content22")))
        );
        R1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute",null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));
        R2.setContact(ContactType.SKYPE, "skype2");
        R2.setContact(ContactType.PHONE, "22222");
    }

}
