<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            border: 1px solid #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            border: 1px solid #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

    </style>
</head>
<body>


<h1>Author who have more than 1 book</h1>

<c:if test="${!empty task2}">
    <table class="tg">
        <tr>
            <th width="80">author_id</th>
        </tr>

        <c:forEach items="${task2}" var="author">
            <tr>
                <td>${author.intValue}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
