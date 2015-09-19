<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	
<form action="/horus/evento/save" method="post">
		 Nome: <input type="text" name="dto.evento.nome" value="${dto.evento.nome}" /><br /> 
		 Local: <input type="text" name="dto.evento.local" value="${dto.evento.local}" /><br /> 
		 Estado: <input type="text" name="dto.evento.estado" value="${dto.evento.estado}" /><br /> 
		 Cidade: <input type="text" name="dto.evento.cidade" value="${dto.evento.cidade}" /><br />
		 Site: <input type="text" name="dto.evento.site" value="${dto.evento.site}" /><br />
		<input type="submit" value="Salvar" />
	</form>
</body>
</html>