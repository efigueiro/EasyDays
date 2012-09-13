/**
 * use this function to delete records.
 */
function deleteRecord() {
	if (confirm("You really want to delete this record?"))
		return true;
	else
		return false;
}

function deleteCredentialById(credentialId) {

	var url;

	if (confirm('Do you want delete this record?')) {
		url = "/EasyDays/deleteCredential?credentialId=" + credentialId;
	} else
		url = "#";

	window.location = url;
	form.method = get;
	form.submit();
}
