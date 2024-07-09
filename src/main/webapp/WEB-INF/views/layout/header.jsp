<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="/">Blog</a>
      </li>
      <c:if test="${empty principal}">
        <li class="nav-item">
          <a class="nav-link" href="/auth/loginForm">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/joinForm">회원가입</a>
        </li>
      </c:if>
      <c:if test="${not empty principal}">
        <li class="nav-item">
          <a class="nav-link" href="/auth/loginForm">글쓰기</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/joinForm">회원정보</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/joinForm">로그아웃</a>
        </li>
      </c:if>

    </ul>
  </div>
</nav>