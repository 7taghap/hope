<%@ include file="/taglibs.jsp"%>
<div id="dtlform"style="display:inline">
<form:form commandName="productDtl" method="post" action="addItem" id="productDtlForm">
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
			<input type="submit"  value = "Add" id ="addProductDtl">
			</td>
		</tr>
	</table>
	
</form:form>
</div>