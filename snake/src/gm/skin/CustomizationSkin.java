package gm.skin;

import java.net.URL;

public class CustomizationSkin extends SkinEntity implements SkinInterface{
    public CustomizationSkin(URL headerUrl) {
        skinType(headerUrl,null,null);
    }
    public CustomizationSkin(URL headerUrl,URL bodyUrl) {
        skinType(headerUrl,bodyUrl,null);
    }
    public CustomizationSkin(URL headerUrl,URL bodyUrl,URL foodUrl) {
        skinType(headerUrl,bodyUrl,foodUrl);
    }

    @Override
    public void skinType(URL headerUrl,URL bodyUrl,URL foodUrl) {
        setHeader(headerUrl);
        setBody(bodyUrl);
        setFood(foodUrl);
    }
}
