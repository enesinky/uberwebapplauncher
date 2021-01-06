
# Uber Web App Launcher Library

This library helps Android developers to perform Uber functionality by using Uber's Web App.
Target users are those who weren't installed Uber native app on their devices.

The library helps to continue Uber actions by web browser.


# Example

**Route:**
from Uber HQ to San Francisco Museum of Modern Art

Java:

    UberWebAppLauncher uberWebAppLauncher = new UberWebAppLauncher()  
     .setPickupLocation(37.775837823803705, -122.41803507478294, "1455 Market St #400, San Francisco, CA 94103, United States", "Uber HQ")  
     .setDropoffLocation(37.78618285698499, -122.40003724864789, "151 3rd St, San Francisco, CA 94103, United States", "San Francisco Museum of Modern Art")  
     .build();  
      
    Intent intent = new Intent(Intent.ACTION_VIEW, uberWebAppLauncher.getUri());  
    startActivity(intent);


Kotlin:

    val uberWebAppLauncher: UberWebAppLauncher = UberWebAppLauncher()  
     .setPickupLocation(37.775837823803705, -122.41803507478294, "1455 Market St #400, San Francisco, CA 94103, United States", "Uber HQ")  
     .setDropoffLocation(37.78618285698499, -122.40003724864789, "151 3rd St, San Francisco, CA 94103, United States", "San Francisco Museum of Modern Art")  
     .build()  
     
    val intent = Intent(Intent.ACTION_VIEW, uberWebAppLauncher.getUri())  
    startActivity(intent)


# Reference

# class UberWebAppLauncher

## **setPickupLocation**(*double pickupLat, double pickupLon, String pickupAddress, String pickupNickname*)


## **setDropoffLocation**(*double dropoffLat, double dropoffLon, String dropoffAddress, String dropoffNickname*

## **build()**


## **getUri()**
