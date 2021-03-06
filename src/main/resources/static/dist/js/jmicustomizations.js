/* Start Product image slidewhow*/
function getProductImages(id) {
	const loc = window.location.href;
	const path = loc.substr(0, loc.lastIndexOf('/') + 1);
	const httpClient = new XMLHttpRequest();
	const endpoint = 'imagenesProducto/'+id;
	const url= path + endpoint;
	
	httpClient.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	    setProductImages(JSON.parse(this.responseText));
	  }
	};
	
	httpClient.open("GET", url);
	httpClient.send();
		
}

function setProductImages(productImagesJson){
	const productImageTittleContainer = document.querySelector('#product-image-title');
	removeAllChildNodes(productImageTittleContainer);
	var producImageTitle = document.getElementById("product-image-title");
	var productNameSpan = document.createElement('span')
	productNameSpan.className ='text-lowercase'; 
	productNameSpan.innerHTML = productImagesJson[0].nombreProducto;
	producImageTitle.appendChild(productNameSpan);
	
	const container = document.querySelector('#product-image-wrapper');
	removeAllChildNodes(container);
	var divProductImageWrapper = document.getElementById("product-image-wrapper");
	var imageCounter = 0;
	var imageIndex = 1;
	productImagesJson[0].urlsImagenes.forEach((item) => {
		
		if(imageCounter == 0){
			const productImageHeaderContainer = document.querySelector('#product-image-header');
			removeAllChildNodes(productImageHeaderContainer);
			var producImageHeader = document.getElementById("product-image-header");
			var productHeaderImg = document.createElement('img')
			productHeaderImg.src = item;
			productHeaderImg.alt = "Product Image";
			productHeaderImg.className= 'product-image';
			producImageHeader.appendChild(productHeaderImg)
		}
		
		let divProductImageThumb = document.createElement("div");
		divProductImageThumb.className = "product-image-thumb";
		divProductImageThumb.id =  "product-image-thumb-"+imageIndex;
		divProductImageThumb.setAttribute('onclick', `changeProductImage(${imageIndex});` );
		var img = document.createElement("img");
		img.alt = "Product Image";
		img.src = item;
		divProductImageThumb.appendChild(img);
		divProductImageWrapper.appendChild(divProductImageThumb);
		imageCounter++;	
		imageIndex++;	
	   });
}

function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}

function changeProductImage(id){
	var productThumbImageWrapper = document.getElementById("product-image-thumb-"+id);
	var productThumbImage = productThumbImageWrapper.getElementsByTagName('img');
	var producImageHeader = document.getElementById("product-image-header");
	var principalImg = producImageHeader.getElementsByTagName('img');
	principalImg[0].src = productThumbImage[0].src;
}

/* Final product image slidewhow*/
/* Start product update addon*/
function getProductPropertiesToUpdate(id) {
	const loc = window.location.href;
	const path = loc.substr(0, loc.lastIndexOf('/') + 1);
	const httpClient = new XMLHttpRequest();
	const endpoint = 'getProductByUpdate/'+id;
	const url= path + endpoint;
	
	httpClient.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	    setProductPropertiesToUpdate(JSON.parse(this.responseText));
	  }
	};
	
	httpClient.open("GET", url);
	httpClient.send();
}

function setProductPropertiesToUpdate(productPropertiesToUpdate){
	//console.log(productPropertiesToUpdate);
	var outputImageToProductUpdate = document.getElementById("output-image-to-product-update");
    removeAllChildNodes(outputImageToProductUpdate);
	var modalTitleProductUpdate = document.getElementById("modal-title-product-update");
	modalTitleProductUpdate.innerHTML = 'Producto a actualizar: ' + productPropertiesToUpdate.nombreProducto;
	document.getElementById("modal-product-name-product-to-update").value = productPropertiesToUpdate.nombreProducto;
	document.getElementById("modal-product-description-product-to-update").value = productPropertiesToUpdate.descripcionProducto;
	document.getElementById("modal-product-price-product-to-update").value = productPropertiesToUpdate.precio;
	document.getElementById("modal-product-id-product-to-update").value = productPropertiesToUpdate.id;
	setSubcategoriesProductToUpdate(productPropertiesToUpdate);
	setCategoriesProductToUpdate(productPropertiesToUpdate);
	setImagesProductToUpdate(productPropertiesToUpdate);
	
}

