<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11-Oct-20
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
</head>
<body>

<div class="container">

    <div class="row justify-content-center">

        <div class=" col-md-8 pb-5">
            <form:form method="post" modelAttribute="information"
                       name="information" action="/poststatus">
            <div class="card border-primary rounded-0">
                <div class="card-header p-0">
                    <div class="bg-info text-white text-center py-2">
                        <h3><i class="fa fa-envelope"></i> Post Your Status</h3>

                    </div>
                </div>
                <div class="card-body p-3">

                    <!--Body-->
                    <div class="form-group ">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="Status"> Status:</label>
                                <form:textarea class="form-control" rows="2" id="comment" path="status" ></form:textarea>
                                <div id="errLast"></div>
                            </div>
                        </div>
                        <div class="form-group ">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="Status"> Choose Privacy:</label>

                                    <form:radiobutton  path ="privacyType" value="Public"  id="radio" label= "public" />
                                    <label style="margin-right:40px;">

                                        <form:radiobutton path = "privacyType" value="Private" id="radio" label= "private"/>

                                    </label>
                                </div>
                            </div>

                            <div class="form-group ">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="checkInPlace">Check In</label>
                                        <form:select path="checkInPlace" id="mySelect"  onchange="myFunc()"  class="form-control">
                                            <form:option value=" ">Please Select</form:option>
                                            <form:options items="${locationList}" ></form:options>
                                        </form:select>
                                    </div>
                                </div>

                                <div class="text-center">
                                    <input type="submit" value="Post" class="btn btn-info btn-block rounded-0 py-2">
                                </div>
                            </div>


                            </form:form>
                        </div>
                        <!--Form with header-->


                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="col-md-12">
    <c:forEach var="boo" items="${listProfile}">
        <div class="row">
                <div class="panel panel-default">

                    <div class="panel-body">
                        <div class="col-md-4 ">
                        <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1"  style="width:30%; " class="img-circle img-responsive">
                        </div>
                            <div class="col-md-8 ">

                                    <h2>${boo.status}</h2>


                                </div>

                    </div>

                        </div>
                    </div>


            </c:forEach>


</body>
</html>
