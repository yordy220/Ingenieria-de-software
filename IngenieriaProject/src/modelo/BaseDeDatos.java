package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    private List<Producto> productos;

    public BaseDeDatos() {
        this.productos = new ArrayList<>();
    }

    // Agrega un producto
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Busca ignorando mayúsculas/minúsculas
    public Producto buscarProductoSku(String sku) {
        if (sku == null) return null;
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(sku.trim())) {
                return p;
            }
        }
        return null;
    }

    // Retorna todos
    public List<Producto> buscarTodos() {
        return new ArrayList<>(productos); // devolver copia para seguridad
    }

    // Eliminar por SKU
    public boolean eliminarProducto(String sku) {
        Producto encontrado = buscarProductoSku(sku);
        if (encontrado != null) {
            return productos.remove(encontrado);
        }
        return false;
    }
}
