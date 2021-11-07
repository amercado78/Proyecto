package com.mx.jmi.adminJMI.mappers;

import java.util.ArrayList;
import java.util.List;

import com.mx.jmi.adminJMI.dtos.SubcategoriaDto;
import com.mx.jmi.adminJMI.entity.Subcategorias;


public final class SubcategoriasMapper {
	private static final String ESTADO_ACTIVO = "Activo";
	private static final String ESTADO_INACTIVO = "Inactivo";
	
	public static List<SubcategoriaDto> mapearListaSubcategoriasEntityASubcategoriaDto(List<Subcategorias> listaSubcategorias) {
		SubcategoriaDto subcategoriaDto;
		List<SubcategoriaDto> listaDeSubcategorias = new ArrayList<SubcategoriaDto>();
		for (Subcategorias subcategoria:listaSubcategorias) {
			subcategoriaDto = new SubcategoriaDto();
			subcategoriaDto.setId(subcategoria.getPksubcategoria());
			subcategoriaDto.setNombre(subcategoria.getNombre());
			subcategoriaDto.setDescripcion(subcategoria.getDescripcion());
			subcategoriaDto.setEstatus(subcategoria.getEstatus());
			subcategoriaDto.setEstatusDescripcion(subcategoria.getEstatus() == 1 ? ESTADO_ACTIVO: ESTADO_INACTIVO);
			subcategoriaDto.setImagen(subcategoria.getImagen());
			subcategoriaDto.setIdCategoriaPadre(subcategoria.getCategoria().getPkCategoria());
			subcategoriaDto.setDescripcionCategoriaPadre(subcategoria.getCategoria().getNombre());
			listaDeSubcategorias.add(subcategoriaDto);
		}
		return listaDeSubcategorias;
    }

}
