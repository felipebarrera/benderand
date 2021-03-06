
package cl.webinc.benderand.entidad;

import android.database.Cursor;

import java.util.ArrayList;

import cl.webinc.benderand.provider.Base;

public class CompraConArticulos
{
    private String id_factura = "";
    private String rol_factura = "";
    private String dia_factura = "";
    private String mes_factura = "";
    private String ano_factura = "";
    private String fecha_factura = "";
    private String empresa_id_empresa = "";
    private String carne_empresa_id_carne_empresa = "";
    private String rut_proveedor = "";
    private String nombre_proveedor = "";
    private String telefono_proveedor = "";
    private String tipo_documento_id_tipo_documento = "";
    private String tipo_pago_id_tipo_pago = "";
    private String total_factura = "";
    private String id_tipo_pago = "";
    private String nombre_tipo_pago = "";
    private String comision_tipo_pago = "";
    private String id_tipo_documento = "";
    private String nombre_tipo_documento = "";
    private ArrayList articulos = new ArrayList<>();


    public CompraConArticulos(String id_factura, ArrayList articulos,String rol_factura, String dia_factura, String mes_factura, String ano_factura, String fecha_factura, String empresa_id_empresa, String carne_empresa_id_carne_empresa, String rut_proveedor, String nombre_proveedor, String telefono_proveedor, String tipo_documento_id_tipo_documento, String tipo_pago_id_tipo_pago, String total_factura, String id_tipo_pago, String nombre_tipo_pago, String comision_tipo_pago, String id_tipo_documento, String nombre_tipo_documento)
    {
        this.id_factura = id_factura;
        this.rol_factura = rol_factura;
        this.dia_factura = dia_factura;
        this.mes_factura = mes_factura;
        this.ano_factura = ano_factura;
        this.fecha_factura = fecha_factura;
        this.empresa_id_empresa = empresa_id_empresa;
        this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
        this.rut_proveedor = rut_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.tipo_documento_id_tipo_documento = tipo_documento_id_tipo_documento;
        this.tipo_pago_id_tipo_pago = tipo_pago_id_tipo_pago;
        this.total_factura = total_factura;
        this.id_tipo_pago = id_tipo_pago;
        this.nombre_tipo_pago = nombre_tipo_pago;
        this.comision_tipo_pago = comision_tipo_pago;
        this.id_tipo_documento = id_tipo_documento;
        this.nombre_tipo_documento = nombre_tipo_documento;
        this.articulos = articulos;

    }
    public CompraConArticulos(){}
    public String getId_factura()
    {
        return id_factura;
    }
    public String getRol_factura()
    {
        return rol_factura;
    }
    public String getDia_factura()
    {
        return dia_factura;
    }
    public String getMes_factura()
    {
        return mes_factura;
    }
    public String getAno_factura()
    {
        return ano_factura;
    }
    public String getFecha_factura()
    {
        return fecha_factura;
    }
    public String getEmpresa_id_empresa()
    {
        return empresa_id_empresa;
    }
    public String getCarne_empresa_id_carne_empresa()
    {
        return carne_empresa_id_carne_empresa;
    }
    public String getRut_proveedor()
    {
        return rut_proveedor;
    }
    public String getNombre_proveedor()
    {
        return nombre_proveedor;
    }
    public String getTelefono_proveedor()
    {
        return telefono_proveedor;
    }
    public String getTipo_documento_id_tipo_documento()
    {
        return tipo_documento_id_tipo_documento;
    }
    public String getTipo_pago_id_tipo_pago()
    {
        return tipo_pago_id_tipo_pago;
    }
    public String getTotal_factura()
    {
        return total_factura;
    }
    public String getId_tipo_pago()
    {
        return id_tipo_pago;
    }
    public String getNombre_tipo_pago()
    {
        return nombre_tipo_pago;
    }
    public String getComision_tipo_pago()
    {
        return comision_tipo_pago;
    }
    public String getId_tipo_documento()
    {
        return id_tipo_documento;
    }
    public String getNombre_tipo_documento()
    {
        return nombre_tipo_documento;
    }
    public void setId_factura(String id_factura)
    {
        this.id_factura = id_factura;
    }
    public void setRol_factura(String rol_factura)
    {
        this.rol_factura = rol_factura;
    }
    public void setDia_factura(String dia_factura)
    {
        this.dia_factura = dia_factura;
    }
    public void setMes_factura(String mes_factura)
    {
        this.mes_factura = mes_factura;
    }
    public void setAno_factura(String ano_factura)
    {
        this.ano_factura = ano_factura;
    }
    public void setFecha_factura(String fecha_factura) {this.fecha_factura = fecha_factura;}
    public void setEmpresa_id_empresa(String empresa_id_empresa) {this.empresa_id_empresa = empresa_id_empresa;}
    public void setCarne_empresa_id_carne_empresa(String carne_empresa_id_carne_empresa) {this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;}
    public void setRut_proveedor(String rut_proveedor) {this.rut_proveedor = rut_proveedor;}
    public void setNombre_proveedor(String nombre_proveedor) {this.nombre_proveedor = nombre_proveedor;}
    public void setTelefono_proveedor(String telefono_proveedor) {this.telefono_proveedor = telefono_proveedor;}
    public void setTipo_documento_id_tipo_documento(String tipo_documento_id_tipo_documento) {this.tipo_documento_id_tipo_documento = tipo_documento_id_tipo_documento;}
    public void setTipo_pago_id_tipo_pago(String tipo_pago_id_tipo_pago) {this.tipo_pago_id_tipo_pago = tipo_pago_id_tipo_pago;}
    public void setTotal_factura(String total_factura)
    {
        this.total_factura = total_factura;
    }
    public void setId_tipo_pago(String id_tipo_pago) {this.id_tipo_pago = id_tipo_pago;}
    public void setNombre_tipo_pago(String nombre_tipo_pago) {this.nombre_tipo_pago = nombre_tipo_pago;}
    public void setComision_tipo_pago(String comision_tipo_pago) {this.comision_tipo_pago = comision_tipo_pago;}
    public void setId_tipo_documento(String id_tipo_documento) {this.id_tipo_documento = id_tipo_documento;}
    public void setNombre_tipo_documento(String nombre_tipo_documento) {this.nombre_tipo_documento = nombre_tipo_documento;}
    public ArrayList getArticulos() {return articulos;}
    public void setArticulos(ArrayList articulos) {this.articulos = articulos;}


