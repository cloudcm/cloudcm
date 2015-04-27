
function markUnmarkItem(checkbox) {
	$(function() {
		$.post($('#markUserListItemUrl').val(), {
			userListItemId : $(checkbox).val(),
			marked : $(checkbox).is(':checked')
		},

		function(data) {

		});
	});
}

function showDataTable() {
	$('table.listDataTable').dataTable({
		"oLanguage": {
			"sEmptyTable": "No item in shopping list"
	    },
		
		"fnDrawCallback" : function(oSettings) {
			//if row contains less than 11 items disable pagination bar
			if (oSettings.fnRecordsTotal() < 11) {
				$('.dataTables_paginate').hide();
			}else {
		        $('.dataTables_paginate').show(); 
		    }
		}
	});
}