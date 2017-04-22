var myLibrary = angular.module('myLibrary',['ngRoute']);

myLibrary.controller('BookController', function ($scope,$http, $location, $routeParams){
	
	$scope.getBooks = function () {
		$http.get('api/books')
				.success(function(data){
					$scope.books = data;
					$scope.successMessage='Everything OK';
					
				})
			    .error(function(){
			    	$scope.errorMessage='Oops, something went wrong.';
			    });
		
	};
	
	$scope.deleteBook = function (id, index){
		$http.delete('api/books/'+id)
			.success(function(){
				$scope.books.splice(index,1);
			}).error(function(){
				$scope.errorMessage = 'Oops, can not delete book!';
			});
		
	};
	
	
	
	$scope.initBook = function(){	
		$scope.book ={};
		
		if($routeParams && $routeParams.id){
			$http.get('api/books/'+$routeParams.id)
					.success(function(data){
						$scope.book = data;
					}).error(function(){
						$scope.errorMessage='Oops, something went wrong on save page';
					})
			
		}
	};
	
	$scope.saveBook = function (){
		if($scope.book.id){
			$http.put('api/books/'+ $scope.book.id, $scope.book)
				.success(function(){
					$location.path('/books');
					
				}).error(function(){
					$scope.errorMessage='Oops, something went wrong on save page1';
				});
			
		} else {
			$http.post('api/books', $scope.book)
				.success(function(){
					$location.path('/books');
				}).error (function(){
					$scope.errorMessage='Oops, something went wrong on save page2';
					
				});
			
		}
	}
	
	
});


myLibrary.config(['$routeProvider', function ($routeProvider){
	$routeProvider
		
		.when('/', {
			templateUrl: 'static/html/home.html'
		})
		.when('/books',{
			templateUrl: 'static/html/books.html',
			controller: 'BookController'
			
		})
		.when('/books/add',{
			templateUrl: 'static/html/addEditBook.html',
			controller: 'BookController'
		})
		.when ('/books/edit/:id',{
			templateUrl: 'static/html/addEditBook.html',
			controller: 'BookController'
		})
		
		.otherwise({
			redirectTo: '/'
		});
	
	
}]);