<%@ include file="/taglibs.jsp"%>

<h1 style="">
	<fmt:message key="product.heading" />
</h1>
<div id ="searchbox">
	<label> Search</label>
	<input type="text" size="30" name="qsearch" id="qsearch"/>
</div>
<table id="box-table" summary="Product List">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Product Name</th>
			<th scope="col">Price</th>
			<th scope="col">Qty on Hand</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${model.products}" var="prod">

			<tr>

				<td><c:out
						value="${prod.productDtlId}" /></td>
				<td><i><c:out
							value="${prod.product.productName } ${prod.productDtlName}" /></i></td>
				<td><i><c:out
							value="${prod.price}" /></i></td>
				<td><i><c:out
							value="${prod.qtyOnHand}" /></i></td>
			</tr>


		</c:forEach>

	</tbody>
</table>









