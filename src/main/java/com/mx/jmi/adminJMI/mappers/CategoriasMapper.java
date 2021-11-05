package com.mx.jmi.adminJMI.mappers;

import java.util.ArrayList;
import java.util.List;

import com.mx.jmi.adminJMI.dtos.CategoriaDto;
import com.mx.jmi.adminJMI.entity.Categorias;

public final class CategoriasMapper {
	
	private static final String ESTADO_ACTIVO = "Activo";
	private static final String ESTADO_INACTIVO = "Inactivo";
	
	public static List<CategoriaDto> mapearListaCategoriasEntityACategoriaDto(List<Categorias> listaCategorias) {
		CategoriaDto categoriaDto;
		List<CategoriaDto> listaDeCategorias = new ArrayList<CategoriaDto>();
		for (Categorias categoria:listaCategorias) {
			categoriaDto = new CategoriaDto();
			categoriaDto.setId(categoria.getPkCategoria());
			categoriaDto.setNombre(categoria.getNombre());
			categoriaDto.setDescripcion(categoria.getDescripcion());
			categoriaDto.setEstatus(categoria.getEstatus());
			categoriaDto.setEstatusDescripcion(categoria.getEstatus() == 1 ? ESTADO_ACTIVO: ESTADO_INACTIVO);
			categoriaDto.setImagen(categoria.getImagen());
			listaDeCategorias.add(categoriaDto);
		}
		return listaDeCategorias;
    }

}
