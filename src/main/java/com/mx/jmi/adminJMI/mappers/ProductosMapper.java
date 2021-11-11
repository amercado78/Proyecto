package com.mx.jmi.adminJMI.mappers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import com.mx.jmi.adminJMI.dtos.ProductoDto;
import com.mx.jmi.adminJMI.entity.PreciosProductos;
import com.mx.jmi.adminJMI.helpers.ProductosHelper;


public final class ProductosMapper {
	
	private static final String ESTADO_ACTIVO = "Activo";
	private static final String ESTADO_INACTIVO = "Inactivo";
	private static final String EMPTY_STRING = "";
	
	public static List<ProductoDto> mapearListaCategoriasEntityACategoriaDto(List<PreciosProductos> preciosProductoslist,
			List<Tuple> tuples) {
		ProductoDto productoDto;
		List<ProductoDto> productoDtolist = new ArrayList<ProductoDto>();
		PreciosProductos preciosProductosSelected;
		for (Tuple tuple : tuples) {
			productoDto = new ProductoDto();
			productoDto.setId(Integer.parseInt(tuple.get(0).toString()));
			productoDto.setNombre(tuple.get(1).toString());
			productoDto.setDescripcion(tuple.get(2) != null ? tuple.get(2).toString(): EMPTY_STRING);
			productoDto.setEstatusId(Integer.parseInt(tuple.get(3).toString()));
			productoDto.setEstatus(Integer.parseInt(tuple.get(3).toString()) == 1 ? ESTADO_ACTIVO: ESTADO_INACTIVO);
			preciosProductosSelected = ProductosHelper.buscarPrecioProductoPorProductId(preciosProductoslist, productoDto.getId()); 
			productoDto.setPrecioProductoId(preciosProductosSelected.getPkprecioproducto());
			productoDto.setPrecioMenudeo(preciosProductosSelected.getPreciomenudeo());
			productoDto.setPrecioMayoreo(preciosProductosSelected.getPreciomayoreo());
			productoDto.setSubcategoriaId(Integer.parseInt(tuple.get(4).toString()));
			productoDto.setSubcategoria(tuple.get(5) != null ? tuple.get(5).toString(): EMPTY_STRING);
			productoDto.setCategoriaId(Integer.parseInt(tuple.get(6).toString()));
			productoDto.setCategoria(tuple.get(7) != null ? tuple.get(7).toString(): EMPTY_STRING);
			productoDtolist.add(productoDto);
        }
		return productoDtolist;
		
	}
}
