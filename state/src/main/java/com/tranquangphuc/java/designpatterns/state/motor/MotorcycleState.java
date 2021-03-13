package com.tranquangphuc.java.designpatterns.state.motor;

public enum MotorcycleState {
  CENTER_STANDING {
    @Override
    public MotorcycleState offCenterStanding() {
      System.out.println("Off Center Standing");
      return STOPPED;
    }

    @Override
    public MotorcycleState onSideStanding() {
      System.out.println("On Side Standing");
      return SIDE_STANDING;
    }

    @Override
    public MotorcycleState fill() {
      System.out.println("Filling Fuel");
      return this;
    }
  },
  SIDE_STANDING {
    @Override
    public MotorcycleState offSideStanding() {
      System.out.println("Off Side Standing");
      return STOPPED;
    }

    @Override
    public MotorcycleState onCenterStanding() {
      System.out.println("On Center Standing");
      return CENTER_STANDING;
    }

    @Override
    public MotorcycleState fill() {
      System.out.println("Filling Fuel");
      return this;
    }
  },
  STOPPED {
    @Override
    public MotorcycleState fill() {
      System.out.println("Filling Fuel");
      return this;
    }

    @Override
    public MotorcycleState onSideStanding() {
      System.out.println("On Side Standing");
      return SIDE_STANDING;
    }

    @Override
    public MotorcycleState onCenterStanding() {
      System.out.println("On Center Standing");
      return CENTER_STANDING;
    }

    @Override
    public MotorcycleState brake() {
      System.out.println("Stopped");
      return this;
    }

    @Override
    public MotorcycleState rev() {
      System.out.println("Tootling");
      return TOOTLING;
    }
  },
  TOOTLING {
    @Override
    public MotorcycleState brake() {
      System.out.println("Stopping");
      return STOPPED;
    }

    @Override
    public MotorcycleState rev() {
      System.out.println("Cruising");
      return CRUISING;
    }
  },
  CRUISING {
    @Override
    public MotorcycleState brake() {
      System.out.println("Tootling");
      return TOOTLING;
    }

    @Override
    public MotorcycleState rev() {
      System.out.println("Racing");
      return RACING;
    }
  },
  RACING {
    @Override
    public MotorcycleState brake() {
      System.out.println("Cruising");
      return CRUISING;
    }

    @Override
    public MotorcycleState rev() {
      System.out.println("Zooming");
      return this;
    }
  };

  public MotorcycleState fill() {
    throw new IllegalStateException("Cannot fill");
  }

  public MotorcycleState onSideStanding() {
    throw new IllegalStateException("Cannot On Side Standing");
  }

  public MotorcycleState offSideStanding() {
    System.out.println("Cannot Off Side Standing");
    return this;
  }

  public MotorcycleState onCenterStanding() {
    throw new IllegalStateException("Cannot On Center Standing");
  }

  public MotorcycleState offCenterStanding() {
    System.out.println("Cannot Off Center Standing");
    return this;
  }

  public MotorcycleState rev() {
    throw new IllegalStateException("Cannot Rev");
  }

  public MotorcycleState brake() {
    throw new IllegalStateException("Cannot brake");
  }
}
