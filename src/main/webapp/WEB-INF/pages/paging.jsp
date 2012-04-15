<%@ include file="/taglibs.jsp"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<%-- // use our pagedListHolder --%>
<jsp:useBean id="pagedListHolder" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
<c:url value="list.html" var="pagedLink">
	<c:param name="p" value="~" />
</c:url>

<%-- // load our paging tag, pass pagedListHolder and the link --%>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />

<%-- // show only current page worth of data --%>
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
		<c:forEach items="${pagedListHolder.pageList}" var="item">

			<tr>

				<td><c:out value="${item.productDtlId}" /></td>
				<td><i><c:out
							value="${item.product.productName } ${item.productDtlName}" /></i></td>
				<td><i><c:out value="${item.price}" /></i></td>
				<td><i><c:out value="${item.qtyOnHand}" /></i></td>
			</tr>
	</tbody>
	</c:forEach>
</table>

<%-- // load our paging tag, pass pagedListHolder and the link --%>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />