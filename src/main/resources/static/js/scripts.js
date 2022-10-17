// Function to calculate shipping cost
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
}


// function to format date type of 'dob' field
function formatDate() {
	
	let currentFormatDate = document.getElementById("dob").value;
	let newDay = currentFormatDate.getDate().toString();
	let newMonth = (currentFormatDate.getMonth() + 1).toString();
	let newYear = currentFormatDate.getFullYear().toString();
	let newDateString = newYear + "-" + "0" + newMonth + "-" + newDay;
	return newDateString;	
}