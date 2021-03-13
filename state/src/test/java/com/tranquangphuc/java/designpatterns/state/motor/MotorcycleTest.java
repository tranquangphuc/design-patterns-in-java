package com.tranquangphuc.java.designpatterns.state.motor;

import org.junit.jupiter.api.Test;

import static com.tranquangphuc.java.designpatterns.state.motor.MotorcycleState.*;
import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

  @Test
  void testLifecycle() {
    Motorcycle motorcycle = new Motorcycle();
    assertEquals(STOPPED, motorcycle.getState());
    motorcycle.rev();
    assertEquals(TOOTLING, motorcycle.getState());
    motorcycle.rev();
    assertEquals(CRUISING, motorcycle.getState());
    motorcycle.rev();
    assertEquals(RACING, motorcycle.getState());
    motorcycle.rev();
    assertEquals(RACING, motorcycle.getState());
    motorcycle.brake();
    assertEquals(CRUISING, motorcycle.getState());
    motorcycle.brake();
    assertEquals(TOOTLING, motorcycle.getState());
    motorcycle.brake();
    assertEquals(STOPPED, motorcycle.getState());
    motorcycle.fill();
    assertEquals(STOPPED, motorcycle.getState());
    motorcycle.onSideStanding();
    assertEquals(SIDE_STANDING, motorcycle.getState());
    motorcycle.onCenterStanding();
    assertEquals(CENTER_STANDING, motorcycle.getState());
  }

  @Test
  void testCannotFillWhileDriving() {
    Motorcycle motorcycle = new Motorcycle();
    motorcycle.rev();
    assertThrows(IllegalStateException.class, motorcycle::fill);
    motorcycle.rev();
    assertThrows(IllegalStateException.class, motorcycle::fill);
    motorcycle.rev();
    assertThrows(IllegalStateException.class, motorcycle::fill);
    motorcycle.rev();
    assertThrows(IllegalStateException.class, motorcycle::fill);
  }
}
