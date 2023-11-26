// 定义坦克类
class Tank {
    String tankType;

    public Tank(String tankType) {
        this.tankType = tankType;
    }

    public void attack(String target) {
        System.out.println(tankType + " tank attacks " + target + " with a cannon.");
    }
}

// 定义不同类型的坦克
class LaserTank extends Tank {
    public LaserTank() {
        super("Laser");
    }

    public void attack(String target) {
        System.out.println(tankType + " tank attacks " + target + " with a laser beam.");
    }
}

class HeavyTank extends Tank {
    public HeavyTank() {
        super("Heavy");
    }

    public void attack(String target) {
        System.out.println(tankType + " tank attacks " + target + " with a heavy cannon.");
    }
}

class LightTank extends Tank {
    public LightTank() {
        super("Light");
    }

    public void attack(String target) {
        System.out.println(tankType + " tank attacks " + target + " with a light cannon.");
    }
}

// 定义士兵类
class Soldier {
    String soldierType;

    public Soldier(String soldierType) {
        this.soldierType = soldierType;
    }

    public void attack(String target) {
        System.out.println(soldierType + " attacks " + target + " with a rifle.");
    }
}

// 定义不同类型的士兵
class FlyingSoldier extends Soldier {
    public FlyingSoldier() {
        super("Flying soldier");
    }

    public void attack(String target) {
        System.out.println(soldierType + " attacks " + target + " with a machine gun.");
    }
}

class HeavySoldier extends Soldier {
    public HeavySoldier() {
        super("Heavy soldier");
    }

    public void attack(String target) {
        System.out.println(soldierType + " attacks " + target + " with a rocket launcher.");
    }
}

// 定义飞机类
class Plane {
    String planeType;

    public Plane(String planeType) {
        this.planeType = planeType;
    }

    public void attack(String target) {
        System.out.println(planeType + " attacks " + target + " with bombs.");
    }
}

// 定义不同类型的飞机
class Bomber extends Plane {
    public Bomber() {
        super("Bomber");
    }

    public void attack(String target) {
        System.out.println(planeType + " attacks " + target + " with a bomb load.");
    }
}

class Fighter extends Plane {
    public Fighter() {
        super("Fighter");
    }

    public void attack(String target) {
        System.out.println(planeType + " attacks " + target + " with missiles.");
    }
}

class Helicopter extends Plane {
    public Helicopter() {
        super("Helicopter");
    }

    public void attack(String target) {
        System.out.println(planeType + " attacks " + target + " with rockets.");
    }
}

public class Game {
    public static void main(String[] args) {
        Tank tank1 = new LaserTank();
        Tank tank2 = new HeavyTank();
        Tank tank3 = new LightTank();

        Soldier soldier1 = new Soldier("Infantry");
        Soldier soldier2 = new FlyingSoldier();
        Soldier soldier3 = new HeavySoldier();

        Plane plane1 = new Bomber();
        Plane plane2 = new Fighter();
        Plane plane3 = new Helicopter();

        String[] targets = {"enemy tank", "enemy soldier", "enemy base"};

        for (Tank tank : new Tank[]{tank1, tank2, tank3}) {
            for (String target : targets) {
                tank.attack(target);
            }
        }

        for (Soldier soldier : new Soldier[]{soldier1, soldier2, soldier3}) {
            for (String target : targets) {
                soldier.attack(target);
            }
        }

        for (Plane plane : new Plane[]{plane1, plane2, plane3}) {
            for (String target : targets) {
                plane.attack(target);
            }
        }
    }
}
