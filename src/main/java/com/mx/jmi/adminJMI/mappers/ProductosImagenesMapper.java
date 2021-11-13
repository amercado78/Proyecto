package com.mx.jmi.adminJMI.mappers;

import java.util.ArrayList;
import java.util.List;

import com.mx.jmi.adminJMI.dtos.ProductosImagenesDto;
import com.mx.jmi.adminJMI.entity.ProductosImagenes;

public final class ProductosImagenesMapper {
	
	public static List<ProductosImagenesDto> mapearListaProductosImagenesEntityAProductosImagenesDto(List<ProductosImagenes> productosImagenesList){
		List<ProductosImagenesDto> productosImagenesDtoList = new ArrayList<ProductosImagenesDto>();
		ProductosImagenesDto productosImagenesDto;
		
		for( ProductosImagenes productoImagen: productosImagenesList) {
			productosImagenesDto = new ProductosImagenesDto();
			productosImagenesDto.setId(productoImagen.getPkproductoimagen());
			productosImagenesDto.setIdProducto(productoImagen.getProductos().getPkproducto());
			productosImagenesDto.setNombreProducto(productoImagen.getProductos().getNombre());
			List<String> urlImagenes = new ArrayList<String>();
			for(ProductosImagenes productImg : productosImagenesList){
				urlImagenes.add(productImg.getUrl());
			}
			productosImagenesDto.setUrlsImagenes(urlImagenes);
			productosImagenesDtoList.add(productosImagenesDto);
			break;
		}
		return productosImagenesDtoList;
		
	}

}
