package com.tranquangphuc.java.designpatterns.state.bike;

import java.util.concurrent.atomic.AtomicReference;

public class Bike {
  private final AtomicReference<BikeState> operation =
      new AtomicReference<>(BikeState.STOPPED);

  public Bike() {
    System.out.println("Motorbike");
  }

  public AtomicReference<BikeState> getOperation() {
    return operation;
  }

  public void fillUp() {
    this.operation.get().fillUp(this);
  }

  public void sideStand() {
    this.operation.get().onSideStand(this);
  }

  public void centerStand() {
    this.operation.get().onCenterStand(this);
  }

  public void brake() {
    this.operation.get().brake(this);
  }

  public void rev() {
    this.operation.get().revEngine(this);
  }

  public static void main(String[] args) {
    Bike m = new Bike();
    m.fillUp();
    m.rev();
    m.rev();
    m.rev();
    m.rev();
    m.brake();
    m.brake();
    m.brake();
    m.sideStand();
    m.centerStand();
  }
}
