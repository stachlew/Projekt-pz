<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
    if(typeof appModule === 'undefined'){
        document.location.href="/";
    }
</script>

<div class="well well-sm">
    Do przycisku WYPOŻYCZANE <br>
    Strona zawiera 2 listy: <br>
    -lista swoich rzeczy które wypożyczają inni
    -lista rzeczy które wypożycza od kogoś innego
</div>