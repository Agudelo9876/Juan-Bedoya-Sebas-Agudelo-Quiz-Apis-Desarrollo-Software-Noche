# Juan-Bedoya-Sebas-Agudelo-Quiz-Apis-Desarrollo-Software-Noche
Quizde dessarrollo de software

Consumo de rutas de API:

    GET
    localhost:8080/api/eventos/all

    #Obtener todos los eventos registrados

    POST
    localhost:8080/api/eventos/{id de evento}/inscribir

    cuerpo:

    {
        "nombre": "Juan Bedoya",
        "email": "juan@gmail.com
    }

    #Inscribe a un participante en un evento seleccionado

    GET
    localhost:8080/api/eventos/participantes/{id de evento}

    #Podemos ver los participantes de un evento especifico

    GET
    localhost:8080/api/eventos?fecha=(fecha de un evento especifico)

    #Visualizaremos la filtracion de eventos segun la fecha

    DELETE
    localhost:8080/api/eventos/{id de evento}/inscripcion/{id de participantes}

    cabecera: Authorization: token-id de participantes

    #Tendremos acceso por token para eliminar la inscripcion de un participante en un evento
