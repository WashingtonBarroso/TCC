<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	
	
	<form action="/horus/palestrante/save" method="post">
		 Nome: <input type="text" name="dto.palestrante.nome" value="${dto.palestrante.nome}" /><br /> 
		 Resumo: <textarea rows="4" cols="50" name="dto.palestrante.resumo" >${dto.palestrante.resumo}</textarea><br /> 
		 Título: <input type="text" name="dto.palestrante.titulo" value="${dto.palestrante.titulo}" /><br /> 
		
		<input type="submit" value="Salvar" />
	</form>
</body>
</html>