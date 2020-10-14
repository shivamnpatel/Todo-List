<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Home</a>
  <a class="navbar-brand" href="todos">Todos</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
	<c:if test="${sessionScope.userEmail == null}">
			
		    	<li class="nav-item active text-primary">
		        	<a class="nav-link" href="login">Sign In</a>
		    	</li> 
		    	     
		    	<li class="nav-item active text-primary">
		        	<a class="nav-link" href="register">Sign Up</a>
		    	</li>      
	
			</c:if>  
			   
			<c:if test="${sessionScope.userEmail != null}">
			
				<li class="nav-item active text-primary">
		        	<a class="nav-link" href="#">${sessionScope.userEmail}<span class="sr-only">(current)</span></a>
		   		</li>      
		    
		    	<li class="nav-item active text-primary">
		        	<a class="nav-link" href="Logout">Logout</a>
		    	</li>
			
			</c:if> 
      
    </ul>
    
  </div>
</nav>