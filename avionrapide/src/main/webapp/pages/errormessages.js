
function validateFlightDetails() {
	var oac = flightDetailsForm.oac.value.trim();
	var oc = flightDetailsForm.oc.value.trim();
	var os = flightDetailsForm.os.value.trim();
	var oz = flightDetailsForm.oz.value.trim();
	var dac = flightDetailsForm.dac.value.trim();
	var dc = flightDetailsForm.dc.value.trim();
	var ds = flightDetailsForm.ds.value.trim();
	var dz = flightDetailsForm.dz.value.trim();
	var dd = flightDetailsForm.dd.value.trim();
	var rd = flightDetailsForm.rd.value.trim();
	var not = flightDetailsForm.not.value.trim();
	var bool = true;
	
	document.getElementById('numOfTravelersError').hidden = true;
	document.getElementById('departingDateError').hidden = true;
	document.getElementById('returningDateError').hidden = true;
	document.getElementById('originAirportError').hidden = true;
	document.getElementById('destinationAirportError').hidden = true;

	if (not == "") {	//number of travelers field
		document.getElementById('numOfTravelersError').hidden = false;
		bool = false;
	}
	if (dd == "") {
		document.getElementById('departingDateError').hidden = false;
		bool = false;

	}
	if (rd == "") {
		document.getElementById('returningDateError').hidden = false;
		bool = false;

	}

	if (oac == "" && dac != "") {
		document.getElementById('originAirportError').hidden = false;
		bool = false;

	}
	else if (dac == "" && oac != "") {
		document.getElementById('destinationAirportError').hidden = false;
		bool = false;

	}
	else {	//if none of the codes are filled out

	}

	return bool;
}