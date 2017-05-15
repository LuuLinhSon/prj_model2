package login;

import java.io.Serializable;

/**
 * Created by Rain Cool on 08-May-17.
 */

public class Picture implements Serializable {

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    private String URL;

}
