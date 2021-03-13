package com.tranquangphuc.java.designpatterns.state.bike;

public enum BikeState {
  CENTER_STANDING {
    @Override
    public void fillUp(Bike m) {
      System.out.println("Fuel filled");
    }

    @Override
    public void onSideStand(Bike m) {
      System.out.println("On Side Standing");
      m.getOperation().compareAndSet(this, SIDE_STANDING);
      System.out.println(" (side standing)");
    }
  },
  SIDE_STANDING {
    @Override
    public void fillUp(Bike m) {
      System.out.println("Fuel filled");
    }

    @Override
    public void onCenterStand(Bike m) {
      System.out.println("On Center Standing");
      m.getOperation().compareAndSet(this, CENTER_STANDING);
      m.getOperation().compareAndSet(STOPPED, CENTER_STANDING);
      System.out.println(" (center standing)");
    }
  },
  STOPPED {
    @Override
    public void fillUp(Bike m) {
      System.out.println("Fuel filled");
    }

    @Override
    public void onCenterStand(Bike m) {
      System.out.println("On Center Standing");
      m.getOperation().compareAndSet(this, CENTER_STANDING);
      System.out.println(" (center standing)");
    }

    @Override
    public void onSideStand(Bike m) {
      System.out.println("On Side Standing");
      m.getOperation().compareAndSet(this, SIDE_STANDING);
      System.out.println(" (side standing)");
    }

    @Override
    public void revEngine(Bike m) {
      System.out.println("Revving");
      m.getOperation().compareAndSet(this, TOOTLING);
      System.out.println(" stopped -(tootling)- cruising - racing ");
    }
  },
  TOOTLING {
    @Override
    public void brake(Bike m) {
      System.out.println("Braking");
      m.getOperation().compareAndSet(this, STOPPED);
      System.out.println("(stopped)- tootling - cruising - racing ");
    }

    @Override
    public void revEngine(Bike m) {
      System.out.println("Revving");
      m.getOperation().compareAndSet(this, CRUISING);
      System.out.println(" stopped - tootling -(cruising)- racing ");
    }
  },
  CRUISING {
    @Override
    public void brake(Bike m) {
      System.out.println("Braking");
      m.getOperation().compareAndSet(this, TOOTLING);
      System.out.println(" stopped -(tootling)- cruising - racing ");
    }

    @Override
    public void revEngine(Bike m) {
      System.out.println("Revving");
      m.getOperation().compareAndSet(this, RACING);
      System.out.println(" stopped - tootling - cruising -(racing)");
    }
  },
  RACING {
    @Override
    public void brake(Bike m) {
      System.out.println("Braking");
      m.getOperation().compareAndSet(this, CRUISING);
      System.out.println(" stopped - tootling -(cruising)- racing ");
    }
  };

  public void fillUp(Bike m) {
    System.out.println("Cannot Fill Up");
  }

  public void onSideStand(Bike m) {
    System.out.println("Cannot Side Stand");
  }

  public void offSideStand(Bike m) {
    System.out.println("Cannot Off Side Stand");
  }

  public void onCenterStand(Bike m) {
    System.out.println("Cannot Center Stand");
  }

  public void offCenterStand(Bike m) {
    System.out.println("Cannot Off Center Stand");
  }

  public void brake(Bike m) {
    System.out.println("Cannot Brake");
  }

  public void revEngine(Bike m) {
    System.out.println("Cannot Rev");
  }
}
