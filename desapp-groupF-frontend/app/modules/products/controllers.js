'use strict';
 
angular.module('Products')
 
.controller('ProductsController',
    ['$scope',
    function ($scope) {
$scope.products = [{
"id" : "1",
"image" : "https://www.viejacantina.com/media/catalog/product/cache/1/image/100x/17f82f742ffe127f42dca9de82fb58b1/c/e/cerveza-corona-355-ml.jpg",
"brand" : "Corona",
"name" : "Cerveza x 355cc",
"price" : "$45"
},
					   {
"id" : "2",
"image" : "https://www.vegaffinity.com/imagenes/alimentos/pringlesoriginal.png",
"brand" : "Pringles",
"name" : "Papas Fritas",
"price" : "$50"
},
					    {
"id" : "3",
"image" : "http://jumbo.vteximg.com.br/arquivos/ids/161514-100-100/1582126.jpg",
"brand" : "ALoLoco",
"name" : "Mani x 500 gr.",
"price" : "$25"
},
{
"id" : "4",
"image" : "http://jumbo.vteximg.com.br/arquivos/ids/169721-100-100/705256-KG.jpg",
"brand" : "Bocatti",
"name" : "Jamón cocido x 100 gr.",
"price" : "$40"
},
{
"id" : "5",
"image" : "http://walmartar.vteximg.com.br/arquivos/ids/780751-100-100/0779095000019-1.jpg",
"brand" : "Gancia",
"name" : "Aperitivo Gancia x 1L",
"price" : "$80"
},
{
"id" : "6",
"image" : "http://jumbo.vteximg.com.br/arquivos/ids/159435-100-100/263427.jpg",
"brand" : "Sprite",
"name" : "Gaseosa Sprite x 2.25L",
"price" : "$22"
},
{
"id" : "7",
"image" : "http://www.saltandmore.org/wp-content/uploads/bfi_thumb/limon21-ms29pmueb3yrt8fapfez6bl43n0fmp3oua9dkdjg14.jpg",
"brand" : "Limón",
"name" : "Limón x Kg",
"price" : "$15"
}, 
{
"id" : "8",
"image" : "http://proveedoradiez.com.mx/1233-small_default/vaso-de-polipropileno-1200p.jpg",
"brand" : "Habitissimo",
"name" : "Vaso(c/u)",
"price" : "$15"
}];
    }]);