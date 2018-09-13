<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Autocomplete - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC",
				"C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang",
				"Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp",
				"Perl", "PHP", "Python", "Ruby", "Scala", "Scheme" ];
		$("#tags").autocomplete({
			source : availableTags
		});
	});
	
	 $(document).ready(function() {
			$("#dependenciaEmisor")
					.autocomplete(
							{
								source : '${pageContext.request.contextPath }/dependencia/search'
							});
		});
	 
	$(document).ready(function() {

		$('#w-input-search').autocomplete({
			serviceUrl: '${pageContext.request.contextPath }/dependencia/search',
			paramName: "tagName",
			delimiter: ",",
		    transformResult: function(response) {
		    	
		        return {
		        	
		            suggestions: $.map($.parseJSON(response), function(item) {
		            	
		                return { value: item.tagName, data: item.nombre };
		            })
		            
		        };
		        
		    }
		    
		});
		
		
	});
	
	
	$(document).ready(function() {
	     $(function() {
	         $("#search").autocomplete({     
	             source : function(request, response) {
	               $.ajax({
	                    url : '${pageContext.request.contextPath }/dependencia/search',
	                    type : "GET",
	                    data : {
	                           term : request.term
	                    },
	                    dataType : "json",
	                    success : function(data) {
	                          response(data);
	                    }
	             });
	          }
	      });
	   });
	});
</script>
</head>
<body>

	<div class="ui-widget">
		<label for="tags">Tags: </label> <input id="search">
	</div>


</body>
</html>