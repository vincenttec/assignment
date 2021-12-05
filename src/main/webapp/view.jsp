<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*"%>
   <%@ page import="java.util.Base64"%>
<% Class.forName("com.mysql.cj.jdbc.Driver");
 String dburl="jdbc:mysql://localhost:3306/gym";
 String dbuser="root";
 String dbpassword="";
Connection connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
        Statement statement = connection.createStatement() ;
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<meta charset="ISO-8859-1">
<title>Gym Fitness </title>

     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="description" content="">
     <meta name="keywords" content="">
     <meta name="author" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

     <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">
     <link rel="stylesheet" href="css/aos.css">

     <!-- MAIN CSS -->
     <link rel="stylesheet" href="css/tooplate-gymso-style.css">
<!--

https://www.tooplate.com/view/2119-gymso-fitness
-->
</head>
<body data-spy="scroll" data-target="#navbarNav" data-offset="50">

    <!-- MENU BAR -->
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container">

            <a class="navbar-brand" href="index.html">ADMIN Page</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-lg-auto">
                  

               

                    <li class="nav-item">
                   
                     <a href="view.jsp" class="nav-link smoothScroll">Registed User</a>
                    </li>

                    <li class="nav-item">
                        <a href="viewcomment.jsp" class="nav-link smoothScroll">view comment</a>
                    </li>
                    
                     <li class="nav-item">
                        <a href="createdaccount.jsp" class="nav-link smoothScroll">view CreatedAccount</a>
                    </li>
                   
                    
                    
                       <li class="nav-item">
                        <a href="register.jsp" class="nav-link smoothScroll">Register</a>
                    </li>
                    
                      <li class="nav-item">

                  <form action="Logout1" method="post">
                  
                  <input type="submit" value="logout">
                  
                  </form>

                    </li>
                    
                    
                  
                </ul>

                <ul class="social-icon ml-lg-3">
                    <li><a href="#" class="fa fa-facebook"></a></li>
                    <li><a href="#" class="fa fa-twitter"></a></li>
                    <li><a href="#" class="fa fa-instagram"></a></li>
                </ul>
            </div>

        </div>
    </nav>


     <!-- HERO -->



     <section class="feature" id="feature">
        <div class="container">
            <div class="row">

                
             
                </div>

            </div>
        </div>
    </section>


     <!-- ABOUT -->
     <section class="about section" id="about">
               <div class="container">
                    <div class="row">

                       
                            <div class="ml-lg-auto col-lg-3 col-md-6 col-12" data-aos="fade-up" data-aos-delay="700">
                            
                                </div>
                            </div>

                            <div class="mr-lg-auto mt-5 mt-lg-0 mt-md-0 col-lg-3 col-md-6 col-12" data-aos="fade-up" data-aos-delay="800">
                                <div class="team-thumb">

                                 
                                </div>
                            </div>

                    </div>
               </div>
     </section>
<h7 style="color:red ">Registered user information</h7>
 <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Birthday</th>
                  <th>Gender</th>
                  <th>Email</th>
                   <th>Password</th>
                  
                  <th>P_number</th>
                    <th>Photo</th>
                  
                  <th>COURSE</th>
                 <th>ACTION</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                <%
                  try {
            /*     Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","");
                 */
                
                ResultSet rs = statement.executeQuery("SELECT * FROM `registration`") ;
         	   while(rs.next()){
         		   Blob blob = rs.getBlob("photo");
         		   
         		   InputStream inputStream = blob.getBinaryStream();
         		   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         		   byte[] buffer = new byte[4096];
         		   int bytesRead = -1;
         		    
         		   while ((bytesRead = inputStream.read(buffer)) != -1) {
         		       outputStream.write(buffer, 0, bytesRead);
         		   }
         		    
         		   byte[] imageBytes = outputStream.toByteArray();
         		    
         		   String base64Image = Base64.getEncoder().encodeToString(imageBytes);
         		    
         		   inputStream.close();
         		   outputStream.close();
                            %>
                
                
                
                
               
              
                <tr>
               <td><%=rs.getInt("id") %></td>
                <td><%=rs.getString("F_name") %></td>
                         <td><%=rs.getString("L_name") %></td>
                         <td><%=rs.getString("Birthdates") %></td>
                         <td><%=rs.getString("Gender") %></td>
                         <td><%=rs.getString("email") %></td>
                          <td><%=rs.getString("password") %></td>
                         
                       <td><%=rs.getInt("phone") %></td>
                                              <td>  <img src="data:image/jpg;base64,<%=base64Image%>" width="100" height="140" /></td>
                       
                          <td><%=rs.getString("subject") %></td>
                           <td><a href="updateregister.jsp?id=<%=rs.getString(1)  %>"><button type="button" class="btn btn-success" value="update">UPDATE</button></a>
                   <a href="Deleteregistered?id=<%=rs.getString(1)  %>">   &nbsp;&nbsp;<button type="button" class="btn btn-primary" value="delete">DELETE</button></a>
                  </td>
                          
                          </tr>
                         
                         <td></td>
                <%
                
                  }}
                catch(Exception ex){
                out.println("Exception:"+ex.getMessage());
                ex.printStackTrace();
                }
                   %>
                 
                </tr>
               
              </tbody>
            </table>

     
          <!-- FOOTER -->
     <footer class="site-footer">
          <div class="container">
               <div class="row">

                    <div class="ml-auto col-lg-4 col-md-5">
                        <p class="copyright-text">Copyright &copy; 2021 group 5 assignment.
                        
                        <br></p>
                    </div>

                    <div class="d-flex justify-content-center mx-auto col-lg-5 col-md-7 col-12">
                        <p class="mr-4">
                            <i class="fa fa-envelope-o mr-1"></i>
                            <a href="#">vincenttec@gmail.com</a>
                        </p>

                        <p><i class="fa fa-phone mr-1"></i> 0788889355</p>
                    </div>
                    
               </div>
          </div>
     </footer>

    <!-- Modal -->
    <div class="modal fade" id="membershipForm" tabindex="-1" role="dialog" aria-labelledby="membershipFormLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">

        <div class="modal-content">
          <div class="modal-header">

            <h2 class="modal-title" id="membershipFormLabel">Membership Logintt</h2>

            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>

          <div class="modal-body">
 
          </div>

          <div class="modal-footer"></div>

        </div>
      </div>
    </div>

     <!-- SCRIPTS -->
     <script src="js/jquery.min.js"></script>
     <script src="js/bootstrap.min.js"></script>
     <script src="js/aos.js"></script>
     <script src="js/smoothscroll.js"></script>
     <script src="js/custom.js"></script>


</body>
</html>