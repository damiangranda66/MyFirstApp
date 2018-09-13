package pl.MyFirstSpring.MyFirstApp.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class MainController {

    @GetMapping(path = "/getJSONArray", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> home() {
        JSONArray entity = null;
        try {
            entity = getJSONObjectFromFile("C:\\Users\\Damian\\Desktop\\MyFirstApp\\src\\main\\resources\\json\\training.json");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>(entity.toString(), HttpStatus.OK);
    }

    @GetMapping(path = "/getJSON", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> home2() {
        JSONObject entity = null;
        try {
            entity = getJSONObjectFromFile2("C:\\Users\\Damian\\Desktop\\MyFirstApp\\src\\main\\resources\\json\\training2.json");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>(entity.toString(), HttpStatus.OK);
    }

    private JSONArray getJSONObjectFromFile(String path) throws IOException, JSONException {
        String filename = path;
        JSONArray jsonObject = parseJSONFile(filename);
        return jsonObject;
    }

    private static JSONArray parseJSONFile(String filename) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONArray(content);
    }

    private JSONObject getJSONObjectFromFile2(String path) throws IOException, JSONException {
        String filename = path;
        JSONObject jsonObject = parseJSONFile2(filename);
        return jsonObject;
    }

    private static JSONObject parseJSONFile2(String filename) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONObject(content);
    }
}
