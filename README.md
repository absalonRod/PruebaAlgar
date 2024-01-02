prueba técnica

### Guía para Ejecutar mi prueba técnica 

1.Clonar el Repositorio:
    git clone https://github.com/absalonRod/PruebaAlgar.git
   

2. Acceder al Directorio del Proyecto:
   cd C:\Users\''tuUsuario''\Documents\PruebaAlgar
   
3.Instalar el entorno:
    Descargar VISUAL STUDIO
    importar el proyecto

4. Ejecutar proyecto:
Descargar postman y ejecutalo con estos endpoints

POST: http://localhost:8080/matriz/multiplicar
    Ejemplo body:
    {
  "matriz1": [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
  ],
  "matriz2": [
    [9, 8, 7],
    [6, 5, 4],
    [3, 2, 1]
  ]
}

GET: http://localhost:8080/clima/actual/"cuernavaca"
GET: http://localhost:8080/historico
