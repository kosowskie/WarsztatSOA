package pl.kosowski.warsztatpojazdysoa.model;

public class Car {
    private Long id;
    private String mark;
    private String model;
    private String bodyKit;//nadwozie
    private String fuelType;
    private Long engineCapacity;
    private Long enginePower;
    private String prodYear;
    private String countryProd;
    private String colour;
    private String vin;
    private Double fuelUsage;
    private String gearBoxType;
    private String gearBoxLevel;
    private String serviceNeeded;

    public Car() {
    }

    public Car(String mark, String model, String bodyKit, String fuelType, Long engineCapacity, Long enginePower, String prodYear, String countryProd, String colour, String vin, Double fuelUsage, String gearBoxType, String gearBoxLevel, String serviceNeeded) {
        this.mark = mark;
        this.model = model;
        this.bodyKit = bodyKit;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.prodYear = prodYear;
        this.countryProd = countryProd;
        this.colour = colour;
        this.vin = vin;
        this.fuelUsage = fuelUsage;
        this.gearBoxType = gearBoxType;
        this.gearBoxLevel = gearBoxLevel;
        this.serviceNeeded = serviceNeeded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyKit() {
        return bodyKit;
    }

    public void setBodyKit(String bodyKit) {
        this.bodyKit = bodyKit;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Long getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Long engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Long getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Long enginePower) {
        this.enginePower = enginePower;
    }

    public String getProdYear() {
        return prodYear;
    }

    public void setProdYear(String prodYear) {
        this.prodYear = prodYear;
    }

    public String getCountryProd() {
        return countryProd;
    }

    public void setCountryProd(String countryProd) {
        this.countryProd = countryProd;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(Double fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public String getGearBoxType() {
        return gearBoxType;
    }

    public void setGearBoxType(String gearBoxType) {
        this.gearBoxType = gearBoxType;
    }

    public String getGearBoxLevel() {
        return gearBoxLevel;
    }

    public void setGearBoxLevel(String gearBoxLevel) {
        this.gearBoxLevel = gearBoxLevel;
    }

    public String getServiceNeeded(){return serviceNeeded;}

    public void setServiceNeeded(String serviceNeeded){this.serviceNeeded = serviceNeeded; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", bodyKit='" + bodyKit + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", enginePower=" + enginePower +
                ", prodYear=" + prodYear +
                ", countryProd='" + countryProd + '\'' +
                ", colour='" + colour + '\'' +
                ", vin=" + vin +
                ", fuelUsage=" + fuelUsage +
                ", gearBoxType='" + gearBoxType + '\'' +
                ", gearBoxLevel='" + gearBoxLevel + '\'' +
                '}';
    }

}