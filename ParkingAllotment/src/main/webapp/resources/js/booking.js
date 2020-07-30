function setDateTime() {
    let dateTime = new Date();
    let arrivalDate = document.getElementById('ArrivalDate');
    let arrivalTime = document.getElementById('ArrivalTime');

    let departureDate = document.getElementById('DepartureDate');
    let departureTime = document.getElementById('DepartureTime');
    if(arrivalDate === null || departureDate === null){
        return;
    }
    
	// Set date options
    for(let i = 0; i < 7; i++) {
        let a = createOption(dateTime.getDate()+i, dateTime.getMonth()+1, dateTime.getFullYear());
        let b = createOption(dateTime.getDate()+i, dateTime.getMonth()+1, dateTime.getFullYear());
        arrivalDate.appendChild(a);
        departureDate.appendChild(b);
    }
	
	// set time options
    let startHour = dateTime.getHours();
    let startMin = dateTime.getMinutes();

    if(startMin < 30) startMin = 30;
    else {
        startMin = 0;
        startHour +=1;
    }
    const firstTime = createOptionTime(startHour, startMin);
    arrivalTime.appendChild(firstTime);
    
    if(startMin === 30) {
    	startMin = 0;
    	startHour += 1;
    } else {
    	startMin = 30;
    }
    var a, b;

    for(let i = 0; i < 23; i++) {
        while(startMin <= 30) {
            a = createOptionTime(startHour, startMin);
            b = createOptionTime(startHour, startMin);
            if(a !== null)
            arrivalTime.appendChild(a);
            if(b !== null)
            departureTime.appendChild(b);
            startMin+=30;
        }
        startHour += 1;
        startMin = 0;
        
    }
    
    arrivalTime.removeChild(a);

}
// For Creating Time options
function createOptionTime(hour, min) {
	let v = "";
    let element = document.createElement('option');
    if(hour > 24) {
        hour-=24;
    } else if(hour === 24 && min > 0) {
        return null;
    }
    if(hour < 10) {
    	v += '0';
    }
    v += hour + "-" + min;
    
    if(min === 0){
     	v += '0';
     }
     //console.log(element);
     element.option = v;
     element.innerHTML = v;
    return element;
}
// For creating Date options
function createOption(date, month, year) {
    let v = "";
    let element = document.createElement('option');
    if(date !== null && month!==undefined) {
        if(date > 30) {
            date -= 30;
            month += 1;
        }
        v += date+"-";
        element.innerHTML = date;
        if(month !== null && month!==undefined) {
            if(month > 12) {
                month -= 12;
                year += 1;
            }
            element.innerHTML += "-" + month;
            v += month+"-";
        }
        if(year !== null && year!==undefined) {
            element.innerHTML += "-"+ year;
            v+=year;
        }
        element.value = v;
    
    }
    
    
    return element;
}
document.addEventListener('DOMContentLoaded', setDateTime);