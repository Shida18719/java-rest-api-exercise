package com.cbfacademy.restapiexercise;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class IOUService {
  
  private IOURepository iouRepository;

  public IOUService(IOURepository iouRepository) {
    this.iouRepository = iouRepository;
  }

  public List<IOU> getAllIOUs() {
    return this.iouRepository.findAll();
  }

  public IOU getIOU(UUID id) throws NoSuchElementException {
    return this.iouRepository.findById(id).orElseThrow();
  }

  public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
    return this.iouRepository.save(iou);
  }

  public IOU updateIOU(UUID id, IOU iou) throws NoSuchElementException {
    return this.iouRepository.save(iou);
  }

  public void deleteIOU(UUID id) {
    this.iouRepository.delete(getIOU(id));
  }

}
