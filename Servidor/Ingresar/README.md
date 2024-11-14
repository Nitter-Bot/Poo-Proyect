# Carpeta [Ingreso]

## Descripcion

Carpeta del servidor que ayuda a registrar usuarios y autenticarlos para cuando se
desea realizar una conexion

## Contenido

- ** Autenticacion.java **
    Clase que contiene un hash map y una variable para su serializacion
    ### Atributos 
        serialVersionUID = 1, variable para la seriacion del objeto
        users , HashMap de los usarios , key = cadena del nombre del usuario
                value = objeto tipo Usuario que guarda el nombre y password
    ### Metodos 
        signUpUser( String usuario, String pass), agrega al mapa la cadena a buscar y 
                    el objeto usuario
        printMap(), metodo dummie, para realizar pruebas de que los usuarios si se guardan.

    ### To do
        Agregar metodo de autenticacion.
