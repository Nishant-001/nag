package car.insurance;

public class Car {
	String carModel;
	String carType;
	double carCostPrice;
	String insuranceType;
	double insuranceCost;
	public Car(String carModel,String carType,double carCostPrice,String insuranceType) {
		this.carModel=carModel;
		this.carType=carType;
		this.carCostPrice=carCostPrice;
		this.insuranceType=insuranceType;
	}
	
	public void calInsurance()
	{
		if(carType.equals("hatchback"))
		{
			insuranceCost=0.05*carCostPrice;
		}
		else if(carType.equals("sedan"))
		{
			insuranceCost=0.08*carCostPrice;
		}
		else if(carType.equals("suv"))
		{
			insuranceCost=0.1*carCostPrice;
		}
		
		if(insuranceType.equals("premium"));
		insuranceCost+=0.2*insuranceCost;
	}
	

}
