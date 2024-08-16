package com.cbfacademy.restapiexercise;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.restapiexercise.IOU;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/ious")
/* 
* Any request URI handled by this class will start with "/api/ious"
*/
public class IOUController {
  private IOUService iouService;

  public IOUController(IOUService iouService) {
    this.iouService = iouService;
  }
  
  // Retrieve a list of all IOUs
  @GetMapping(produces = "application/json")
  public List<IOU> getAllIOUs() {
    return iouService.getAllIOUs();
  }

  // Retrieve a specific IOU by its ID
  @GetMapping(path = "/{id}", produces = "application/json")
  public IOU getIou(@PathVariable UUID id) {
    return iouService.getIOU(id);
  }

  // Create a new IOU
  @PostMapping(produces = "application/json")
  public ResponseEntity<IOU> createIou(@RequestBody IOU iou) {
    IOU createdIou = iouService.createIOU(iou);
    return new ResponseEntity<>(createdIou, HttpStatus.CREATED);
  }


  // Update an existing IOU by its ID
  @PutMapping(path = "/{id}", produces = "application/json")
  public IOU updateIou(@PathVariable UUID id, @RequestBody IOU iou) {
    return iouService.updateIOU(id, iou);
  }

  // Delete an existing IOU by its ID
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteIou(@PathVariable UUID id) {
    iouService.deleteIOU(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT).notFound().build();
    
  }

  // @DeleteMapping(path = "/{id}")
  // public void deleteIou(@PathVariable UUID id) {
  //   iouService.deleteIOU(id);
  // }


  
}
