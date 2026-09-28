# Unidad-3-Ejercicio-7
Programacion 3 Unidad 3 Ejercicio 7
Ejercicio 7 — Alta de clientes con INSERT
En este ejercicio vas a implementar la operación de alta: permitir al usuario ingresar datos en un formulario y persistirlos en la base de datos mediante una sentencia INSERT.

Construí una ventana con la siguiente estructura:

Un panel con el formulario de alta:
Etiqueta y campo de texto para Nombre
Etiqueta y campo de texto para Email
Etiqueta y campo de texto para Teléfono
Un botón con el texto "Guardar cliente"
Una JTable debajo que muestre todos los clientes de la base de datos con las columnas: ID, Nombre, Email, Teléfono
El comportamiento esperado es el siguiente:

Al presionar "Guardar cliente", la aplicación debe validar que ningún campo esté vacío
Si la validación es exitosa, debe ejecutar un INSERT en la tabla clientes y recargar la tabla con los datos actualizados
Si ocurre algún error, debe mostrarse un mensaje mediante JOptionPane
Tras guardar exitosamente, los campos del formulario deben limpiarse automáticamente
💡 Tip: usá siempre PreparedStatement para el INSERT, nunca concatenes directamente los valores del usuario en la consulta SQL.
<img width="985" height="617" alt="image" src="https://github.com/user-attachments/assets/5b413e91-7f2b-4a35-b13f-75c99e593376" />
<img width="988" height="617" alt="image" src="https://github.com/user-attachments/assets/5e5311ea-e007-46c5-bf57-61b96a389e1d" />
<img width="985" height="617" alt="image" src="https://github.com/user-attachments/assets/c1407318-5df7-41a8-953d-67526515643f" />
