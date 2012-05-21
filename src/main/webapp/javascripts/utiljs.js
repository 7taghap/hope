/** needs jquery plugin **/


/** clear the form **/
$.fn.clearForm = function() {
  return this.each(function() {
    var type = this.type, tag = this.tagName.toLowerCase();
    if (tag == 'form')
      return $(':input',this).clearForm();
    if (type == 'text' || type == 'password' || tag == 'textarea')
      this.value = '';
    else if (type == 'checkbox' || type == 'radio')
      this.checked = false;
    else if (tag == 'select')
      this.selectedIndex = -1;
  });
};

$.fn.clearDivInput = function () {
    $(this).find(':input').each(function() {
        switch(this.type) {
            case 'password':
            case 'select-multiple':
            case 'select-one':
            case 'text':
            case 'textarea':
                $(this).val('');
                break;
            case 'checkbox':
            case 'radio':
                this.checked = false;
        }
    });

}

$.fn.removeRow = function(index) {

	var rows = $(this).find('tbody tr').length;
	if (rows > 0) {
		$(this).find('tbody tr').eq(index).remove();
	}
	
}

$.fn.getSumOfRow = function(row) {
	var total =	0;
	$(this).find('tbody tr').each(function (i) {
	
//		var qtyOnHand = $(this).find('td').eq(row).text();
		total += parseFloat( $(this).find('td').eq(row).text());
		
	});
	return total;	
}


function removeRow(tableId, index,url) {
	if (url==null || url == undefined)
		url="deleteItem/"+index+".html";
	var rows = $("#"+tableId).find('tbody tr').length;
	if (rows > 0) {
		$.ajax({
			type:"get",
			url:url,
			success:function(data){ 
				$("#"+tableId).find('tbody tr').eq(index).remove();
				computeTotalQty();
			}
			
		});
		
	}
	return false;
	
}

$.fn.addData = function (aDataSupplied,removable) {
	
	var aDataIn = ($.isArray(aDataSupplied) ?
			aDataSupplied.slice() : $.extend( true, {}, aDataSupplied));
	var currentIdx = $("#box-table tbody tr").length;
	var tableId = this.attr("id");
	var row = "<tr>";
	  for(var x=0; x < aDataIn.length; x++ ) {
		  var data = aDataIn[x];
		  row +="<td>" + data + "</td>";
	  }			
	  if(removable) {
		  var rowId = "onclick=removeRow('"+tableId+"',"+currentIdx+");"
		  row+='<td><a href="#" class="deleteItem"'+rowId+'>X</a></td>';
	  }
	  row += "</tr>";
	 alert(row);

	  $(this).find('tbody').append(row);
	 

}

$.fn.getData = function(excludeLast) {

	var aData = new Array();
	var rows = new Array();
	$(this).find('tbody tr').each(function(idx){
		var tds = $(this).find('td').length;
		if (excludeLast)
				tds = tds - 1;

		aData = new Array();
		$(this).find('td').each(function (idx) {
			if (idx < tds) {
				aData[idx] = $(this).html();
			}
		});

		rows[idx] = aData;
		
	});

	return rows;
}

/************ input validation **************/

$.fn.NotEmpty = function () {
	var thisId = $(this).attr('id');

	if ($(this).val().length < 1) {
		$(this).addClass("error");
		return false;
	}
	else {
		$(this).removeClass("error");
		return true;
	}
	
	
}
