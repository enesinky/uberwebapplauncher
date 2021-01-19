![Latest Version](https://img.shields.io/badge/latestVersion-1.0-yellow) ![Platform](https://img.shields.io/badge/platform-Android-green) ![Java](https://img.shields.io/badge/language-java-blue) ![Minimum SDK Version](https://img.shields.io/badge/minSDK-19-orange) 

# Uber Web App Launcher Library

This Android Java library allows developers integrate Uber Ride Request activity using web browser.
App users can be redirected to web browser and Uber Ride Request page will be loaded with specified Pickup/Dropoff locations.

### Features:

 - Your Android app opens Uber request ride page on web browser.
 - Users are **NOT** redirected to download app from Play Store.
 - Uber Android app is not required to perform this action.
 - Compatible with **Huawei Mobile Services**.

# Example

**Route:**
from Uber HQ to San Francisco Museum of Modern Art

Java:
```java
    UberWebAppLauncher uberWebAppLauncher = new UberWebAppLauncher()  
     .setPickupLocation(37.775837823803705, -122.41803507478294, "1455 Market St #400, San Francisco, CA 94103, United States", "Uber HQ")  
     .setDropoffLocation(37.78618285698499, -122.40003724864789, "151 3rd St, San Francisco, CA 94103, United States", "San Francisco Museum of Modern Art")  
     .build();  
      
    Intent intent = new Intent(Intent.ACTION_VIEW, uberWebAppLauncher.getUri());  
    startActivity(intent);
```

Kotlin:
```kotlin
    val uberWebAppLauncher: UberWebAppLauncher = UberWebAppLauncher()  
     .setPickupLocation(37.775837823803705, -122.41803507478294, "1455 Market St #400, San Francisco, CA 94103, United States", "Uber HQ")  
     .setDropoffLocation(37.78618285698499, -122.40003724864789, "151 3rd St, San Francisco, CA 94103, United States", "San Francisco Museum of Modern Art")  
     .build()  
     
    val intent = Intent(Intent.ACTION_VIEW, uberWebAppLauncher.getUri())  
    startActivity(intent)
```
__

**Output Uri:**

**[Go To Request Ride](https://m.uber.com/looking?drop=%7B%22latitude%22:37.78618285698499,%22longitude%22:-122.40003724864789,%22addressLine1%22:%22San%20Francisco%20Museum%20of%20Modern%20Art%22%7D&pickup=%7B%22latitude%22:37.775837823803705,%22longitude%22:-122.41803507478294,%22addressLine1%22:%22Uber%20HQ%22%7D&vehicle=3bb777a3-7072-4d8c-a8b6-0cd9dcfe650e)**


__

# Implementation

**Step 1.** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```css
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency
```css
	dependencies {
	        implementation 'com.github.enesinky:uberwebapplauncher:v1.0'
	}
```

# Public Methods
## class UberWebAppLauncher

### **setPickupLocation**(*double pickupLat, double pickupLon, String pickupAddress, String pickupNickname*)

 - pickupLat:  Latitude coordinate for pickup location. 
 - pickupLon: Longitude coordinate for pickup location.
 - pickupAddress: Address line for pickup location. (this value can be set to empty if pickupNickname is provided)
 - pickupNickname: Name of the pickup place. (this value can be set to empty if pickupAddress is provided)

> Priority on Uber's map view: pickupNickname , pickupAddress

### **setDropoffLocation**(*double dropoffLat, double dropoffLon, String dropoffAddress, String dropoffNickname*

 - dropoffLat:  Latitude coordinate for dropoff location. 
 - dropoffLon: Longitude coordinate for dropoff location.
 - dropoffAddress: Address line for dropoff location. (this value can be set to empty if dropoffNickname is provided)
 - dropoffNickname: Name of the dropoff place. (this value can be set to empty if dropoffAddress is provided)

> Priority on Uber's map view: dropoffNickname , dropoffAddress

### **build()**
Creates URI and builds the object

### **getUri()**
Returns URI.


