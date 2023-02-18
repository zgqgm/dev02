package gm.skin;

import java.net.URL;

public class DefaultSkin extends SkinEntity implements SkinInterface{
    public DefaultSkin() {
        skinType(null,null,null);
    }

    @Override
    public void skinType(URL headerUrl, URL bodyUrl, URL foodUrl) {
        setHeader(headerUrl);
        setBody(bodyUrl);
        setFood(foodUrl);
    }
}
