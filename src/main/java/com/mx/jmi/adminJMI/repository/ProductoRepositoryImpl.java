package com.mx.jmi.adminJMI.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.jmi.adminJMI.dtos.ProductoDto;
import com.mx.jmi.adminJMI.entity.Categorias;
import com.mx.jmi.adminJMI.entity.PreciosProductos;
import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.entity.Subcategorias;
import com.mx.jmi.adminJMI.helpers.ProductosHelper;
import com.mx.jmi.adminJMI.interfaces.ProductoRepositoryCustom;
import com.mx.jmi.adminJMI.mappers.ProductosMapper;

@Repository
public class ProductoRepositoryImpl implements ProductoRepositoryCustom{
	
	protected EntityManager entityManager;
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    public Productos getProductosById(int id) throws DataAccessException {
        return getEntityManager().find(Productos.class, id);
    }
    
    @Transactional
    public PreciosProductos getPreciosProductosByProductoId(int fkproducto) throws DataAccessException {
    	CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PreciosProductos> criteriaQuery = criteriaBuilder.createQuery(PreciosProductos.class);
        Root<PreciosProductos> preciosProductoRoot = criteriaQuery.from(PreciosProductos.class);
        PreciosProductos queryResult = getEntityManager().createQuery(criteriaQuery.select(preciosProductoRoot)
          .where(criteriaBuilder.equal(preciosProductoRoot.get("productos"), fkproducto)))
          .getSingleResult();
        return queryResult;
    }
	
    @Override
    @Transactional
    public List<ProductoDto> getProductos() throws DataAccessException {
    	
    	List<ProductoDto> productoDtolist = new ArrayList<ProductoDto>();
    	CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<Tuple> q = cb.createQuery(Tuple.class);
    	Root<Productos> p = q.from(Productos.class);
    	Join<Productos, Subcategorias> s = p.join("subcategoria", JoinType.INNER);
    	Join<Subcategorias, Categorias> c = s.join("categoria", JoinType.INNER);	    	
    	List<PreciosProductos> preciosProductoslist = getPreciosProductos();
    	
    	q.multiselect(
    			p.get("pkproducto"), 
    			p.get("nombre"),
    			p.get("descripcion"),
    			p.get("estatus"),
    			s.get("pksubcategoria"),
    			s.get("nombre"),
    			c.get("pkcategoria"), 
    			c.get("nombre"));
    	List<Tuple> tuples = getEntityManager().createQuery( q ).getResultList();
    	productoDtolist = ProductosMapper.mapearListaCategoriasEntityACategoriaDto(preciosProductoslist, tuples);
    	return productoDtolist;
    }
    
	private List<PreciosProductos> getPreciosProductos() {
		
		CriteriaBuilder criteriaBuilder =  getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<PreciosProductos> criteriaQuery = criteriaBuilder.createQuery(PreciosProductos.class);
    	Root<PreciosProductos> precioProductosRoot = criteriaQuery.from(PreciosProductos.class);

    	Subquery<Productos> productosSubquery = criteriaQuery.subquery(Productos.class);
    	Root<Productos> productosRoot = productosSubquery.from(Productos.class);
    	productosSubquery.select(productosRoot);

    	Expression<Productos> stringExpression = precioProductosRoot.get("productos");
    	Predicate predicateIn = stringExpression.in(productosSubquery);

    	criteriaQuery.select( precioProductosRoot ).where(predicateIn);
    	List<PreciosProductos> preciosProductoslist = getEntityManager().createQuery( criteriaQuery ).getResultList();
    	
    	return preciosProductoslist;
	}
  
}
