package com.example.trackersystem.Controller;


import com.example.trackersystem.APIResponse.APIResponse;
import com.example.trackersystem.Model.Tracke;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/tracker")

public class TrackerController {

    ArrayList<Tracke> trackes = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Tracke> getTrackes() {
        return trackes;
    }


    @PostMapping("/add")
    public APIResponse addTracke(@RequestBody Tracke tracke) {
        trackes.add(tracke);
        return new APIResponse("tracker added", 200);

    }


    @PutMapping("/update/{index}")
    public APIResponse updatTracke(@PathVariable int index, @RequestBody Tracke tracke) {
        trackes.set(index, tracke);
        return new APIResponse("tracker updated", 200);


    }

    @DeleteMapping("/delete/{index}")
    public APIResponse deleteTracke(@PathVariable int index) {
        trackes.remove(index);
        return new APIResponse("tracker deleted", 200);


    }




    @PutMapping("/change/{index}")
    public APIResponse changestatus(@PathVariable int index) {

        if (index <= trackes.size()){

      if( trackes.get(index).getStatus().equals("done")){
      trackes.get(index).setStatus("not done");}

      else if( trackes.get(index).getStatus().equals("not done")){
          trackes.get(index).setStatus("done");}

                    return new APIResponse("Change the task status", 200);
                }
        return new APIResponse("Not found", 404);
    }




    @GetMapping("/search/{task}")
    public APIResponse searchTask(@PathVariable String task) {
        for (Tracke t : trackes) {
            if (t.getTitle().equals(task)) {
                return new APIResponse("Found", 200);
            }

        }
        return new APIResponse("Not Found", 404);
    }
    }






