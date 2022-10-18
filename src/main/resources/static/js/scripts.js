/*// Function to calculate shipping cost
function calculateShippingCost() {
    
    // determine a route based on two stations ('from' and 'to')
    
    let rate;
    
    // weight
    let weight = document.getElementById("weight").value;

    // check the type of a cargo
    let cargoType = document.getElementById("cargotype").value;
    let cargoIndex = 1;
    if (cargoType === "hazard") {
        cargoIndex = 2;
    }

    // check the type of a shipment
    let shipmentType = document.getElementById("shipmenttype").value;
    let shipmentIndex = 1;
    if (shipmentType === "express") {
        shipmentIndex = 2;
    }

    // calculate the total price of a shipping
    document.getElementById("price").innerHTML = "Total  $ " + (weight * cargoIndex * shipmentIndex);
}*/


// function to format date type of 'dob' field
function formatDate() {
	
	let currentFormatDate = document.getElementById("dob").value;
	let newDay = currentFormatDate.getDate().toString();
	let newMonth = (currentFormatDate.getMonth() + 1).toString();
	let newYear = currentFormatDate.getFullYear().toString();
	let newDate = newYear + "-" + "0" + newMonth + "-" + newDay;
	document.getElementById("dob").innerHTML = newDate;
	//return newDateString;
}
	
	
function checkZipCode() {
	
	const zipCodes = ["02113", "02210"];
	let userZipCode = document.getElementById("zipcode").value;
	for (zipCode in zipCodes) {
		if (zipCode == userZipCode) {
			document.getElementById("zipcode").innerHTML = zipCode;
			break;
		} else {
			document.getElementById("zipcode").innerHTML = "Please enter a valid ZIP Code"
		}
	}
}
