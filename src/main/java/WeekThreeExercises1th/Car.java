package WeekThreeExercises1th;

public class Car {
    private String id;
    private int year;
    private String model;
    private String color;
    private int motorSize;

    public void Drive()
    {
        System.out.println(model + "with motor " + motorSize + " can drive now");
    }
    public void setModel(String name)
    {
        this.model = name;
    }
    public void setMotorSize(int cubicVolym)
    {
        this.motorSize = cubicVolym;
    }
    public String getModel()
    {
        return model;
    }
    public int getMotorSize()
    {
        return motorSize;
    }
}
