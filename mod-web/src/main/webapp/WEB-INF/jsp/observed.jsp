<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
    if(typeof appModule === 'undefined'){
        document.location.href="/";
    }
</script>


<div class="well well-sm">
    Strona zawiera listę rzeczy które user dodał do listy obserwowanych ogłoszeń.<br>
    Jeśli jakiegoś ogłoszenia już nie ma to powinno być info z linkiem do rzeczy usera którego rzecz obserwował
</div>