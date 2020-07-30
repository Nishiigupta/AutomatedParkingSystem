<nav class="navbar navbar-expand-sm sticky-top navbar-dark bg-dark">
  <!-- Navbar content -->
  <a href="index.jsp" class="navbar-brand">E-Parking</a>
  <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarMenu">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarMenu">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a href="index.jsp" id="homeNavLink" class="nav-link text-white">Home</a>
      </li>
      <li class="nav-item">
		<% if(session.getAttribute("user") != null) { %>
			<a href="logout" class="nav-link text-white">LogOut</a>
		<% } else { %>
			<a href="login.jsp" class="nav-link text-white">Sign In</a>
		<% } %>
      </li>
    </ul>
  </div>
</nav>
© 2020 GitH