package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    //implement this class
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getcloneWheelList(wheels);
        this.engine = getCloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getcloneWheelList(wheels);
    }

    private List<Wheel> getcloneWheelList(List<Wheel> wheels) {
        List<Wheel> newWheel = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheel.add(wheel.clone());
        }
        return newWheel;
    }

    public Engine getEngine() {
        return getCloneEngine(engine);
    }

    private Engine getCloneEngine(Engine engine) {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {

        List<Wheel> wheel = new ArrayList<>(wheels);//.add(newWheel);
        wheel.add(newWheel);
        return new Car(year, color, wheel, engine);
    }

    @Override
    public String toString() {
        return "Car{"
                    + "year=" + year
                    + ", color='" + color + '\''
                    + ", wheels=" + wheels
                    + ", engine=" + engine
                    + '}';
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year
                    && Objects.equals(color, car.color)
                    && Objects.equals(wheels, car.wheels)
                    && Objects.equals(engine, car.engine);

    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}
