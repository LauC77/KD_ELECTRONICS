
package ProjectJDBC;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConexionBD.probarConexion();
        GestorProducto gestor = new GestorProducto();

        Producto p = new Producto("P002", "Mouse inalámbrico", "Mouse USB 2.4GHz", 25000, 40000, "Accesorios", 50);
        gestor.insertarProducto(p);

        List<Producto> productos = gestor.listarProductos();
        for (Producto prod : productos) {
            System.out.println(prod.getNombre() + " - $" + prod.getPrecioVenta());
        }

        p.setPrecioVenta(40000);
        gestor.actualizarProducto(p);

        // gestor.eliminarProducto("P002");
    }
}

