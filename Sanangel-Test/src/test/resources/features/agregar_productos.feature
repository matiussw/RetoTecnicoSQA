Feature: Agregar Producto al carrito de compras

  Scenario: Agregar 2 productos al carro de compras
    Given Estoy Dentro del Portal Web "https://sanangel.com.co/"
    When  Seleciono Productos de Mi Agrado y Agrego 2 Cantidades de un producto y 5 Cantidades de otro
    Then Puedo ver los  Productos Agregados "Riviera" Y "Manarola" Con Su respectiva cantidad