<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../layout/taglib.jsp" %>

	<h1>Latest news:</h1>
<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>Date</th>
						<th>Item</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${items}" var="item">
						<tr>
							<td>${item.publishedDate}</td>
							<td>
								<strong> 
									<a	href="<c:out value="${item.link }" />" target="_blank" >
										<c:out value="${item.title }" />		
									</a>
									<br />
									${item.description }
								</strong>
							</td>
							</tr>
					</c:forEach>
				</tbody>
				</table>