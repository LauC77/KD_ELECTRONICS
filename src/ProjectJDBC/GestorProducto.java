
package ProjectJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorProducto {

    public void insertarProducto(Producto p) {
       String sql = "INSERT INTO productos (codigo_producto, nombre, descripcion, precio_base, precio_venta, categoria, cantidad_disponible) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getDescripcion());
            stmt.setDouble(4, p.getPrecioBase());
            stmt.setDouble(5, p.getPrecioVenta());
            stmt.setString(6, p.getCategoria());
            stmt.setInt(7, p.getCantidadDisponible());

            stmt.executeUpdate();
            System.out.println("Producto insertado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto(
                    rs.getString("codigo_producto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio_base"),
                    rs.getDouble("precio_venta"),
                    rs.getString("categoria"),
                    rs.getInt("cantidad_disponible")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizarProducto(Producto p) {
        String sql = "UPDATE productos SET nombre=?, descripcion=?, precio_base=?, precio_venta=?, categoria=?, cantidad_disponible=? WHERE codigo_producto=?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getDescripcion());
            stmt.setDouble(3, p.getPrecioBase());
            stmt.setDouble(4, p.getPrecioVenta());
            stmt.setString(5, p.getCategoria());
            stmt.setInt(6, p.getCantidadDisponible());
            stmt.setString(7, p.getCodigo());

            stmt.executeUpdate();
            System.out.println("Producto actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(String codigo) {
        String sql = "DELETE FROM productos WHERE codigo_producto=?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);
            stmt.executeUpdate();
            System.out.println("Producto eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

