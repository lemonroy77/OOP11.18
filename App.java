class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public void move() {
        System.out.println("Animal move");
    }
}
    class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void attack() {
        System.out.println("狗攻击");
    }
}
class ZangAo extends Dog {
    public ZangAo(String name) {
        super(name);
    }

    public void zangAoAttack() {
        System.out.println("藏獒攻击");
    }
}
public class App {
    public static void main(String[] args) {
        ZangAo zangAo = new ZangAo("藏獒");
        zangAo.move();
        zangAo.attack();
    }
}
