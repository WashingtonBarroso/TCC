<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	
       <form action="/dame/organizador/save" method="post">
		 Nome: <input type="text" name="dto.organizador.nome" value="${dto.organizador.nome}" /><br /> 
		 Cargo: <input type="text" name="dto.organizador.cargo" value="${dto.organizador.cargo}"/><br /> 
		 Área: <input type="text" name="dto.organizador.area" value="${dto.organizador.area}" /><br /> 
		
		<input type="submit" value="Salvar" />
	</form>
</body>
</html>