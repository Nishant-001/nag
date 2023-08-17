package car.insurance;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static Car getNewCar()
	{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Details of the New car");
			System.out.println("Enter Model in YYYY format");
			String model=sc.next();
			while(Integer.parseInt(model)>=2022 || Integer.parseInt(model)<=1900)
			{
				System.out.println("Enter Valid Car Model");
				System.out.println("Enter Model in YYYY format");
				model=sc.next();
			}
			System.out.println("Enter Car Type");
			String carType=sc.next();
			while((!carType.equalsIgnoreCase("hatchback"))&&(!carType.equalsIgnoreCase("sedan"))&&(!carType.equalsIgnoreCase("suv")))
			{
				System.out.println("Enter Valid Car Type");
				System.out.println("Enter Car Type"+carType);
				carType=sc.next();
			}
			System.out.println("Enter Car Price");
			double price=sc.nextDouble();
			System.out.println("Enter Insurance Type");
			String insuranceType=sc.next();
			while(!insuranceType.equalsIgnoreCase("premium")&& !insuranceType.equalsIgnoreCase("basic"))
			{
				System.out.println("Enter Valid insurance type");
				System.out.println("Enter Insurance Type");
				insuranceType=sc.next();
			}
			
			Car temp=new Car(model,carType,price,insuranceType);
			temp.calInsurance();
			return temp;
		
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Car> cars=new ArrayList<>();
		cars.add(getNewCar());
		char ch='y';
		while(ch=='y')
		{
			System.out.println("Do you want to enter details of any other car (y/n):");
			ch=sc.next().charAt(0);
			if(ch=='n')
				continue;
			
			cars.add(getNewCar());
		}
		
		System.out.println("Below are the car insurance cost details");
		for(Car car: cars)
		{
			System.out.println("Model                :"+car.carModel);
			System.out.println("Car Price            :"+car.carCostPrice);
			System.out.println("Insurance to be Paid :"+car.insuranceCost);
			
			System.out.println();
			System.out.println();
		}

	}

}
