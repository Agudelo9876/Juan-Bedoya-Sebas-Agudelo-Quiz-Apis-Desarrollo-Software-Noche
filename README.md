# Juan-Bedoya-Sebas-Agudelo-Quiz-Apis-Desarrollo-Software-Noche
Quizde dessarrollo de software

Consumo de rutas de API:

**Obtener todos los eventos**

    GET
    localhost:8080/api/eventos/all

    #Obtener todos los eventos registrados

**Guardar un participante en un evento**

    POST
    localhost:8080/api/eventos/{id de evento}/inscribir

    cuerpo:

    {
        "nombre": "Juan Bedoya",
        "email": "juan@gmail.com
    }

    #Inscribe a un participante en un evento seleccionado

**Obtener los participantes de un evento seleccionado**

    GET
    localhost:8080/api/eventos/participantes/{id de evento}

    #Podemos ver los participantes de un evento especifico

**filtrar eventos por fecha**

    GET
    localhost:8080/api/eventos?fecha=(fecha de un evento especifico)

    #Visualizaremos la filtracion de eventos segun la fecha


**Eliminar un participante de un evento con token de autenticacion**

    DELETE
    localhost:8080/api/eventos/{id de evento}/inscripcion/{id de participantes}

    cabecera: Authorization: token-id de participantes

    #Tendremos acceso por token para eliminar la inscripcion de un participante en un evento
