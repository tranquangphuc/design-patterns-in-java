package com.tranquangphuc.java.designpatterns.state.motor;

public class Motorcycle {
  private MotorcycleState state = MotorcycleState.STOPPED;

  public MotorcycleState getState() {
    return state;
  }

  public void fill() {
    state = state.fill();
  }

  public void onSideStanding() {
    state = state.onSideStanding();
  }

  public void offSideStanding() {
    state = state.offSideStanding();
  }

  public void onCenterStanding() {
    state = state.onCenterStanding();
  }

  public void offCenterStanding() {
    state = state.offCenterStanding();
  }

  public void rev() {
    state = state.rev();
  }

  public void brake() {
    state = state.brake();
  }

  public static void main(String[] args) {
    Motorcycle motorcycle = new Motorcycle();
    motorcycle.offCenterStanding();
    motorcycle.offSideStanding();
    motorcycle.rev();
    motorcycle.rev();
    motorcycle.rev();
    motorcycle.rev();
    motorcycle.brake();
    motorcycle.brake();
    motorcycle.brake();
    motorcycle.brake();
    motorcycle.fill();
    motorcycle.onSideStanding();
    motorcycle.onCenterStanding();
  }
}
