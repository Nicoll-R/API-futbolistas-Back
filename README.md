# API-futbolistas-Back

- Se asignó el proyecto en server.port=4000
  Asegurarse de cambiar el puerto (si este ya esta ocupado) en Application.properties

- En el paquete Application.properties se especifica el puerto de la base de datos Mysql (en mi caso 3306), se usa la base de datos test, las tablas se crean al ejecutar el programa, así que la base debe estar vacía. El que se usa originalmente no tiene contraseña. 

- CrossOrigin principal en: controllers => UserController, línea 15
  Asegurarse de cambiar (origins = "xxx") por la url del server que se use en el Front.

- En caso de probar el ingreso de datos por medio de Postman o similares, el formato es el siguiente:	
		
{
			"firstName" : "xxx" 
			"lastName"  : "xxx" 
  	"dated"     : "yyyy-mm-dd" 
 		"charact"   : "xxx" 
 		"position"  : {
								"name"   : "xxx" 
 				} 
} 

