package controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public final class Resources {
  public static final String CREDENTIALS_FILE_PATH = "./src/main/resources/credentials.json";

  public static Object[][] readSuccessJsonCredentials() {

    Object[][] credData = null;

    try {
      JSONObject jsonObject =
          (JSONObject) new JSONParser().parse(new FileReader(CREDENTIALS_FILE_PATH));

      JSONArray jsonArray = (JSONArray) jsonObject.get("correct");

      credData = new Object[jsonArray.size()][2];

      for (int i = 0; i < jsonArray.size(); i++) {
        JSONObject obj = (JSONObject) jsonArray.get(i);

        credData[i][0] = obj.get("username");
        credData[i][1] = obj.get("password");
      }

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }

    return credData;
  }
}