    public void CompraConArticulos(Cursor c){
        c.moveToFirst();
        while(!c.isAfterLast()) {
            this.id_factura = c.getString(c.getColumnIndex(Base.compracompleta.id_factura));
            this.rol_factura = c.getString(c.getColumnIndex(Base.compracompleta.rol_factura));
            this.dia_factura = c.getString(c.getColumnIndex(Base.compracompleta.dia_factura));
            this.mes_factura = c.getString(c.getColumnIndex(Base.compracompleta.mes_factura));
            this.fecha_factura = c.getString(c.getColumnIndex(Base.compracompleta.ano_factura));
            this.fecha_factura = c.getString(c.getColumnIndex(Base.compracompleta.fecha_factura));
            this.empresa_id_empresa = c.getString(c.getColumnIndex(Base.compracompleta.empresa_id_empresa));
            this.carne_empresa_id_carne_empresa = c.getString(c.getColumnIndex(Base.compracompleta.carne_empresa_id_carne_empresa));
            this.rut_proveedor = c.getString(c.getColumnIndex(Base.compracompleta.rut_proveedor));
            this.nombre_proveedor = c.getString(c.getColumnIndex(Base.compracompleta.nombre_proveedor));
            this.telefono_proveedor = c.getString(c.getColumnIndex(Base.compracompleta.telefono_proveedor));
            this.tipo_documento_id_tipo_documento = c.getString(c.getColumnIndex(Base.compracompleta.tipo_documento_id_tipo_documento));
            this.tipo_pago_id_tipo_pago = c.getString(c.getColumnIndex(Base.compracompleta.tipo_pago_id_tipo_pago));
            this.total_factura = c.getString(c.getColumnIndex(Base.compracompleta.total_factura));
            this.id_tipo_pago = c.getString(c.getColumnIndex(Base.compracompleta.id_tipo_pago));
            this.nombre_tipo_pago = c.getString(c.getColumnIndex(Base.compracompleta.nombre_tipo_pago));
            this.comision_tipo_pago = c.getString(c.getColumnIndex(Base.compracompleta.comision_tipo_pago));
            this.id_tipo_documento = c.getString(c.getColumnIndex(Base.compracompleta.id_tipo_documento));
            this.nombre_tipo_documento = c.getString(c.getColumnIndex(Base.compracompleta.nombre_tipo_documento));
            c.moveToNext();
        }
        c.close();
    }

    public void item_facturacompleto(Cursor c) {
        c.moveToFirst();
        while (!c.isAfterLast()) {
            this.articulos.add(
                    new Item_facturacompleto(
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.id_itemfactura)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.cantidad)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.precio)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.producto_id_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.factura_id_factura)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.id_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.codigo_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.numero_serie)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.descripcion_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.nombre_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.marca_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.modelo_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.contenido_unidad)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.unidad_minima)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.contenido)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.peso_neto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.alto_cm)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.ancho_cm)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.fondo_cm)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.fabricante)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.clase_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.linea_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.hot)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.SKU)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.subcategoria_id_subcategoria)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.tipo_producto_id_tipo_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.formato_producto_id_formato_producto)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.familia_necesidad_id_familia_necesidad)),
                            c.getString(c.getColumnIndex(Base.item_facturacompleto.familia_producto_id_familia_producto))
                    )
            );
            c.moveToNext();
        }
        c.close();
    }
}