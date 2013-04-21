$(function() {
	oTable = $('#table').dataTable({
//		  "aoColumns": [{ "bSortable": false },
//		                null,
//		                null,
//		                null,
//		                null
//		                ]
		"bSort": false
		              });

	$('#search').on('click', function() {
		// alert($('#keyword').val());

		// url:"${request.contextPath}/book/ajaxFindBooksByTopic",
		$.ajax({
			url : "article/searchAjax",
			dataType : "json",
			data : {
				param : $('#keyword').val()
			},
			success : function(data) {
				// var oTable = $('#table').dataTable( {
				// "bProcessing": true,
				// "sAjaxSource": data
				// } );
				doRefresh(data.aaData)
			}
		});
	});
	
	
	$("#keyword").keyup(function() {
		console.log($("#keyword").val());
		$.ajax({
			url:"article/searchAjax",
			 dataType: "json",
			data: {
				param: $('#keyword').val()
			},
			success: function(data) {
				doRefresh(data.aaData)
			}

		});
	});
	
	
	
	

	function doRefresh(data) {
		// Get the aaData object from the JSON response
		oTable.fnClearTable();
		if (data.length)
	    oTable.fnAddData(data);
		console.log(data);
		oTable.fnDraw();
	}

});
