Formación SpringBoot - Spring Security | ForoAlura Challenge

<h1 align="center">Foro Alura ☕</h1>

![Challenge Oracle Next Education + Alura Banner](https://raw.githubusercontent.com/4ndersiTo/literAlura/main/img_readme/portada_alura.jpg)

Se desarrolló un backend que simule la logica de un FORO, donde que se puede agregar un Tópico que esta relacionado a un curso, y este topico puede ser agregado por un USUARIO(autor), este Tópico, puede contener varias RESPUESTAS, que son asignadas por cualquier USUARIO.

Se está aplicando conceptos de seguridad con Spring Security, para que solo USUARIOS authenticados, puedan manipular a los Tópicos.

Tambien se está encriptando las contraseñas, en el proceso de registro de usuario.

**Tecnologías 💻:**

   - Java 17 ☕

         - Uso de Programación Orientada a Objetos.
         - Uso de Programación Funcional - Streams.
   - PostgreSQL
   - Spring Boot

**Funcionamiento 👁️:**
   - Diagrama Entidad-Relación en PostgreSQL:

     ![diagrama ER](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/diagrama%20ER.PNG?raw=true)
   - Registro de USUARIO:

		![Registro usuario 1](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/registro_usuario_postman.PNG?raw=true)
		![Registro usuario 2](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/registro_usuario_postgres.PNG?raw=true)

   - Inicio de sesion de USUARIO:

        ![Inicio de sesion](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/inicio%20sesion.PNG?raw=true)
   - Registro de CURSO:

     ![Registro curso 1](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/registro%20curso%20-%20postman.PNG?raw=true)
     ![Registro curso 2](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/registro%20curso%20-%20postman%202.PNG?raw=true)
     ![Registro curso 3](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/registro%20curso%20-%20postgre.PNG?raw=true)
        
   - Publicación de varios Tópicos, con relacion al curso:

     ![publicacion_topico_1](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/publicacion%20topico.PNG?raw=true)
     ![publicacion_topico_2](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/publicacion%20topico%20postgre.PNG?raw=true)
     
   - Lista de Tópicos publicados:
     ![lista_topico](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/lista%20top%C3%ADcos.PNG?raw=true)

   - TOPIC por ID:
     ![topico por id](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/topico%20por%20id.PNG?raw=true)
   - Actualización de ESTADO de Tópico:
     ![actualizacion topico](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/actualizar%20postman.PNG?raw=true)
     ![actualizacion topico 2](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/actualizar%20postgres.PNG?raw=true)
   - Eliminación de Tópico:
     ![eliminación_topico 1](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/ekiminar%20postamn.PNG?raw=true)
     ![eliminación_topico 2](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/eliminar%20postgre.PNG?raw=true)
     ![eliminación_topico 3](https://github.com/4ndersiTo/foro_alura/blob/master/img_readme/eliminar%20postmna%20-%20lista.PNG?raw=true)

	

 