<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<style>
    .error {
        color: red;
    }
</style>

<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>Edit Product</h1>
            <p class="lead">Fill the below information to Update a product:</p>
            <br>
            <label>Verify that any * field is required</label>
        </div>

        <form:form method="post" action="${pageContext.request.contextPath}/admin/update/updateProduct"
                   modelAttribute="product" enctype="multipart/form-data">

            <form:hidden path="productID" value="${product.productID}"/>

        <div class="form-group">
            <label for="name">Name (*)</label>
            <form:input path="productName" id="name" cssClass="form-control"/>
            <form:errors path="productName" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="instrument"/> Instrument </label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="record"/> Record </label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="accessory"/> Accessory </label>
        </div>
        <br>
        <div class="form-group">
            <label for="description">Description (*)</label>
            <form:textarea path="productDescription" id="description" cssClass="form-control"/>
            <form:errors path="productDescription" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label for="price">Price (*)</label>
            <form:input path="productPrice" id="price" cssClass="form-control"/>
            <form:errors path="productPrice" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"> <form:radiobutton path="productCondition" value="New" id="condition"/>
                New</label>
            <label class="checkbox-inline"> <form:radiobutton path="productCondition" value="Used" id="condition"/>
                Used</label>
        </div>
        <br>
        <div class="form-group">
            <label for="unitInStock">Unit In Stock (*)</label>
            <form:input path="unitInStock" id="unitInStock" cssClass="form-control"/>
            <form:errors path="unitInStock" cssClass="error"/>
        </div>
        <br>

        <div class="form-group">
            <label for="status">Condition</label>
            <label class="checkbox-inline"> <form:radiobutton path="productStatus" value="active" id="status"/>
                Active</label>
            <label class="checkbox-inline"> <form:radiobutton path="productStatus" value="inactive" id="status"/>
                Inactive</label>
        </div>
        <br>
        <div class="form-group">
            <label for="manufacturer">Manufacturer (*)</label>
            <form:input path="productManufacturer" id="manufacturer" cssClass="form-control"/>
            <form:errors path="productManufacturer" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label class="control-label" for="image">Upload Image</label>
            <input id="image" type="file" name="file" Class="input-lg" accept="image/*"/>
        </div>

        <br><br>

        <input type="submit" value="Submit" class="btn btn-primary mb-2">&#8287;&#8287;&#8287;&#8287;&#8287;&#8287;
        <a href="${pageContext.request.contextPath}/admin/productInventory" class="btn btn-danger">Cancel</a>
        <hr>
        </form:form>


<%@ include file="/WEB-INF/views/templates/footer.jsp" %>