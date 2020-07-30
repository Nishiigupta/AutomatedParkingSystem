const query = "store";

function GetMap() {
    // Putting the map
    var map = new Microsoft.Maps.Map('#myMap', {
        credentials: 'AujIAAocQnuvL77mwdqTzanxUH9R8Op7dNc3b_GVo8MxeKY0V7xrjLaLfOHH8gK7',

    });

    Microsoft.Maps.loadModule('Microsoft.Maps.AutoSuggest', function () {
        var options = {
            maxResults: 8,
            map: map
        };
        var manager = new Microsoft.Maps.AutosuggestManager(options);
        
        manager.attachAutosuggest('#EnterLocation','#EnterLocationContainer', selectedSuggestion);
    });

    function selectedSuggestion(suggestionResult) {
        map.entities.clear();
        map.setView({ bounds: suggestionResult.bestView });
        var pushpin = new Microsoft.Maps.Pushpin(suggestionResult.location, {
        	color: 'red'
        });
        map.entities.push(pushpin);
        // document.getElementById('printoutPanel').innerHTML =
        //     'Suggestion: ' + suggestionResult.formattedSuggestion +
        //         '<br> Lat: ' + suggestionResult.location.latitude +
        //         '<br> Lon: ' + suggestionResult.location.longitude;
        
        var lat = suggestionResult.location.latitude;
        var lng = suggestionResult.location.longitude;
        console.log(lat);
        console.log(lng);
        const url = "https://dev.virtualearth.net/REST/v1/LocalSearch/?query="+query+"&userLocation="+lat+","+lng+"&key=AujIAAocQnuvL77mwdqTzanxUH9R8Op7dNc3b_GVo8MxeKY0V7xrjLaLfOHH8gK7";

        // Fetching nearby location and placing it on the maps
        fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            let d = data.resourceSets[0].resources;
            d.forEach(element => {
                const title = element.name;
                const cords = element.geocodePoints[0].coordinates;
                console.log(cords);
                var points = new Microsoft.Maps.Location(cords[0], cords[1]);
                var pin = new Microsoft.Maps.Pushpin(points, {
                    title: title,
                    subTitle: 'Parking',
                    text: '1'
                });
                map.entities.push(pin);
                
                Microsoft.Maps.Events.addHandler(pin, 'mouseover', function (e) {
                    e.target.setOptions({ color: 'lightblue' });
                });
            
                Microsoft.Maps.Events.addHandler(pin, 'mouseout', function (e) {
                    e.target.setOptions({ color: 'purple' });
                });
                
                Microsoft.Maps.Events.addHandler(pin, 'click', function (e) {
                    let EnterLocation = document.getElementById('EnterLocation');
                    EnterLocation.value = element.name + " Parking [ ";
                    EnterLocation.value += element.Address.addressLine + " ] [" + element.Address.countryRegion + "]";
                    e.target.setOptions({color: 'yellow'});
                    let selectedParkingCords = document.getElementById('SelectedParkingCords');
                    selectedParkingCords.value = element.geocodePoints[0].coordinates;
                    console.log(element.Address.addressLine);
                    console.log(element.Address.countryRegion);
                });
                
            });
        })
    }
        
}

document.addEventListener('DOMContentLoaded', ()=> {
	document.querySelector('.navbar-brand').href = "#";
	document.getElementById('homeNavLink').href = "#";
});