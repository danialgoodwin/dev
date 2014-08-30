/** An immutable class representing a pair of latitude and longitude coordinates, stored as degrees.
 *  
 *  This is modeled after: com.google.android.gms.maps.model.LatLng;
 *  
 *  More info: http://developer.android.com/reference/com/google/android/gms/maps/model/LatLng.html
 *  More info to implement more proper features: http://developer.android.com/reference/java/lang/Object.html
 */
public class Location {

    /** Latitude, in degrees. This value is in the range [-90, 90]. */
    private float latitude;
    
    /** Longitude, in degrees. This value is in the range [-180, 180). */
    private float longitude;
    
    /** Constructs a Location with the given latitude and longitude, measured in degrees.
     * 
     *  @param latitude The point's latitude. This will be clamped to between -90 degrees and +90 degrees inclusive.
     *  @param longitude The point's longitude. This will be normalized to be within -180 degrees inclusive and +180 degrees exclusive.
     *  */
    public Location(float latitude, float longitude) {
        this.latitude = clampLatitude(latitude);
        this.longitude = normalizeLongitude(longitude);
    }

    /** Returns a valid latitude, in degrees, in the range [-90, 90]. */
    public float getLatitude() {
        return latitude;
    }
    
    /** Returns a valid longitude, in degrees, in the range [-180, 180). */
    public float getLongitude() {
        return latitude;
    }
    
    
    
    /** Returns a valid latitude in the range [-90, 90].
     * 
     * @hide */
    private static final float clampLatitude(float latitude) {
        return clamp(latitude, -90.0f, 90.0f);
    }
    
    /** Returns value between the min and max.
     * 
     *  @hide */
    private static final float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }
    
    /** Returns value between the min and max.
     * 
     * Note: This method allows primitives but they will be boxed/unboxed.
     * 
     *  @hide */
//  private static <T extends Comparable<T>> T clamp(T val, T min, T max) {
//      if (val.compareTo(min) < 0) return min;
//      else if(val.compareTo(max) > 0) return max;
//      else return val;
//  }
    
    /** Returns a valid longitude in the range [-180, 180).
     * 
     *  @hide */
    private static final float normalizeLongitude(float longitude) {
        return ((longitude + 180) % 360) - 180;
    }



    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     * 
     * This was auto-generated via Eclipse.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(latitude);
        result = prime * result + Float.floatToIntBits(longitude);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     * 
     * This was auto-generated via Eclipse.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location other = (Location) obj;
        if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude)) {
            return false;
        }
        return true;
    }
    
}
