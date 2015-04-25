
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