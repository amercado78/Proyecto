package com.mx.jmi.adminJMI.helpers;

import java.util.List;
import java.util.Optional;

import com.mx.jmi.adminJMI.entity.PreciosProductos;

public final class ProductosHelper {
	
	public static PreciosProductos buscarPrecioProductoPorProductId(List<PreciosProductos> preciosProductoslist, int fkproducto) {
	    Optional<PreciosProductos> preciosProductos = preciosProductoslist.stream()
	        .filter(p -> p.getProductos().getPkproducto() == fkproducto)
	        .findFirst();
	    return preciosProductos.isPresent() ? preciosProductos.get() : null;
	} 
	
}
