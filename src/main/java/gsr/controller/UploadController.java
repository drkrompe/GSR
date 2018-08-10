package gsr.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import gsr.model.SqlResponse;
import gsr.repository.Connect;

@RestController
public class UploadController {

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public UploadResponse upload(){
//        Connect connect = new Connect();
//        String val = connect.runQuery("SELECT * FROM texttable");
//        return new UploadResponse(true, val, 1);
//    }

    @RequestMapping(value = "/db", method = RequestMethod.POST)
    public SqlResponse query(@RequestBody(required = true) String request){
        System.out.println(request);
        Connect db = new Connect();
        return db.runInsert(request);
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public SqlResponse returnAll(){
        System.out.println("Returning all records");
        return new Connect().runQuery("SELECT * FROM text");
    }

}
