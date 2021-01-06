package com.enesinky.uberwebapplauncher;

import android.net.Uri;
import androidx.annotation.RequiresApi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RequiresApi(19)
public final class UberWebAppLauncher {
    private String pickupAddress = "";
    private String pickupNickname = "";
    private String dropoffAddress = "";
    private String dropoffNickname = "";
    private double pickupLat;
    private double pickupLon;
    private double dropoffLat;
    private double dropoffLon;
    private Uri uri;

    public final UberWebAppLauncher setPickupLocation(double pickupLat, double pickupLon, String pickupAddress, String pickupNickname) {
        this.pickupLat = pickupLat;
        this.pickupLon = pickupLon;
        this.pickupAddress = pickupAddress;
        this.pickupNickname = pickupNickname;
        return this;
    }

    public final UberWebAppLauncher setDropoffLocation(double dropoffLat, double dropoffLon, String dropoffAddress, String dropoffNickname) {
        this.dropoffLat = dropoffLat;
        this.dropoffLon = dropoffLon;
        this.dropoffAddress = dropoffAddress;
        this.dropoffNickname = dropoffNickname;
        return this;
    }

    public final UberWebAppLauncher build() {
        String pn = null;
        String pa = null;
        String dn = null;
        String da = null;
        try {
            pn = URLEncoder.encode(this.pickupNickname, StandardCharsets.UTF_8.toString());
            pa = URLEncoder.encode(this.pickupAddress, StandardCharsets.UTF_8.toString());
            dn = URLEncoder.encode(this.dropoffNickname, StandardCharsets.UTF_8.toString());
            da = URLEncoder.encode(this.dropoffAddress, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder()
                .append("https://m.uber.com/?action=setPickup&pickup%5Blatitude%5D=")
                .append(this.pickupLat)
                .append("&pickup%5Blongitude%5D=")
                .append(this.pickupLon)
                .append("&pickup%5Bnickname%5D=")
                .append(pn)
                .append("&pickup%5Bformatted_address%5D=")
                .append(pa)
                .append("&dropoff%5Bnickname%5D=")
                .append(dn)
                .append("&dropoff%5Bformatted_address%5D=")
                .append(da)
                .append("&dropoff%5Blatitude%5D=")
                .append(this.dropoffLat)
                .append("&dropoff%5Blongitude%5D=")
                .append(this.dropoffLon);
        this.uri = Uri.parse(sb.toString());
        return this;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
