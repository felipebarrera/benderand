
package cl.webinc.benderand.util;

import cl.webinc.benderand.provider.Base.*;

public class GetType 
{
	public static String getType(int Matcher)
	{
		switch (Matcher) {
			case Constantes.ACTIVIDAD: 
				return actividad.CONTENT_TYPE;
			case Constantes.ACTIVIDAD_ID: 
				return actividad.CONTENT_ITEM_TYPE;
			case Constantes.CALLE: 
				return calle.CONTENT_TYPE;
			case Constantes.CALLE_ID: 
				return calle.CONTENT_ITEM_TYPE;
			case Constantes.CARACTERISTICA: 
				return caracteristica.CONTENT_TYPE;
			case Constantes.CARACTERISTICA_ID: 
				return caracteristica.CONTENT_ITEM_TYPE;
			case Constantes.CARNE_EMPRESA: 
				return carne_empresa.CONTENT_TYPE;
			case Constantes.CARNE_EMPRESA_ID: 
				return carne_empresa.CONTENT_ITEM_TYPE;
			case Constantes.CARNE_EMPRESACOMPLETO: 
				return carne_empresacompleto.CONTENT_TYPE;
			case Constantes.CARNE_EMPRESACOMPLETO_ID: 
				return carne_empresacompleto.CONTENT_ITEM_TYPE;
			case Constantes.CARRO_COMPRAS: 
				return carro_compras.CONTENT_TYPE;
			case Constantes.CARRO_COMPRAS_ID: 
				return carro_compras.CONTENT_ITEM_TYPE;
			case Constantes.CARRO_COMPRASCOMPLETO: 
				return carro_comprascompleto.CONTENT_TYPE;
			case Constantes.CARRO_COMPRASCOMPLETO_ID: 
				return carro_comprascompleto.CONTENT_ITEM_TYPE;
			case Constantes.CARRO_EGRESOS: 
				return carro_egresos.CONTENT_TYPE;
			case Constantes.CARRO_EGRESOS_ID: 
				return carro_egresos.CONTENT_ITEM_TYPE;
			case Constantes.CARRO_EGRESOSCOMPLETO: 
				return carro_egresoscompleto.CONTENT_TYPE;
			case Constantes.CARRO_EGRESOSCOMPLETO_ID: 
				return carro_egresoscompleto.CONTENT_ITEM_TYPE;
			case Constantes.CARRO_EGRESOSPRODUCTO: 
				return carro_egresosproducto.CONTENT_TYPE;
			case Constantes.CARRO_EGRESOSPRODUCTO_ID: 
				return carro_egresosproducto.CONTENT_ITEM_TYPE;
			case Constantes.CARRO_VENTA: 
				return carro_venta.CONTENT_TYPE;
			case Constantes.CARRO_VENTA_ID: 
				return carro_venta.CONTENT_ITEM_TYPE;
			case Constantes.CARRO_VENTACOMPLETO: 
				return carro_ventacompleto.CONTENT_TYPE;
			case Constantes.CARRO_VENTACOMPLETO_ID: 
				return carro_ventacompleto.CONTENT_ITEM_TYPE;
			case Constantes.CATEGORIA: 
				return categoria.CONTENT_TYPE;
			case Constantes.CATEGORIA_ID: 
				return categoria.CONTENT_ITEM_TYPE;
			case Constantes.CATEGORIA_EMPRESA: 
				return categoria_empresa.CONTENT_TYPE;
			case Constantes.CATEGORIA_EMPRESA_ID: 
				return categoria_empresa.CONTENT_ITEM_TYPE;
			case Constantes.CI_SESSIONS: 
				return ci_sessions.CONTENT_TYPE;
			case Constantes.CI_SESSIONS_ID: 
				return ci_sessions.CONTENT_ITEM_TYPE;
			case Constantes.CLIENTE: 
				return cliente.CONTENT_TYPE;
			case Constantes.CLIENTE_ID: 
				return cliente.CONTENT_ITEM_TYPE;
			case Constantes.CLIENTE_EMPRESA: 
				return cliente_empresa.CONTENT_TYPE;
			case Constantes.CLIENTE_EMPRESA_ID: 
				return cliente_empresa.CONTENT_ITEM_TYPE;
			case Constantes.COMPRACOMPLETA: 
				return compracompleta.CONTENT_TYPE;
			case Constantes.COMPRACOMPLETA_ID: 
				return compracompleta.CONTENT_ITEM_TYPE;
			case Constantes.COMUNA: 
				return comuna.CONTENT_TYPE;
			case Constantes.COMUNA_ID: 
				return comuna.CONTENT_ITEM_TYPE;
			case Constantes.CONTENIDO_UNIDAD_MEDIDA: 
				return contenido_unidad_medida.CONTENT_TYPE;
			case Constantes.CONTENIDO_UNIDAD_MEDIDA_ID: 
				return contenido_unidad_medida.CONTENT_ITEM_TYPE;
			case Constantes.DIA: 
				return dia.CONTENT_TYPE;
			case Constantes.DIA_ID: 
				return dia.CONTENT_ITEM_TYPE;
			case Constantes.EMPRESA: 
				return empresa.CONTENT_TYPE;
			case Constantes.EMPRESA_ID: 
				return empresa.CONTENT_ITEM_TYPE;
			case Constantes.ENVIO: 
				return envio.CONTENT_TYPE;
			case Constantes.ENVIO_ID: 
				return envio.CONTENT_ITEM_TYPE;
			case Constantes.FACTURA: 
				return factura.CONTENT_TYPE;
			case Constantes.FACTURA_ID: 
				return factura.CONTENT_ITEM_TYPE;
			case Constantes.FAMILIA_NECESIDAD: 
				return familia_necesidad.CONTENT_TYPE;
			case Constantes.FAMILIA_NECESIDAD_ID: 
				return familia_necesidad.CONTENT_ITEM_TYPE;
			case Constantes.FAMILIA_PRODUCTO: 
				return familia_producto.CONTENT_TYPE;
			case Constantes.FAMILIA_PRODUCTO_ID: 
				return familia_producto.CONTENT_ITEM_TYPE;
			case Constantes.FORMATO_PRODUCTO: 
				return formato_producto.CONTENT_TYPE;
			case Constantes.FORMATO_PRODUCTO_ID: 
				return formato_producto.CONTENT_ITEM_TYPE;
			case Constantes.GASTO: 
				return gasto.CONTENT_TYPE;
			case Constantes.GASTO_ID: 
				return gasto.CONTENT_ITEM_TYPE;
			case Constantes.GEOCODE_CACHE: 
				return geocode_cache.CONTENT_TYPE;
			case Constantes.GEOCODE_CACHE_ID: 
				return geocode_cache.CONTENT_ITEM_TYPE;
			case Constantes.IMAGENPROD: 
				return imagenprod.CONTENT_TYPE;
			case Constantes.IMAGENPROD_ID: 
				return imagenprod.CONTENT_ITEM_TYPE;
			case Constantes.IMPUESTO: 
				return impuesto.CONTENT_TYPE;
			case Constantes.IMPUESTO_ID: 
				return impuesto.CONTENT_ITEM_TYPE;
			case Constantes.INGRESOSEGRESOS: 
				return ingresosegresos.CONTENT_TYPE;
			case Constantes.INGRESOSEGRESOS_ID: 
				return ingresosegresos.CONTENT_ITEM_TYPE;
			case Constantes.ITEM_FACTURA: 
				return item_factura.CONTENT_TYPE;
			case Constantes.ITEM_FACTURA_ID: 
				return item_factura.CONTENT_ITEM_TYPE;
			case Constantes.ITEM_FACTURACOMPLETO: 
				return item_facturacompleto.CONTENT_TYPE;
			case Constantes.ITEM_FACTURACOMPLETO_ID: 
				return item_facturacompleto.CONTENT_ITEM_TYPE;
			case Constantes.MAPA: 
				return mapa.CONTENT_TYPE;
			case Constantes.MAPA_ID: 
				return mapa.CONTENT_ITEM_TYPE;
			case Constantes.PAIS: 
				return pais.CONTENT_TYPE;
			case Constantes.PAIS_ID: 
				return pais.CONTENT_ITEM_TYPE;
			case Constantes.PERSONA: 
				return persona.CONTENT_TYPE;
			case Constantes.PERSONA_ID: 
				return persona.CONTENT_ITEM_TYPE;
			case Constantes.PRECIO: 
				return precio.CONTENT_TYPE;
			case Constantes.PRECIO_ID: 
				return precio.CONTENT_ITEM_TYPE;
			case Constantes.PRODUCTO: 
				return producto.CONTENT_TYPE;
			case Constantes.PRODUCTO_ID: 
				return producto.CONTENT_ITEM_TYPE;
			case Constantes.PRODUCTOCOMPLETO: 
				return productocompleto.CONTENT_TYPE;
			case Constantes.PRODUCTOCOMPLETO_ID: 
				return productocompleto.CONTENT_ITEM_TYPE;
			case Constantes.PRODUCTOCOMPRA: 
				return productocompra.CONTENT_TYPE;
			case Constantes.PRODUCTOCOMPRA_ID: 
				return productocompra.CONTENT_ITEM_TYPE;
			case Constantes.PRODUCTOPRECIO: 
				return productoprecio.CONTENT_TYPE;
			case Constantes.PRODUCTOPRECIO_ID: 
				return productoprecio.CONTENT_ITEM_TYPE;
			case Constantes.PROVINCIA: 
				return provincia.CONTENT_TYPE;
			case Constantes.PROVINCIA_ID: 
				return provincia.CONTENT_ITEM_TYPE;
			case Constantes.RECICLADO: 
				return reciclado.CONTENT_TYPE;
			case Constantes.RECICLADO_ID: 
				return reciclado.CONTENT_ITEM_TYPE;
			case Constantes.REGION: 
				return region.CONTENT_TYPE;
			case Constantes.REGION_ID: 
				return region.CONTENT_ITEM_TYPE;
			case Constantes.RUBRO: 
				return rubro.CONTENT_TYPE;
			case Constantes.RUBRO_ID: 
				return rubro.CONTENT_ITEM_TYPE;
			case Constantes.SINCRODATE: 
				return sincrodate.CONTENT_TYPE;
			case Constantes.SINCRODATE_ID: 
				return sincrodate.CONTENT_ITEM_TYPE;
			case Constantes.STOCK: 
				return stock.CONTENT_TYPE;
			case Constantes.STOCK_ID: 
				return stock.CONTENT_ITEM_TYPE;
			case Constantes.STOCKCOMPLETO: 
				return stockcompleto.CONTENT_TYPE;
			case Constantes.STOCKCOMPLETO_ID: 
				return stockcompleto.CONTENT_ITEM_TYPE;
			case Constantes.SUBCATEGORIA: 
				return subcategoria.CONTENT_TYPE;
			case Constantes.SUBCATEGORIA_ID: 
				return subcategoria.CONTENT_ITEM_TYPE;
			case Constantes.SUBRUBRO: 
				return subrubro.CONTENT_TYPE;
			case Constantes.SUBRUBRO_ID: 
				return subrubro.CONTENT_ITEM_TYPE;
			case Constantes.TALLA: 
				return talla.CONTENT_TYPE;
			case Constantes.TALLA_ID: 
				return talla.CONTENT_ITEM_TYPE;
			case Constantes.TIPO_DOCUMENTO: 
				return tipo_documento.CONTENT_TYPE;
			case Constantes.TIPO_DOCUMENTO_ID: 
				return tipo_documento.CONTENT_ITEM_TYPE;
			case Constantes.TIPO_EMPRESA: 
				return tipo_empresa.CONTENT_TYPE;
			case Constantes.TIPO_EMPRESA_ID: 
				return tipo_empresa.CONTENT_ITEM_TYPE;
			case Constantes.TIPO_PAGO: 
				return tipo_pago.CONTENT_TYPE;
			case Constantes.TIPO_PAGO_ID: 
				return tipo_pago.CONTENT_ITEM_TYPE;
			case Constantes.TIPO_PRODUCTO: 
				return tipo_producto.CONTENT_TYPE;
			case Constantes.TIPO_PRODUCTO_ID: 
				return tipo_producto.CONTENT_ITEM_TYPE;
			case Constantes.TIPO_USUARIO: 
				return tipo_usuario.CONTENT_TYPE;
			case Constantes.TIPO_USUARIO_ID: 
				return tipo_usuario.CONTENT_ITEM_TYPE;
			case Constantes.UBICACION: 
				return ubicacion.CONTENT_TYPE;
			case Constantes.UBICACION_ID: 
				return ubicacion.CONTENT_ITEM_TYPE;
			case Constantes.USUARIO: 
				return usuario.CONTENT_TYPE;
			case Constantes.USUARIO_ID: 
				return usuario.CONTENT_ITEM_TYPE;
			case Constantes.USUARIOCOMPLETO: 
				return usuariocompleto.CONTENT_TYPE;
			case Constantes.USUARIOCOMPLETO_ID: 
				return usuariocompleto.CONTENT_ITEM_TYPE;
			case Constantes.VALOR_NUTRICIONAL: 
				return valor_nutricional.CONTENT_TYPE;
			case Constantes.VALOR_NUTRICIONAL_ID: 
				return valor_nutricional.CONTENT_ITEM_TYPE;
			case Constantes.VENTA: 
				return venta.CONTENT_TYPE;
			case Constantes.VENTA_ID: 
				return venta.CONTENT_ITEM_TYPE;
			case Constantes.VENTACOMPLETA: 
				return ventacompleta.CONTENT_TYPE;
			case Constantes.VENTACOMPLETA_ID: 
				return ventacompleta.CONTENT_ITEM_TYPE;

			default:
				throw new IllegalArgumentException("Unknown URI " + Matcher);
		}
	}
}
			