<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Home</a>
  <a class="navbar-brand" href="todos">Todos</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
	<%
      	if(session.getAttribute("userState")==null)
      	{
	%>
      		<li class="nav-item active text-primary">
	        	<a class="nav-link" href="login">Login<span class="sr-only">(current)</span></a>
	      	</li>
	      	<li class="nav-item active text-primary">
	        	<a class="nav-link" href="register">Sign Up</a>
	      	</li>
	<%
      	}
      	else
      	{
      		
	%>
			<li class="nav-item active text-primary">
		        <a class="nav-link" href="#">Welcome<span class="sr-only">(current)</span></a>
		    </li>
		    <li class="nav-item active text-primary">
		        <a class="nav-link" href="Logout">Logout</a>
		    </li>
    <%
      	}
    %>
      
    </ul>
    
  </div>
</nav>