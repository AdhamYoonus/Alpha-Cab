<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Alpha-Cab|Customer</title>
  </head>
  <body>
      <div class="container-sm">
        <a class="btn btn-primary text-dark" href="<c:url value="/home"></c:url>">Home</a>
      </div>
    <div align="center">
      <h1>Request for booking</h1>
      <form class="w-75" action="" method="POST">
        <label for="username">Username: </label><br />
        <input class="w-100" type="text" id="username" name="username" /><br />

        <label for="address">From Address: </label><br />
        <input class="w-100" id="address" name="address" /><br />

        <label for="destAddress">Destination Address: </label><br />
        <input class="w-100" id="destAddress" name="destAddress" /><br />

        <label for="dateTime">Date And Time: </label><br />
        <input class="w-100" type="datetime-local" id="dateTime" name="date" /><br /><br />
        <label>Distance: </label>
        <input type="text" id="distance" name="distance" /><br />
        <br />
        <input type="submit" class="btn btn-primary" value="Book" />

        
      </form>
      
      <div
          id="map"
          style="
            min-width: 100%;
            min-height: 400px;
            max-width: 200px;
            margin-top: 20px;
          "
        />
    </div>
    <script>
      var address = document.getElementById("address");
      var destAddress = document.getElementById("destAddress");
      var distanceEleme = document.getElementById("distance");

      const posToAddress = (loc) =>
        new Promise((resolve, reject) => {
          var geocoder = new google.maps.Geocoder();

          geocoder.geocode({ location: loc }, function (results, status) {
            if (status === "OK") {
              if (results[0]) {
                resolve(results[0].formatted_address);
              } else {
                reject("No results found");
              }
            } else {
              reject("Geocoder failed due to: " + status);
            }
          });
        });

      function initMap() {
        var map = new google.maps.Map(document.getElementById("map"), {
          zoom: 14,
          center: { lat: 4.164846975145926, lng: 73.52581474609373 },
        });

        var marker1 = new google.maps.Marker({
          position: { lat: 4.164846975145926, lng: 73.525814746093 },
          map: map,
          draggable: true,
        });

        var marker2 = new google.maps.Marker({
          position: { lat: 4.164846975145926, lng: 73.525814746093 },
          map: map,
          draggable: true,
        });

        var distance = google.maps.geometry.spherical.computeDistanceBetween(
          marker1.getPosition(),
          marker2.getPosition()
        );

        var infowindow = new google.maps.InfoWindow({
          content:
            "Distance: " +
            distance.toFixed(2) +
            " meters<br>Start: " +
            marker1.getPosition() +
            "<br>End: " +
            marker2.getPosition(),
        });

        infowindow.open(map, marker1);

        google.maps.event.addListener(marker1, "dragend", async function () {
          infowindow.close();
          distance = google.maps.geometry.spherical.computeDistanceBetween(
            marker1.getPosition(),
            marker2.getPosition()
          );

          address.value = await posToAddress({
            lat: marker1.getPosition().lat(),
            lng: marker1.getPosition().lng(),
          });
          destAddress.value = await posToAddress({
            lat: marker2.getPosition().lat(),
            lng: marker2.getPosition().lng(),
          });

          distanceEleme.value = distance;

          infowindow.setContent(
            "Distance: " +
              distance.toFixed(2) +
              " meters<br>Start: " +
              marker1.getPosition() +
              "<br>End: " +
              marker2.getPosition()
          );
          infowindow.open(map, marker1);
        });

        google.maps.event.addListener(marker2, "dragend", async function () {
          infowindow.close();
          distance = google.maps.geometry.spherical.computeDistanceBetween(
            marker1.getPosition(),
            marker2.getPosition()
          );

          address.value = await posToAddress({
            lat: marker1.getPosition().lat(),
            lng: marker1.getPosition().lng(),
          });
          destAddress.value = await posToAddress({
            lat: marker2.getPosition().lat(),
            lng: marker2.getPosition().lng(),
          });

          distanceEleme.value = distance;

          infowindow.setContent(
            "Distance: " +
              distance.toFixed(2) +
              " meters<br>Start: " +
              marker1.getPosition() +
              "<br>End: " +
              marker2.getPosition()
          );
          infowindow.open(map, marker1);
        });
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?libraries=geometry&key=AIzaSyDdp7PgVbhs7cnIvLgNq1HKWtNgmYaHtfI&callback=initMap"></script>
  </body>
</html>
