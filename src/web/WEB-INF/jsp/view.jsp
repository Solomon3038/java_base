<%@ page import="com.wladimir.basejava.model.ListSection" %>
<%@ page import="com.wladimir.basejava.model.OrganizationSection" %>
<%@ page import="com.wladimir.basejava.model.TextSection" %>
<%@ page import="com.wladimir.basejava.util.HtmlUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="com.wladimir.basejava.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <h1>${resume.fullName}&nbsp;<a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png"></a></h1>
    <p>
        <c:forEach var="contactEntry" items="${resume.contacts}">
            <jsp:useBean id="contactEntry"
                         type="java.util.Map.Entry<com.wladimir.basejava.model.ContactType, java.lang.String>"/>
            <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br/>


        </c:forEach>
    </p>
    <hr>
    <table cellspacing="2">
        <c:forEach var="sectionEntry" items="${resume.sections}">
            <jsp:useBean id="sectionEntry"
                         type="java.util.Map.Entry<com.wladimir.basejava.model.SectionType, com.wladimir.basejava.model.Section>"/>
            <c:set var="type" value="${sectionEntry.key}"/>
            <c:set var="section" value="${sectionEntry.value}"/>
            <jsp:useBean id="section" type="com.wladimir.basejava.model.Section"/>
            <tr>
                <td colspan="2"><h2><a name="type.name">${type.title}</a></h2></td>
            </tr>
            <c:choose>
                <c:when test="${type=='OBJECTIVE'}">
                    <tr>
                        <td colspan="2">
                            <h3><%=((TextSection) section).getContent()%>
                            </h3>
                        </td>
                    </tr>
                </c:when>
                <c:when test="${type=='QUALIFICATION' || type=='ACHIEVEMENT'}">
                    <tr>
                        <td colspan="2">
                            <ul>
                                <c:forEach var="item" items="<%=((ListSection)section).getItems()%>">
                                    <li>${item}</li>
                                </c:forEach>
                            </ul>
                        </td>
                    </tr>
                </c:when>
                <c:when test="${type=='EXPERIENCE' || type=='EDUCATION'}">
                    <c:forEach var="org" items="<%=((OrganizationSection)section).getOrganizations()%>">
                        <tr>
                            <td colspan="2">
                                <c:choose>
                                    <c:when test="${empty org.homePage.url}">
                                        <h3>${org.homePage.name}</h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3><a href="${org.homePage.url}">${org.homePage.name}</a></h3>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <c:forEach var="position" items="${org.positions}">
                            <jsp:useBean id="position" type="com.wladimir.basejava.model.Organization.Position"/>
                            <tr>
                                <td width="15" style="vertical-align: top"><%=HtmlUtil.formatDate(position)%>
                                </td>
                                <td><b>${position.title}</b><br>${position.description}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:forEach>

    </table>
    <br/>
    <button onclick="window.history.back()">OK</button>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>