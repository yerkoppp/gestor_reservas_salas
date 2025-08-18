package model;

public class Venta {
    private int idVenta;
    private String comprador;
    private String vendedor;
    private int cantArticulos;
    private double subtotal;
    private double impuesto;
    private double total;

    public Venta(int idVenta, String comprador, String vendedor, int cantArticulos,
                 double subtotal, double impuesto, double total) {
        this.idVenta = idVenta;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.cantArticulos = cantArticulos;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    // Getters y Setters
    public int getIdVenta() { return idVenta; }
    public String getComprador() { return comprador; }
    public String getVendedor() { return vendedor; }
    public int getCantArticulos() { return cantArticulos; }
    public double getSubtotal() { return subtotal; }
    public double getImpuesto() { return impuesto; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return String.format("Venta #%d: %s compró %d artículos a %s, total $%.2f",
                idVenta, comprador, cantArticulos, vendedor, total);
    }
}
