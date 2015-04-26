
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
		"fnDrawCallback" : function(oSettings) {
			//if row contains less than 11 items disable pagination bar
			if ($('#dataTables-example tr').length < 11) {
				$('.dataTables_paginate').hide();
			}
		}
	});
}