/* Final product update addon*/
function setSubcategoriesProductToUpdate(productPropertiesToUpdate){
	var modalProductSubcategoryProductToUpdate=document.getElementById("modal-product-subcategory-product-to-update");
	for(var i in productPropertiesToUpdate.subcategorias) {
	    if (productPropertiesToUpdate.subcategorias.hasOwnProperty(i)) {
			var subcategoryOption=document.createElement("option");
			subcategoryOption.setAttribute("value",i);
			var subcategoryTexto = document.createTextNode('Subcategoria: ' + productPropertiesToUpdate.subcategorias[i]);
			subcategoryOption.appendChild(subcategoryTexto);
			modalProductSubcategoryProductToUpdate.appendChild(subcategoryOption);
	    }
	}
}

function setCategoriesProductToUpdate(productPropertiesToUpdate){
	var modalProductCategoryProductToUpdate=document.getElementById("modal-product-category-product-to-update");
	for(var i in productPropertiesToUpdate.categorias) {
	    if (productPropertiesToUpdate.categorias.hasOwnProperty(i)) {
			var categoryOption=document.createElement("option");
			categoryOption.setAttribute("value",i);
			var categoryTexto = document.createTextNode('Categoria: ' + productPropertiesToUpdate.categorias[i]);
			categoryOption.appendChild(categoryTexto);
			modalProductCategoryProductToUpdate.appendChild(categoryOption);
	    }
	}
}

function setImagesProductToUpdate(productPropertiesToUpdate){
	var existingProductImagesWrapper = document.getElementById("existing-product-images-wrapper");
    removeAllChildNodes(existingProductImagesWrapper);
	for(var i in productPropertiesToUpdate.productoImagenes) {
		if (productPropertiesToUpdate.productoImagenes.hasOwnProperty(i)) {
			var layerWrapperFirst = document.createElement('div');
		    layerWrapperFirst.className= 'input-group-prepend w-100';
		    var layerFirstChild = document.createElement('div');
		    layerFirstChild.className = 'input-group-text';
		    var radioButton = document.createElement('input');
		    radioButton.type = 'radio';
		    radioButton.value = i;
		    radioButton.setAttribute("onclick", "isAproductImageToRemove(this);");
		    layerFirstChild.appendChild(radioButton);
		    layerWrapperFirst.appendChild(layerFirstChild);
		    var layerSecondChild = document.createElement('div');
		    layerSecondChild.className = 'card-body';
		    var productImage = document.createElement('img');
		    productImage.src =productPropertiesToUpdate.productoImagenes[i];
		    productImage.width = '150';
			productImage.height = '150';
		    productImage.className='img-thumbnail';
		    layerSecondChild.appendChild(productImage);
		    layerWrapperFirst.appendChild(layerSecondChild);
		    existingProductImagesWrapper.appendChild(layerWrapperFirst);
		}
	}
	enableRadioButtonsBehavior();	
}

function imageProductToUpdateEvent(evt) {
      var files = evt.target.files; 
      var outputImageToProductUpdate = document.getElementById("output-image-to-product-update");
      removeAllChildNodes(outputImageToProductUpdate);
 
      for (var i = 0, f; f = files[i]; i++) {
        //Solo admitimos im??genes.
        if (!f.type.match('image.*')) {
            continue;
        }
 
        var reader = new FileReader();
 
        reader.onload = (function(theFile) {
            return function(e) {
              // Insertamos la imagen
	            //document.getElementById("output-image-to-product-update").innerHTML = ['<img width="30%" height="30%" class="rounded mx-auto d-block thumb" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
	            var productUploadImg = document.createElement('img')
				productUploadImg.src = `${e.target.result}`;
				productUploadImg.width = '200';
				productUploadImg.height = '200';
				//productHeaderImg.alt = "Product Image";
				productUploadImg.className= 'rounded mx-auto d-inline thumb img-thumbnail mx-sm-2 my-sm-4';
				outputImageToProductUpdate.appendChild(productUploadImg);
            };
        })(f);
 
        reader.readAsDataURL(f);
      }
}

document.getElementById('image-to-product-update').addEventListener('change', imageProductToUpdateEvent, false);

function enableRadioButtonsBehavior(){
	let radios = document.querySelectorAll("[type='radio']");
   radios.forEach((x)=>{
     x.dataset.val = x.checked; 
     x.addEventListener('click',(e)=>{
       let element = e.target;
       if(element.dataset.val == 'false'){
         element.dataset.val = 'true';
         element.checked = true;
       }else{
         element.dataset.val = 'false';
         element.checked = false;
       }
     },true);
   });
}

function isAproductImageToRemove(productImageRadioButton){
	//alert('The value is ' + productImageRadioButton.value + ' and ' + productImageRadioButton.getAttribute('data-val'));
}
 
    
    
(function ($) {
})(jQuery)