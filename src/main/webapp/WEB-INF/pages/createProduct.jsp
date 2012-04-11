<%@ include file="/taglibs.jsp"%>

<form:form commandName="product" method="post" action="save.html">
	<input type="hidden" name="flightId" value="${flight.id}" />
	<table class="cw-FlexTable">

		<tr>
			<td>Product Name:<font color="red"><form:errors
						path="productName" /></font></td>
			<td><form:input path="productName" /></td>
			<!-- col 2 -->
			<td>Product Category</td>
			<td><form:select path="category.categoryName">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${productCategories}" />
				</form:select></td>


		</tr>
		<tr>
			<td>Product Description</td>
			<td><form:input path="productDesc" /></td>
			<td>Default Unit</td>
			<td><form:select path="unitConversion.name">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${unitlist}" />
				</form:select></td>
		</tr>

		<tr>
			<td>Shelf<font color="red"><form:errors path="shelf" /></font></td>
			<td><form:input path="shelf" /></td>
			<td>Total Qty on hand</td>
			<td><form:input path="totalQtyOnHand" /></td>
		</tr>

	</table>
    &nbsp;
    <table id="box-table">
		<thead>
		 <input type="button" value="Add Item Details" href="#dtlform" toptions="type = dom, effect = fade, width = 800, overlayClose = 1"/>
		</thead>
		<thead>
			<tr>
				<th>Item Name</th>
				<th>Selling Qty</th>
				<th>Price</th>
				<th>Suggested Price</th>
				<th>Qty on Hand</th>
				<th>Unit</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${product.productDtls}" varStatus="idx" var="productDtl">
			<tr>
				<td><c:out value="${productDtl.productDtlName}"/></td>
				<td><c:out value="${productDtl.sellingQty}"/></td>
				<td><c:out value="${productDtl.price}"/></td>
				<td><c:out value="${productDtl.sugPrice}"/></td>
				<td><c:out value="${productDtl.qtyOnHand}"/></td>
				<td><c:out value="${productDtl.unitConversion.name}"/></td>
				<td><a href="#" class="deleteItem" onclick="removeRow('box-table',${idx.index});" > X </a>
				
			</tr>
			</c:forEach>
	
		</tbody>
	</table>
<%-- 	<form:hidden path="productDtls[1].productDtlName" value="hello world"/> --%>
	<div id="productDtlsForSubmit">
	</div>
	<input type="submit" value="Submit" />
	<input type="button" id="beforeSubmit" value="gather" />
		<input type="button" id="ajaxSubmit" value="ajax submit" />
</form:form>


<!--  product detail in hidden  -->

<div id="dtlform" style="display:none">
<form:form commandName="productDtl" method="post" action="addItemAjax.html" id="productDtlForm">
<h1> Product Detail </h1>
	<table  class="cw-FlexTable">
		<tr>
			<td>Unit Conversion</td>
			<td><form:select path="unitConversion.name" style="width:100%;">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${unitlist}" />
				</form:select></td>
		</tr>
		<tr>
			<td>Product Detail Name </td>
			<td><form:input path="productDtlName" value=""/></td>
		</tr>
		<tr>
			<td>Selling Qty</td>
			<td><form:input path="sellingQty" value=""/></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><form:input path="price" value=""/></td>
		</tr>
		<tr>
			<td>Suggested Price </td>
			<td><form:input path="sugPrice" value=""/></td>
		</tr>
		<tr>
			<td>Qty On hand</td>
			<td><form:input path="qtyOnHand" value=""/></td>
		</tr>
		
		<tr>
			<td>
			<input type="button" href="#" value = "Cancel" id="cancelProductDtl">
			<input type="button"  value = "Add" id ="addProductDtl">
			</td>
		</tr>
	</table>
	
</form:form>
</div>


<script type="text/javascript">

    
    $("#addProductDtl").click(function() {
	
		$.ajax({
			type:"post",
			url:"addItemAjax.html",
			data:$("#productDtlForm").serializeArray(),
			success:function(data) {
				var aData=new Array();
				aData[0] =data.productDtlName;
				aData[1] =data.sellingQty;
				aData[2] =data.price;
				aData[3] =data.sugPrice;
				aData[4] =data.qtyOnHand;
				aData[5] =data.unitConversion.name;
				
				$("#box-table").addData(aData,true);
				
			}
			
			});
		TopUp.overlayClose();
		return false;
	});
	$("#cancelProductDtl").click(function() {
		$('#dtlform').clearDivInput();
		TopUp.overlayClose();
	});
	
	$("#beforeSubmit").click(function(){
			var aData = $("#box-table").getData(true);
			var aDataIn = ($.isArray(aData) ?
					 aData.slice() : $.extend( true, {}, aData));
			alert(aDataIn);
			for(var i = 0; i < aDataIn.length; i++ ){
				alert(aDataIn[i]);	
				
				$("#productDtlsForSubmit").append(productDtlName);
			}
	});
	
	$("#ajaxSubmit").click(function() {
		alert("submit");
		$.ajax({
			type:"get",
			url:"addItem",
			success:function(data) {
				var $table = $('<div>'+data+'</div>');
				$("#box-table").replaceWith($table);
				
			}
			});
	});
</script>