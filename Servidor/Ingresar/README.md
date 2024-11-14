# Carpeta [Ingresar]

## Descripcion

Carpeta del servidor que ayuda a registrar usuarios y autenticarlos para cuando se
desea realizar una conexion

## Contenido

- **Autenticacion.java**
    Clase para verificar si el usario esta registrado
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

- **Usuario.java**
    Objeto Serializable para los datos de acceso
    ### Atributos
        serialVersionUID, variable para poder serializar nuestro objeto
        user, cadena de texto del nombre de usuario
        password, cadena que alamacena la password
   
    ### Metodos
        set/get User, set -> Cadena, get <- cadena
        set/get Password, set -> Cadena, get <- cadena

- **Serializar.java**
    Clase para serializar el objeto de autenticacion y usuario

    ### Metodos
        saveUsers(), recibe un objeto de tipo Autenticacion, el cual serializa a nivel
                   de bytes y los guarda en un txt llamada Usuarios
    ### To do
        Cambiar el Usuarios por un atributo para evitar errores?

- **Deserializar.java**
    Clase para desrializar el objeto de autenticacion y usuario
    ### Metodos
        loadUsers(), Regresa el estado del mapa
                    En caso de un error al abrir el archivo, o que la clase no se
                    encuentre regresa un objeto de tipo autenticacion

## Notas

- El archivo prueba fue usado para verificar que los datos se guardaban, se usara mas adelante para poder verificar cuando se haga una conexion al servidos
    
    ### To do
        Generar objeto de cuando se pida una conexion y verificarla, en autenticacion
        seria nadamas agregar los sockets necesario y el algoritmo para ello.

    ###Compilar
        Para compilar se genera una carpeta llamada Acceso
        Para su uso se importa esta carpeta
        Para la prueba

        javac --source-path Acceso/ Prueba.java
