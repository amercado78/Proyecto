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
	console.log(productImagesJson);
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
    
(function ($) {
})(jQuery)