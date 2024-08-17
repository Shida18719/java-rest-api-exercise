package com.cbfacademy.restapiexercise;

import java.util.List;
import java.util.NoSuchElementException;
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
  @GetMapping("/{id}")
  public ResponseEntity<IOU> getIOUById(@PathVariable UUID id) {
      try {
          IOU iou = iouService.getIOU(id);
          return new ResponseEntity<>(iou, HttpStatus.OK);
      } catch (NoSuchElementException e) {
          return new ResponseEntity<>( HttpStatus.NOT_FOUND);
      }
  }

  // Create a new IOU
  @PostMapping(produces = "application/json")
  public ResponseEntity<IOU> createIou(@RequestBody IOU iou) {
    IOU createdIou = iouService.createIOU(iou);
    return new ResponseEntity<>(createdIou, HttpStatus.CREATED);
  }


  // Update an existing IOU by its ID
  @PutMapping(path = "/{id}", produces = "application/json")
  public ResponseEntity<IOU> updateIou(@PathVariable UUID id, @RequestBody IOU iou) {
    try {
      IOU existingIou = iouService.updateIOU(id, iou);
      return new ResponseEntity<>(existingIou, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


// Delete an existing IOU by its ID
  @DeleteMapping(path = "/{id}", produces = "application/json")
  public ResponseEntity<Void> deleteIou(@PathVariable UUID id) {
    try {
        iouService.deleteIOU(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
  
}
