<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="authbar">
		<span><spring:message code="welcome"/> <strong>${loggedinuser}</strong></span> <span class="floatRight"><a href="<c:url value="/logout" />"><spring:message code="logout"/></a></span>
	</div>
