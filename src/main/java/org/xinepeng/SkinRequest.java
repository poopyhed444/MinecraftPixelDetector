package org.xinepeng;

import com.google.gson.JsonParser;
import java.util.Base64;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class SkinRequest {

    public static String UUIDGrabber(String username) throws IOException {
        String url = "https://api.mojang.com/users/profiles/minecraft/" + username;
        URL obj = new URL(url);
        Scanner scanner = new Scanner(obj.openStream(), "UTF-8").useDelimiter("\\A");
        String response = scanner.hasNext() ? scanner.next() : "";
        scanner.close();
        JsonParser parser = new JsonParser();
        String uuid = parser.parse(response).getAsJsonObject().get("id").getAsString();
        String url2 = "https://sessionserver.mojang.com/session/minecraft/profile/" + uuid;
        URL obj2 = new URL(url2);
        Scanner scanner2 = new Scanner(obj2.openStream(), "UTF-8").useDelimiter("\\A");
        String response2 = scanner2.hasNext() ? scanner2.next() : "";
        scanner2.close();
        String skin = parser.parse(response2).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject().get("value").getAsString();
        byte decoder[] = Base64.getDecoder().decode(skin);
        String skin2 = new String(decoder);
        String skin3 = parser.parse(skin2).getAsJsonObject().get("textures").getAsJsonObject().get("SKIN").getAsJsonObject().get("url").getAsString();
        return skin3;
    }

}