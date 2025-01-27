<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Frontend</title>
</head>
<body>
    <h1>Este es el Frontend</h1>
    <?php
    
    $backend_url = 'http://springboot-container:9000/api/productos'; 
    $backend_url_producto = 'http://springboot-container:9000/api/productos/2';

    $respuesta = file_get_contents($backend_url);
    $respuesta2 = file_get_contents($backend_url_producto);
    echo "<pre>Busqueda de todos los productos: $respuesta</pre>";
    echo "<pre>Busqueda de un producto en especifico: $respuesta2</pre>";
    ?>
</body>
</html>
