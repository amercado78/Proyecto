package com.mx.jmi.adminJMI.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Tuple;

import com.mx.jmi.adminJMI.dtos.ProductoActualizarDto;
import com.mx.jmi.adminJMI.dtos.ProductoDto;
import com.mx.jmi.adminJMI.entity.Categorias;
import com.mx.jmi.adminJMI.entity.PreciosProductos;
import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.entity.ProductosImagenes;
import com.mx.jmi.adminJMI.entity.Subcategorias;
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
	
	public static ProductoActualizarDto mapearAproductoActualizarDto(Productos producto,
			List<Subcategorias> subcategorias, List<Categorias> categorias, PreciosProductos precioProducto,
			List<ProductosImagenes> productosImagenesList) {
		ProductoActualizarDto productoActualizarDto = new ProductoActualizarDto();
		productoActualizarDto.setId(producto.getPkproducto());
		productoActualizarDto.setNombreProducto(producto.getNombre());
		productoActualizarDto.setDescripcionProducto(producto.getDescripcion());
		productoActualizarDto.setEstatusId(producto.getEstatus());
		productoActualizarDto.setPrecio(precioProducto.getPreciomenudeo());
		productoActualizarDto.setPrecioProductoId(precioProducto.getPkprecioproducto());
		Map<Integer, String> subcategoriasMap = new TreeMap<Integer, String>();
		for(Subcategorias subcategoria : subcategorias) {
			subcategoriasMap.put(subcategoria.getPksubcategoria(), subcategoria.getNombre());
		}
		productoActualizarDto.setSubcategorias(subcategoriasMap);
		Map<Integer, String> categoriasMap = new TreeMap<Integer, String>();
		for(Categorias categoria : categorias) {
			categoriasMap.put(categoria.getPkCategoria(), categoria.getNombre());
		}
		productoActualizarDto.setCategorias(categoriasMap);
		Map<Integer, String> productosImagenesMap = new TreeMap<Integer, String>();
		for(ProductosImagenes productosImagen : productosImagenesList) {
			productosImagenesMap.put(productosImagen.getPkproductoimagen(), productosImagen.getUrl());
		}
		productoActualizarDto.setProductoImagenes(productosImagenesMap);
		return productoActualizarDto;
	}
}
